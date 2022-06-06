package github.com.piotrpucolowski.taxicoordinators.repository;

import github.com.piotrpucolowski.taxicoordinators.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
