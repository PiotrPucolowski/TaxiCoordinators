package github.com.piotrpucolowski.taxicoordinators.service;


import com.sun.xml.bind.v2.runtime.Coordinator;
import github.com.piotrpucolowski.taxicoordinators.model.UserEntity;
import github.com.piotrpucolowski.taxicoordinators.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class AuthService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                // koordynatora z bazy (naszego) zamieniamy na użytkownika Spring Security
                        .map(userEntity -> new User(
                                // podając nazwę użytkownika
                                userEntity.getUsername(),
                                // podając hasło
                                userEntity.getPassword(),
                                //rola default'owa
                                List.of(new SimpleGrantedAuthority(userEntity.getRoleList().toString()))) {
                        })
                .orElseThrow(() -> new UsernameNotFoundException("No user with username " + username));
    }

    // Wykorzystanie wstrzykiwania przez setter pomaga w problemach z kolejnością zależności database<->security
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}