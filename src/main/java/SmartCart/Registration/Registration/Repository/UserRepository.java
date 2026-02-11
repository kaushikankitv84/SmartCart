package SmartCart.Registration.Registration.Repository;

import SmartCart.Registration.Registration.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity getUserEntityByfstName(String name);

    Object getUserEntityByEmail(String email);

    @Override
    <S extends UserEntity> S save(S entity);

    @Override
    UserEntity getById(Integer integer);


}
