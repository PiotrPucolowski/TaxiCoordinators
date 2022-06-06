package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.controller.mvc.*;
import github.com.piotrpucolowski.taxicoordinators.model.AdmonishtyEntity;
import github.com.piotrpucolowski.taxicoordinators.model.CoordinatorEntity;
import github.com.piotrpucolowski.taxicoordinators.repository.AdmonishtyRepository;
import github.com.piotrpucolowski.taxicoordinators.repository.CategoryRepository;
import github.com.piotrpucolowski.taxicoordinators.repository.CoordinatorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor @Slf4j
public class DefaultAdmonishService implements AdmonishService {

        private final CoordinatorRepository coordinatorRepository;
        private final AdmonishtyRepository admonishtyRepository;
        private final CategoryRepository categoryRepository;



        @Override
        public List<CoordinatorItem> getAllCoordinators(){
                return coordinatorRepository.findAll().stream()
                        .map(entity -> CoordinatorItem.builder()
                                .id(entity.getId())
                                .firstName(entity.getFirstName())
                                .lastName(entity.getLastName())
                                .number(entity.getNumber())
                                .build())
                        .collect(Collectors.toList());
        }
        @Override
        public List<CategoryItem> getAllCategories() {
                return categoryRepository.findAll().stream()
                        .map(entity -> CategoryItem.builder()
                                .id(entity.getId())
                                .name(entity.getName())
                                .description(entity.getDescription())
                                .build())
                        .collect(Collectors.toList());
        }
        @Override
        @Transactional
        public void createAdmonish(CreateAdmonishForm createAdmonishForm) {
                log.debug("Creating admonish base on: {}", createAdmonishForm);
                admonishtyRepository.save(AdmonishtyEntity.builder()
                        .driver(createAdmonishForm.getDriver())
                        .admonish(createAdmonishForm.getAdmonish())
                        .mainCoordinator(getOrCreateCoordinator(createAdmonishForm.getMainCoordinator()))
                        .coordinators(createAdmonishForm.getCoordinators().stream()
                                .map(this::getOrCreateCoordinator)
                                .collect(Collectors.toList()))
                        .categories(createAdmonishForm.getCategories().stream()
                                .map(CategoryItem::getId)
                                .map(categoryRepository::getById)
                                .collect(Collectors.toList()))
                        .build());
        }
        private CoordinatorEntity getOrCreateCoordinator(CoordinatorItem coordinatorItem) {
                if (coordinatorItem.getId() != null) {
                        return CoordinatorRepository.getById(coordinatorItem.getId());
                }
                return coordinatorRepository.findByFirstNameAndLastNameOrNumber(coordinatorItem.getFirstName(), coordinatorItem.getLastName(), coordinatorItem.getNumber())
                        .orElseGet(() -> coordinatorRepository.save(CoordinatorEntity.builder()
                                .firstName(coordinatorItem.getFirstName())
                                .lastName(coordinatorItem.getLastName())
                                .number(coordinatorItem.getNumber())
                                .build()));
        }
}


