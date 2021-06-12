package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.ManagerDto;
import ir.maktab.service.ManagerService;
import ir.maktab.service.exception.InvalidPassword;
import ir.maktab.service.exception.NotFoundExpertException;
import ir.maktab.service.exception.NotFoundManagerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/managerPage")
@SessionAttributes({"correctManager"})
public class ManagerController {
    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

//    @GetMapping("/login")
//    public String loginManager(Model model){
//        model.addAttribute("correctManager",new ManagerDto());
//        return "managerLoginPage";
//        return new ModelAndView("managerLoginPage","correctManager",new ManagerDto());
//    }

    @PostMapping("/login")
    public String getSignIn(@ModelAttribute("manager") @Valid ManagerDto managerDto)
            throws NotFoundManagerException, InvalidPassword {
        managerService.loginManager(managerDto);
        return "managerHomePage";
    }

//    @GetMapping(value = "/searchUsers")
//    public ModelAndView searchUser(){
//        return new ModelAndView("searchUsersPage","searchUser",new FilterUsersDto());
//    }

    @ExceptionHandler({NotFoundManagerException.class, InvalidPassword.class})
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("manager", new ManagerDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, model);
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());

    }
}
