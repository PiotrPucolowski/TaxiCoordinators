package github.com.piotrpucolowski.taxicoordinators.repository;

import github.com.piotrpucolowski.taxicoordinators.model.CoordinatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CoordinatorRepository extends JpaRepository<CoordinatorEntity, Long> {

    //wyszukiwanie wszystkich upomnień po numerze koordynatora
    Optional<CoordinatorEntity> findByNumber( String number);

}
