package ir.maktab.web;

import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.LoginExpertDto;
import ir.maktab.dto.SelectFieldForExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.ExpertService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.NotFoundExpertException;
import ir.maktab.service.exception.NotFoundSubServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/expert")
public class ExpertController {
    private final ExpertService expertService;
    private final SubServiceService subServiceService;

    public ExpertController(ExpertService expertService, SubServiceService subServiceService) {
        this.expertService = expertService;
        this.subServiceService = subServiceService;
    }
    @PostMapping(value = "/registerExpertPage/register")
    public String save(@ModelAttribute("expert")ExpertDto expertDto){
        expertService.saveNewExpert(expertDto);
        return "expertHomePage";
    }
    @GetMapping("/registerExpertPage")
    public ModelAndView goToExpertRegisterPage(){
        return new ModelAndView("registerExpertPage","expert",new ExpertDto());
    }
    @GetMapping("/loginExpertPage")
    public ModelAndView goToLoginExpertPage(){
        return new ModelAndView("loginExpertPage","loginExpert",new LoginExpertDto());
    }

    @PostMapping("/loginExpertPage/login")
    public String loginExpert(@ModelAttribute("loginExpert") LoginExpertDto dto) throws NotFoundExpertException {
        ExpertDto expertDto = expertService.findByEmail(dto.getEmail());
        if (expertDto!=null){
            if (expertDto.getPassword().equals(dto.getPassword())){
                return "expertHomePage";
            }else {
                return "loginExpertPage";
            }
        }else{
            return "loginExpertPage";
        }
    }

    @GetMapping("/selectField")
    public String selectField(Model model){
        model.addAttribute("selectFieldForExpert",new SelectFieldForExpertDto());
        return "selectFieldForExpert";
    }

    @PostMapping("/selectField")
    public String selectField(@ModelAttribute("selectFieldForExpert") SelectFieldForExpertDto dto) throws NotFoundExpertException, NotFoundSubServiceException {
        ExpertDto expertDto= expertService.findByEmail(dto.getExpertDto().getEmail());
        SubServiceDto subServiceDto=subServiceService.findByName(dto.getSubServiceDto().getName());
        expertService.addExpertToSubService(subServiceDto,expertDto);
        //subServiceService.addExpertToSubService(subServiceDto,expertDto);
        return "expertHomePage";
    }
}
