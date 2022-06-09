package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

    @GetMapping("/login")
    public String showLoginForm(){
        return "/login.jsp";
    }
    @GetMapping("/afterlogin")
    public String showAfterLogin(){
        return "/afterlogin.jsp";
    }
}
