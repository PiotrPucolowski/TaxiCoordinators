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
@RequiredArgsConstructor
@RequestMapping("admonish")
public class AdmonishController {
    private final JpaAdmonishService jpaAdmonishService;

    @GetMapping("/findAll")
    private String showFindAll(Model model) {
        List<AdmonishEntity> admonishList = jpaAdmonishService.findAll();
        model.addAttribute("admonishList", admonishList);
        return "/admonishList.jsp";
    }
    @GetMapping("/edit/{id}")
    private String edit(@PathVariable Long id, Model model) {
        AdmonishEntity admonish = jpaAdmonishService.findById(id).get();
        model.addAttribute("admonish", admonish);
        return "/admonishEdit.jsp";
    }
    @PostMapping("/editConfirmation")
    private String editHandle(@ModelAttribute("admonish") @Valid AdmonishEntity admonish, BindingResult result) {
        if (result.hasErrors()) {
            return "/admonishEdit.jsp";
        }
        jpaAdmonishService.update(admonish);
        return "redirect:/admonish/findAll";
    }
    @GetMapping("/deleteConfirmation/{id}")
    public String deleteConfirmation(@PathVariable Long id, Model model) {
        AdmonishEntity admonish = jpaAdmonishService.findById(id).get();
        model.addAttribute("admonish", admonish);
        return "/admonishDeleteConfirmation.jsp";
    }

    @GetMapping("/delete/{id}")
    private String deleteById(@PathVariable Long id) {
        jpaAdmonishService.deleteById(id);
        return "redirect:/admonish/findAll";
    }

    @ModelAttribute("admonishTypes")
    public HashMap<String, String> admonishType() {
        HashMap<String, String> admonishType = new HashMap<>();
        admonishType.put("Palenie", "Palenie papierosow, e-papierosow itp. w samochodzie");
        admonishType.put("Okleiny", "uszkodzone okleiny");
        admonishType.put("Kogut", "Niezapalona lampa TAXI");
        admonishType.put("Brudny", "Brudne auto");
        admonishType.put("Strój", "Nieodpowiedni strój");
        admonishType.put("Tapicerka", "Brudna tapicerka");
        admonishType.put("Blacharka", "Uszkodzenia blacharskie");
        admonishType.put("Wymiana", "Lampa taxi do wymiany");
        return admonishType;
    }
}
