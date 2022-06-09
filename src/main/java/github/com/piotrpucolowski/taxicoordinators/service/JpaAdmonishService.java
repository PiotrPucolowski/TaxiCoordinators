package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.model.AdmonishEntity;
import github.com.piotrpucolowski.taxicoordinators.repository.AdmonishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("AdmonishService")
@RequiredArgsConstructor
@Slf4j
public class JpaAdmonishService implements AdmonishService {

    @Autowired
    private final AdmonishRepository admonishRepository;

    @Override
    public void addAdmonish(AdmonishEntity admonish){
        log.debug("Creating admonish: {}", admonish);
        admonishRepository.save(
                AdmonishEntity.builder()
                        .admonishty(admonish.getAdmonishty())
                        .effect(admonish.getEffect())
                        .build());
    }
    @Transactional
    public void update(AdmonishEntity admonish){
        log.debug("Updating admonish based on: {}", admonish);
        admonishRepository.save(
                AdmonishEntity.builder()
                        .id(admonish.getId())
                        .admonishty(admonish.getAdmonishty())
                        .effect(admonish.getEffect())
                        .build());
    }


    @Override
    public List<AdmonishEntity> findAll() {
        return admonishRepository.findAll();
    }


    @Override
    public Optional<AdmonishEntity> findById(Long id) {
        return admonishRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        admonishRepository.deleteById(id);
    }
}
