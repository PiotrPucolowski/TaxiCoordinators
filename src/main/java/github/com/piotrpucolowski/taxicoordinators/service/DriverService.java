package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.model.DriverEntity;
import github.com.piotrpucolowski.taxicoordinators.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverService {

    List<DriverEntity> findALl();
}
