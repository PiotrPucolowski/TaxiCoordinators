package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.model.RoleEntity;
import github.com.piotrpucolowski.taxicoordinators.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaRoleServie implements RoleService{
    private final RoleRepository roleRepository;

    @Override
    public List<RoleEntity> findALl() {
        return roleRepository.findAll();
    }
}
