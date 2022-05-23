package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import github.com.piotrpucolowski.taxicoordinators.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("create-user")
@RequiredArgsConstructor
public class CreateUserController {

    private final UserService userService;

    @GetMapping
    public String prepareView(Model model){
        model.addAttribute("createUserForm", new CreateUserForm());
        return "/users/create";
    }

    @PostMapping
    public String processView(@Valid CreateUserForm createUserForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/users/create";
        }
        userService.createUser(createUserForm);
        return "redirect:/user-list";
    }

}
