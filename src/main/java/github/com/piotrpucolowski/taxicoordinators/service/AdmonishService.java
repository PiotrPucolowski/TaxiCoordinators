package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.model.AdmonishEntity;
import java.util.List;
import java.util.Optional;

public interface AdmonishService {

    List<AdmonishEntity> findAll();

    void addAdmonish(AdmonishEntity admonish);

    Optional<AdmonishEntity> findById(Long id);

    void deleteById(Long id);

    void update(AdmonishEntity admonish);
}

