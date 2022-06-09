package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import github.com.piotrpucolowski.taxicoordinators.model.AdmonishEntity;
import github.com.piotrpucolowski.taxicoordinators.model.UserEntity;
import github.com.piotrpucolowski.taxicoordinators.service.JpaUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final JpaUserService jpaUserService;

    @GetMapping("findAll")
    private String showGetAll(Model model){
        List<UserEntity> userList = jpaUserService.getUsers();
        model.addAttribute("userList", userList);
        return "/userList.jsp";
    }
    @GetMapping("/edit/{id}")
    private String edit(@PathVariable Long id, Model model){
        UserEntity user = jpaUserService.getUserById(id).get();
        model.addAttribute("user", user);
        return "/userEdit.jsp";
    }
    @PostMapping("/editConfirmation")
    private String editHandle(@ModelAttribute("user") @Valid UserEntity user, BindingResult result){
        if (result.hasErrors()){
            return "/userEdit.jsp";
        }
        jpaUserService.updateUser(user);
        return "redirect:/user/getUsers";
    }
    @GetMapping("/deleteConfirmation/{id}")
    public String deleteConfirmation(@PathVariable Long id, Model model) {
        UserEntity user = jpaUserService.getUserById(id).get();
        model.addAttribute("user", user);
        return "/userDeleteConfirmation.jsp";
    }

    @GetMapping("/delete/{id}")
    private String deleteById(@PathVariable Long id) {
        jpaUserService.deleteUserById(id);
        return "redirect:/user/findAll";
    }

    @ModelAttribute("userTypes")
    public HashMap<String, String> userType() {
        HashMap<String, String> userType = new HashMap<>();
        userType.put("Admin", "Administrator");
        userType.put("Koordynator", "Koordynator kierowców taxi");
        return userType;
    }
}
