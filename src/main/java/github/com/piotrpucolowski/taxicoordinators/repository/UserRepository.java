package github.com.piotrpucolowski.taxicoordinators.repository;

import github.com.piotrpucolowski.taxicoordinators.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    List<UserEntity> findAllByUser_username(String username);


}
