package SmartCart.Registration.Registration.Service;

import SmartCart.Registration.Registration.Constants.RegistrationConstants;
import SmartCart.Registration.Registration.Entity.MasterEntity;
import SmartCart.Registration.Registration.Entity.UserEntity;
import SmartCart.Registration.Registration.Repository.MasterRepository;
import SmartCart.Registration.Registration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MasterRepository masterRepository;


    public void createUser(UserEntity user, String id) {
        LocalDateTime now = LocalDateTime.now();
        MasterEntity masterEntity = masterRepository.getMasterEntityBySmartCartId(id);
        user.setMasterEntity(masterEntity);

        //user.setSmartCartId(id);
        user.setFstName(user.getFstName());
        user.setLstName(user.getLstName());
        user.setMobile(user.getMobile());
        user.setEmail(user.getEmail());
        user.setUsertype("USER");
        user.setInsert_tmstmp(LocalDateTime.now());
        user.setUpdate_tmstmp(LocalDateTime.now());
        userRepository.save(user);

    }

    public void updateUser(UserEntity user) {
        LocalDateTime now = LocalDateTime.now();
        user.setInsert_tmstmp(now);
        user.setUpdate_tmstmp(now);
        userRepository.save(user);

    }

    public UserEntity getUserByFirstName(String username) {
        return userRepository.getUserEntityByfstName(username);
    }

    public void UpdateUserById(String id) {
        MasterEntity masterEntityById = masterRepository.getMasterEntityBySmartCartId(id);
        String username = masterEntityById.getUsername();

    }

    public UserEntity findEntityById(String id) {
        return userRepository.getReferenceById(id);
    }


}
