package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.controller.mvc.CreateUserForm;
import github.com.piotrpucolowski.taxicoordinators.controller.mvc.UserBaseData;
import github.com.piotrpucolowski.taxicoordinators.model.UserEntity;
import github.com.piotrpucolowski.taxicoordinators.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

        private UserRepository userRepository;



        @Override
        public List<UserBaseData> getAllUser(){
                // Pobieramy nazwę aktualnie zalogowanego użytkownika (aktualnie = związanego z requestem, który przetwarzamy).
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                return userRepository.findAllByUser_username(username).stream()
                        .map(bookEntity -> UserBaseData.builder()
                                .build())
                        .collect(Collectors.toList());
        }
        @Override
        public void createUser(CreateUserForm createUserForm) {


        }
}


