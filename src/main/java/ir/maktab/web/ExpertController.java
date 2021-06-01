package ir.maktab.web;

import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.LoginExpertDto;
import ir.maktab.service.ExpertService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/expert")
public class ExpertController {
    private final ExpertService expertService;

    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }
    @PostMapping(value = "/registerExpertPage/register")
    public String save(@ModelAttribute("expert")ExpertDto expertDto){
        expertService.saveNewExpert(expertDto);
        return "home";
    }
    @GetMapping("/registerExpertPage")
    public ModelAndView goToExpertRegisterPage(){
        return new ModelAndView("registerExpertPage","expert",new ExpertDto());
    }
    @GetMapping("/loginExpertPage")
    public ModelAndView goToLoginExpertPage(){
        return new ModelAndView("loginExpertPage","loginExpert",new LoginExpertDto());
    }
}
