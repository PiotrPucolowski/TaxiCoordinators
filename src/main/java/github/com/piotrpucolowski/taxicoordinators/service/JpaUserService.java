package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.model.UserEntity;
import github.com.piotrpucolowski.taxicoordinators.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("userService")
@Transactional
@RequiredArgsConstructor
public class JpaUserService implements UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void registerUser(UserEntity user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPassword(user.getPassword());
        userEntity.setMatchingPassword(user.getMatchingPassword());
        userEntity.setRoleList(user.getRoleList());
        userRepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void updateUser(UserEntity user) {
        userRepository .save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserEntity> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
