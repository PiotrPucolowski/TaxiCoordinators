package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.model.DriverEntity;
import github.com.piotrpucolowski.taxicoordinators.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;



@Service("driverService")
@Transactional
@RequiredArgsConstructor
public class JpaDriverService implements DriverService {
    private final DriverRepository driverRepository;

    @Override
    public List<DriverEntity> findALl() {
        return driverRepository.findAll();
    }
}

