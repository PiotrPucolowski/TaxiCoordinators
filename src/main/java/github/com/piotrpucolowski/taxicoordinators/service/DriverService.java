package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.model.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverService extends JpaRepository<DriverEntity, Long> {

    Optional<DriverEntity>findByCarPlate(String carPlate);
}
