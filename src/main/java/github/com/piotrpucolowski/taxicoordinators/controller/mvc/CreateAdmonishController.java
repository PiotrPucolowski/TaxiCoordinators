package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import github.com.piotrpucolowski.taxicoordinators.model.AdmonishEntity;
import github.com.piotrpucolowski.taxicoordinators.service.AdmonishService;
import github.com.piotrpucolowski.taxicoordinators.service.JpaAdmonishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admonish")
@RequiredArgsConstructor
public class CreateAdmonishController {
    private final JpaAdmonishService jpaAdmonishService;

    @GetMapping("/add")
    public String showAdmonishAddForm(Model model) {
        AdmonishEntity admonish = new AdmonishEntity();
        model.addAttribute("admonish", admonish);
        return "/admonishCreate.jsp";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("admonish") @Valid AdmonishEntity admonish, BindingResult result) {
        if (result.hasErrors()) {
            return "/admonishCreate.jsp";
        }
        jpaAdmonishService.addAdmonish(admonish);
        return "/afterRegistration.jsp";
    }

    @ModelAttribute("powerTrainTypes")
    public HashMap<String, String> powerTrain() {
        HashMap<String, String> powerTrainTypes = new HashMap<>();
        powerTrainTypes.put("awd", "All wheel drive");
        powerTrainTypes.put("rwd", "Rear wheel drive");
        powerTrainTypes.put("fwd", "Front wheel drive");
        return powerTrainTypes;
    }

}

