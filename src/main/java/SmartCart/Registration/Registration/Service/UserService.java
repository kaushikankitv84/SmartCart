package SmartCart.Registration.Registration.Service;

import SmartCart.Registration.Registration.Entity.UserEntity;
import SmartCart.Registration.Registration.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void save(UserEntity user) {
        LocalDateTime now = LocalDateTime.now();
        user.setInsert_tmstmp(now);
        user.setUpdate_tmstmp(now);
        userRepository.save(user);


    }

    public UserEntity getUserByName(String username) {
        return userRepository.getUserEntityByfstName(username);
    }

    public UserEntity getUserById(String id) {
        return userRepository.getById(Integer.valueOf(id));
    }


}
