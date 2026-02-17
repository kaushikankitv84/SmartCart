package SmartCart.Registration.Registration.Service;

import SmartCart.Registration.Registration.DTO.UserDTO;
import SmartCart.Registration.Registration.Entity.MasterEntity;
import SmartCart.Registration.Registration.Entity.UserEntity;
import SmartCart.Registration.Registration.Repository.MasterRepository;
import SmartCart.Registration.Registration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

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
        user.setFstName(user.getFstName());
        user.setLstName(user.getLstName());
        user.setMobile(user.getMobile());
        user.setEmail(user.getEmail());
        user.setUsertype("USER");
        user.setInsert_tmstmp(LocalDateTime.now());
        user.setUpdate_tmstmp(LocalDateTime.now());
        userRepository.save(user);

    }

    public void updateUser(UserEntity user, String id) {
        UserEntity userInDB = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        if (user.getFstName() == null || !user.getFstName().isEmpty()) {
            userInDB.setFstName(user.getFstName());
        }
        if (user.getLstName() == null || !user.getLstName().isEmpty()) {
            userInDB.setLstName(user.getLstName());
        }
        if (user.getMobile() == null || !user.getMobile().isEmpty()) {
            userInDB.setMobile(user.getMobile());
        }
        if (user.getEmail() == null || !user.getEmail().isEmpty()) {
            userInDB.setEmail(user.getEmail());
        }
        userInDB.setUpdate_tmstmp(LocalDateTime.now());
        userInDB.setVer_num(userInDB.getVer_num() + 1);
        userRepository.save(userInDB);

    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> all = userRepository.findAll();
        return all.stream().map(this::ConvertToUserDTO).collect(Collectors.toList());
    }

    public UserDTO ConvertToUserDTO(UserEntity userEntity) {
        return new UserDTO(
                userEntity.getMasterEntity().getSmartCartId(),
                userEntity.getFstName(),
                userEntity.getLstName(),
                userEntity.getEmail(),
                userEntity.getMobile(),
                userEntity.getUsertype()
        );
    }


}




