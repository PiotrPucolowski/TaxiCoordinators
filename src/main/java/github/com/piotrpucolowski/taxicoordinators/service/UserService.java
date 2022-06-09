package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> getUsers();
    void registerUser(UserEntity user);
    Optional<UserEntity> getUserById(Long id);
    void updateUser(UserEntity user);
    void deleteUserById(Long id);
    Optional<UserEntity> getUserByUsername(String username);

}
