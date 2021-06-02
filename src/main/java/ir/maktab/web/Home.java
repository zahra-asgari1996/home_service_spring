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

    @GetMapping(value = "/managerPage")
    public ModelAndView goToLoginManagerPage(){
        return new ModelAndView("loginManagerPage","manager",new ManagerDto());
    }

    @GetMapping(value = "/expert")
    public ModelAndView goToRegisterExpertPage(){
        return new ModelAndView("expertHomePage","expert",new ExpertDto());
    }

    @GetMapping(value = "/customer")
    public ModelAndView goToRegisterCustomerPage(){
        return new ModelAndView("customerHomePage","customer",new CustomerDto());
    }

}