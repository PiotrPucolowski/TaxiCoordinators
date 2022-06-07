package github.com.piotrpucolowski.taxicoordinators.service;


import com.sun.xml.bind.v2.runtime.Coordinator;
import github.com.piotrpucolowski.taxicoordinators.repository.CoordinatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class AuthService implements UserDetailsService {

    private CoordinatorRepository coordinatorRepository;

    @Override
    public UserDetails loadUserByNumber(String number) throws UsernameNotFoundException {
        return coordinatorRepository.findByNumber(number)
                // koordynatora z bazy (naszego) zamieniamy na użytkownika Spring Security
                        .map(coordinatorEntity -> new Coordinator(
                                // podając nazwę użytkownika
                                coordinatorEntity.getNumber(),
                                // podając hasło
                                coordinatorEntity.getPassword(),
                                //rola default'owa
                                List.of(new SimpleGrantedAuthority("COORDINATOR"))) {
                        })
                .orElseThrow(() -> new UsernameNotFoundException("No user with username " + number));
    }

    // Wykorzystanie wstrzykiwania przez setter pomaga w problemach z kolejnością zależności database<->security
    @Autowired
    public void setUserRepository(CoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
    }
}