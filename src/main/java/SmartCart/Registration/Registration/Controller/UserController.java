package SmartCart.Registration.Registration.Controller;

import SmartCart.Registration.Registration.Entity.UserEntity;
import SmartCart.Registration.Registration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserEntity user) {
        userService.save(user);
    }

    @GetMapping("/{fstName}")
    public UserEntity getUserByName(@PathVariable String fstName) {
        return userService.getUserByName(fstName);

    }

    public UserEntity updateUserById(String id){
        return userService.getUserById(id);
    }
}
