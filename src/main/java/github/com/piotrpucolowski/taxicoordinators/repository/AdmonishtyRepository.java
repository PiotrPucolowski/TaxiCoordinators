package github.com.piotrpucolowski.taxicoordinators.repository;

import github.com.piotrpucolowski.taxicoordinators.model.AdmonishtyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdmonishtyRepository extends JpaRepository<AdmonishtyEntity, Long> {

    //lista przewinien wyszukiwana po numerze kierowcy
    List<AdmonishtyEntity> findByDriver_CarPlate(String carPlate);
}
