package SmartCart.Registration.Registration.Service;


import SmartCart.Registration.Registration.Entity.MasterEntity;
import SmartCart.Registration.Registration.Repository.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MasterService {

    @Autowired
    private MasterRepository masterRepository;

    public void save(MasterEntity master){

        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        master.setInsert_tmstmp(now);
        master.setUpdate_tmstmp(now);
        masterRepository.save(master);


    }
}
