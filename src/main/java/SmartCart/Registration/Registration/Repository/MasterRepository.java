package SmartCart.Registration.Registration.Repository;

import SmartCart.Registration.Registration.Entity.MasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepository extends JpaRepository<MasterEntity,String> {

    @Override
    <S extends MasterEntity> S save(S entity);

    MasterEntity getMasterEntityByUsername(String name);

    MasterEntity findByUsername(String username);

}
