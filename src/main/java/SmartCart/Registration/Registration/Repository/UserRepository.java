package SmartCart.Registration.Registration.Repository;

import SmartCart.Registration.Registration.Entity.MasterEntity;
import SmartCart.Registration.Registration.Entity.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {


    @Override
    <S extends UserEntity> S save(S entity);

    @Override
    UserEntity getReferenceById(String id);

    @Override
    Optional<UserEntity> findById(String s);

    @Override
    <S extends UserEntity> List<S> findAll(Example<S> example);
}
