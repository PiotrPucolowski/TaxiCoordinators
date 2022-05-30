package github.com.piotrpucolowski.taxicoordinators.repository;

import github.com.piotrpucolowski.taxicoordinators.model.CoordinatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoordinatorRepository extends JpaRepository<CoordinatorEntity, Long> {

    //wyszukiwanie wszystkich upomnień przez danego koordynatora, wyszukiwane po numerze koordynatora
    List<CoordinatorEntity> findAllByAdmonishty_Coordinator(String number);

}
