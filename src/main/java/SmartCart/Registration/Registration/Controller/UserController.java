package SmartCart.Registration.Registration.Controller;

import SmartCart.Registration.Registration.DTO.UserDTO;
import SmartCart.Registration.Registration.Entity.UserEntity;
import SmartCart.Registration.Registration.Entity.UserPrincipal;
import SmartCart.Registration.Registration.Service.MasterService;
import SmartCart.Registration.Registration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MasterService masterService;


    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authorized");
        }
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserPrincipal)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authorized");
        }
        UserPrincipal userprincipal = (UserPrincipal) principal;
        String id = userprincipal.getSmartCartId();

        userService.createUser(userEntity, id);

        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authorized");
        }
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserPrincipal)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authorized");
        }
        UserPrincipal userPrincipal = (UserPrincipal) principal;
        String id = userPrincipal.getSmartCartId();
        userService.updateUser(user, id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all-users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
}
