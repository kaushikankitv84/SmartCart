package SmartCart.Registration.Registration.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column(name = "FIRST_NAME")
    private String fstName;

    @Column(name = "LAST_NAME")
    private String lstName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USER_TYPE")
    private String usertype;

    @Column(name = "INSERT_TMSTMP")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime Insert_tmstmp;

    @Column(name = "UPDATE_TMSTMP")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime Update_tmstmp;

    @Column(name = "VER_NUM")
    private int ver_num;

    @Column(name = "MOBILE")
    private String mobile;


}
