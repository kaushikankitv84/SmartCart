package SmartCart.Registration.Registration.Service;


import SmartCart.Registration.Registration.Constants.RegistrationConstants;
import SmartCart.Registration.Registration.Entity.MasterEntity;
import SmartCart.Registration.Registration.Repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

@Service
public class MasterService {

    private static final PasswordEncoder passswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private MasterRepository masterRepository;

    public void save(MasterEntity master) {

        master.setPassword(passswordEncoder.encode(master.getPassword()));

        master.setInsert_tmstmp(LocalDateTime.now());
        master.setUpdate_tmstmp(LocalDateTime.now());
        master.setRoles("USER");
        masterRepository.save(master);
    }

    public void updateUserById(MasterEntity master, String id) {
        MasterEntity masterInDB = masterRepository.getMasterEntityBySmartCartId(id);
        if (!master.getUsername().isEmpty() && master.getUsername() != null) {
            masterInDB.setUsername(master.getUsername());
        }
        if (!master.getPassword().isEmpty() && master.getPassword() != null) {
            masterInDB.setPassword(master.getPassword());
        }
        master.setUpdate_tmstmp(LocalDateTime.now());

    }

    public MasterEntity getUserByName(String username) {
        return masterRepository.findByUsername(username);
    }

    public MasterEntity findById(String id) {
        return masterRepository.getMasterEntityBySmartCartId(id);
    }
}
