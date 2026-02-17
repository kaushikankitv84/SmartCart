package SmartCart.Registration.Registration.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Generated;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "MASTER")
public class MasterEntity {

   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SNO", unique = true, nullable = false)
    private int Sno;

    @Id
    @Column(name = "SMARTCARTID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String smartCartId;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROLES")
    private String roles;

    @Column(name = "INSERT_TMSTMP")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime Insert_tmstmp;

    @Column(name = "UPDATE_TMSTMP")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime Update_tmstmp;

    @OneToOne(mappedBy = "masterEntity", cascade = CascadeType.ALL)
    private UserEntity userEntity;

}
