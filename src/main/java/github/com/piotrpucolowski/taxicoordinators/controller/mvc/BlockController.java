package github.com.piotrpucolowski.taxicoordinators.controller.mvc;

import github.com.piotrpucolowski.taxicoordinators.model.AdmonishEntity;
import github.com.piotrpucolowski.taxicoordinators.model.BlockEntity;
import github.com.piotrpucolowski.taxicoordinators.repository.BlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("block")
public class BlockController {
    private final BlockRepository blockRepository;

    public List<BlockEntity> findALl() {
        return blockRepository.findAll();
    }

    @GetMapping("/findAll")
    private String showFindAll(Model model) {
        List<BlockEntity> blockList = blockRepository.findAll();
        model.addAttribute("blockList", blockList);
        return "/blockList.jsp";
    }
}
