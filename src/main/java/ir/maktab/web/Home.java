package ir.maktab.web;

import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {

    @GetMapping
    public String goToHome(){
        return "home";
    }
    @GetMapping(value = "/loginManager")
    public String goToLoginManagerPage(){
        return "loginManager";
    }


    @GetMapping(value = "/loginUser")
    public String goToLoginUserPage(){
        return "loginUser";
    }

    @GetMapping(value = "/registerExpert")
    public ModelAndView goToRegisterExpertPage(){
        return new ModelAndView("registerExpert","expert",new ExpertDto());
    }

    @GetMapping(value = "/registerCustomer")
    public ModelAndView goToRegisterCustomerPage(){
        return new ModelAndView("registerCustomer","customer",new CustomerDto());
    }

}
