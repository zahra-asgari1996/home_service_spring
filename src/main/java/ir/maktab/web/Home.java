package ir.maktab.web;

import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.ManagerDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {

    @GetMapping
    public String goToHome(){
        return "home";
    }

    @GetMapping(value = "/manager")
    public String goToLoginManagerPage(){
        return "loginManager";
    }

    @GetMapping(value = "/expert")
    public String goToRegisterExpertPage(){
        return "expertPage";
    }

    @GetMapping(value = "/customer")
    public String goToRegisterCustomerPage(){
        return "customerPage";
    }

}
