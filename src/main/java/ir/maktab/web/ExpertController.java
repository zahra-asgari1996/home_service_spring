package ir.maktab.web;

import ir.maktab.dto.ExpertDto;
import ir.maktab.service.ExpertService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/registerExpert")
public class ExpertController {
    private final ExpertService expertService;

    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }
    @PostMapping(value = "/register")
    public String save(@ModelAttribute("expert")ExpertDto expertDto){
        expertService.saveNewExpert(expertDto);
        return "home";
    }
}
