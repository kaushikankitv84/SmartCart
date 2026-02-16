package SmartCart.Registration.Registration.Controller;

import SmartCart.Registration.Registration.Entity.MasterEntity;
import SmartCart.Registration.Registration.Entity.UserPrincipal;
import SmartCart.Registration.Registration.Service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;


    @PostMapping
    public void registerUser(@RequestBody MasterEntity master) {

        masterService.save(master);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody MasterEntity master) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Get the ID directly from the UserPrincipal
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserPrincipal)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user principal");
        }
        UserPrincipal userPrincipal = (UserPrincipal) principal;
        String userId = userPrincipal.getSmartCartId();

        // Update the user with the retrieved ID

        masterService.updateUserById(master,userId);

        return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
    }


}


