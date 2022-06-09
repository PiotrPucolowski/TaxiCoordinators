package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import github.com.piotrpucolowski.taxicoordinators.model.AdmonishEntity;
import github.com.piotrpucolowski.taxicoordinators.model.UserEntity;
import github.com.piotrpucolowski.taxicoordinators.service.JpaUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class CreateUserController {
    private final JpaUserService jpaUserService;

    @GetMapping("/add")
    public String showUserAddForm(Model model) {
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "/userCreate.jsp";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") @Valid UserEntity user, BindingResult result) {
        if (result.hasErrors()) {
            return "/userCreate.jsp";
        }
        jpaUserService.registerUser(user);
        return "/afterRegistrationUser.jsp";
    }

    @ModelAttribute("userTypes")
    public HashMap<String, String> userType() {
        HashMap<String, String> userType = new HashMap<>();
        userType.put("Admin", "Administrator");
        userType.put("Koordynator", "Koordynator kierowców taxi");
        return userType;
    }
}
