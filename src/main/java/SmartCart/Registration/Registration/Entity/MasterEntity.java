package SmartCart.Registration.Registration.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "MASTER")
public class MasterEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String ID;

    @Column(name = "USERNAME")

    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLES")
    private List<String> roles;

    @Column(name = "INSERT_TMSTMP")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime Insert_tmstmp;

    @Column(name = "UPDATE_TMSTMP")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime Update_tmstmp;


}
