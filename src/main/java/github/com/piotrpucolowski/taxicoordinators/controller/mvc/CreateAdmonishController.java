package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import github.com.piotrpucolowski.taxicoordinators.service.AdmonishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/create-admonish")
@RequiredArgsConstructor
public class CreateAdmonishController {
    private final AdmonishService admonishService;

    @ModelAttribute("categories")
    public List<CategoryItem> categories(){
        return admonishService.getAllCategories();
    }

    @ModelAttribute("coordinators")
    public List<CoordinatorItem> coordinators(){
        return admonishService.getAllCoordinators();
    }

    @GetMapping
    public String prepareView(Model model){
        model.addAttribute("createAdmonishForm", new CreateAdmonishForm());
        return "/admonish/create";
    }

    @PostMapping(params = "createAdmonish")
    public String createAdmonish(@Valid CreateAdmonishForm createAdmonishForm, BindingResult bindingResult){
        if( bindingResult.hasErrors()){
            return "admonish/create";
        }
        admonishService.createAdmonish(createAdmonishForm);
        return "redirect:/admonish-list";
    }

    @PostMapping(params = "addCoordinator")
    public String addCoordinator(@ModelAttribute CreateAdmonishForm createAdmonishForm, CoordinatorItem coordinatorItem){
        createAdmonishForm.getCoordinators().add(coordinatorItem);
        return "admonish/create";
    }

    @PostMapping(params = "removeCoordinator")
    public String removeAdmonish(@ModelAttribute CreateAdmonishForm createAdmonishForm, @RequestParam int removeCoordinator){
        createAdmonishForm.getCoordinators().remove(removeCoordinator);
        return "/admonish/create";
    }

}
