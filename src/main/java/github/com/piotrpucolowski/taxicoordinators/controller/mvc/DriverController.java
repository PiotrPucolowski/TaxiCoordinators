package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import github.com.piotrpucolowski.taxicoordinators.model.AdmonishEntity;
import github.com.piotrpucolowski.taxicoordinators.model.DriverEntity;
import github.com.piotrpucolowski.taxicoordinators.service.JpaAdmonishService;
import github.com.piotrpucolowski.taxicoordinators.service.JpaDriverService;
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
@RequestMapping("driver")
public class DriverController {
    private final JpaDriverService jpaDriverService;

    @GetMapping("/findAll")
    private String showFindAll(Model model) {
        List<DriverEntity> driverList = jpaDriverService.findALl();
        model.addAttribute("driverList", driverList);
        return "/driverList.jsp";
    }


    @ModelAttribute("admonishTypes")
    public HashMap<String, String> driverType() {
        HashMap<String, String> driverType = new HashMap<>();
        driverType.put("Zwykły", "Normalny kierowca");
        driverType.put("Premium", "Samochód i kierowca premium");
        driverType.put("Koordynator", "Koordynator kierowców");
        return driverType;
    }
}
