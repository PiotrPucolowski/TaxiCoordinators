package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.model.AdmonishtyEntity;
import github.com.piotrpucolowski.taxicoordinators.model.CategoryEntity;
import github.com.piotrpucolowski.taxicoordinators.model.CoordinatorEntity;
import github.com.piotrpucolowski.taxicoordinators.model.DriverEntity;
import github.com.piotrpucolowski.taxicoordinators.repository.AdmonishtyRepository;
import github.com.piotrpucolowski.taxicoordinators.repository.CategoryRepository;
import github.com.piotrpucolowski.taxicoordinators.repository.CoordinatorRepository;
import github.com.piotrpucolowski.taxicoordinators.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "spring.jpa.hibernate.ddl-auto", havingValue = "create-drop")
@Component
@Slf4j
@RequiredArgsConstructor
public class TestDataLoader {

    private final AdmonishtyRepository admonishtyRepository;
    private final PasswordEncoder passwordEncoder;
    private final CategoryRepository categoryRepository;
    private final CoordinatorRepository coordinatorRepository;
    private final DriverRepository driverRepository;

    @EventListener
    public void loadData(ContextRefreshedEvent event){
        log.debug("Loading data....");
        coordinatorRepository.save(CoordinatorEntity.builder()
                    .number("K006")
                    .password(passwordEncoder.encode("password"))
                .build());
        driverRepository.save(DriverEntity.builder()
                    .carPlate("1507")
                .build());
        driverRepository.save(DriverEntity.builder()
                    .carPlate("1000")
                .build());
        driverRepository.save(DriverEntity.builder()
                    .carPlate("909")
                .build());
        categoryRepository.save(CategoryEntity.builder()
                    .name("Inappropriate attire")
                    .effect("block")
                .build());
        categoryRepository.save(CategoryEntity.builder()
                    .name("dirty car")
                    .effect("remind")
                .build());
        admonishtyRepository.save(AdmonishtyEntity.builder()
                    .driver("1000")
                    .admonish("t-shirt")
                .build());
        admonishtyRepository.save(AdmonishtyEntity.builder()
                .driver("1580")
                .admonish("dirty car")
                .build());

        CategoryEntity inappropriateAttire = categoryRepository.getReferenceById(1L);
        AdmonishtyEntity tShirt = admonishtyRepository.getReferenceById(1L);
        tShirt.getCategories().add(inappropriateAttire);
        admonishtyRepository.save(tShirt);

        CategoryEntity dirtyCar = categoryRepository.getReferenceById(2L);
        AdmonishtyEntity dirty = admonishtyRepository.getReferenceById(2L);
        dirty.getCategories().add(dirtyCar);
        admonishtyRepository.save(dirty);

        inappropriateAttire = categoryRepository.getReferenceById(1L);
        dirtyCar = categoryRepository.getReferenceById(2L);
        log.debug("Data saved");
    }
}
