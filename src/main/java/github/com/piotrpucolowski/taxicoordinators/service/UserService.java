package github.com.piotrpucolowski.taxicoordinators.service;

import github.com.piotrpucolowski.taxicoordinators.controller.mvc.CreateUserForm;
import github.com.piotrpucolowski.taxicoordinators.controller.mvc.UserBaseData;

import java.util.List;

public interface UserService {
    void createUser(CreateUserForm createUserForm);

    List<UserBaseData> getAllUser();
}
