package SmartCart.Registration.Registration.Controller;

import SmartCart.Registration.Registration.Entity.MasterEntity;
import SmartCart.Registration.Registration.Entity.UserEntity;
import SmartCart.Registration.Registration.Service.MasterService;
import SmartCart.Registration.Registration.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
