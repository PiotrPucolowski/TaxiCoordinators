package github.com.piotrpucolowski.taxicoordinators.repository;

import github.com.piotrpucolowski.taxicoordinators.model.AdmonishtyEntity;
import github.com.piotrpucolowski.taxicoordinators.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdmonishtyRepository extends JpaRepository<AdmonishtyEntity, Long> {

    //lista przewinien wyszukiwana po kierowcy
    List<AdmonishtyEntity> findByDriverContains(CategoryEntity categoryEntity);
}
