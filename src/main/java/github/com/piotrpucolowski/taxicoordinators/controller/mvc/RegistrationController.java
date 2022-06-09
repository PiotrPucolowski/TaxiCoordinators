package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import github.com.piotrpucolowski.taxicoordinators.model.RoleEntity;
import github.com.piotrpucolowski.taxicoordinators.model.UserEntity;
import github.com.piotrpucolowski.taxicoordinators.service.JpaRoleServie;
import github.com.piotrpucolowski.taxicoordinators.service.JpaUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

  private final JpaUserService jpaUserService;
  private final JpaRoleServie jpaRoleServie;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "/registration.jsp";
    }

    @ModelAttribute("roleList")
    public Collection<RoleEntity> roles() {
        return jpaRoleServie.findALl();
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserEntity user, BindingResult result) {
        if (result.hasErrors()) {
            return "/registration.jsp";
        }
        jpaUserService.registerUser(user);
        return "/afterRegistration.jsp";
    }
}
