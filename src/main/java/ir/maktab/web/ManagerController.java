package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.AddSubServiceToExpertDto;
import ir.maktab.dto.ManagerDto;
import ir.maktab.service.ExpertService;
import ir.maktab.service.ManagerService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.InvalidPassword;
import ir.maktab.service.exception.NotFoundManagerException;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping(value = "/managerPage")
@SessionAttributes({"correctManager"})
public class ManagerController {
    private final ManagerService managerService;
    private final MessageSource messageSource;
    private final ExpertService expertService;
    private final SubServiceService subServiceService;

    public ManagerController(ManagerService managerService, MessageSource messageSource, ExpertService expertService, SubServiceService subServiceService) {
        this.managerService = managerService;
        this.messageSource = messageSource;
        this.expertService = expertService;
        this.subServiceService = subServiceService;
    }


    @PostMapping("/login")
    public String getSignIn(@ModelAttribute("manager") @Valid ManagerDto managerDto)
            throws NotFoundManagerException, InvalidPassword {

        managerService.loginManager(managerDto);
        return "managerHomePage";
    }
    @GetMapping("/addSubServiceToExert")
    public String addSubServiceToExpert(Model model){
        model.addAttribute("addSubServiceToExpert",new AddSubServiceToExpertDto());
        model.addAttribute("expertList",expertService.fetchAllExperts());
        model.addAttribute("subServiceList",subServiceService.fetchAllSubServices());
        return "addSubServiceToExpert";
    }
    @PostMapping("/addSubServiceToExert")
    public String addSubServiceToExpert(@ModelAttribute("addSubServiceToExpert")@Valid AddSubServiceToExpertDto dto,Model model){
        expertService.addSubServiceToExpertList(dto);
        model.addAttribute("success",
                messageSource.getMessage("sub.Service.added.to.expert.list",null,new Locale("fa_ir")));
        return "managerHomePage";
    }


    @ExceptionHandler({NotFoundManagerException.class, InvalidPassword.class})
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("manager", new ManagerDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, model);
    }
}
