package ir.maktab.web;

import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.LoginCustomerDto;
import ir.maktab.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/registerCustomerPage/register")
    public String saveNewCustomer(@ModelAttribute("customer")CustomerDto customerDto){
        customerService.saveNewCustomer(customerDto);
        return "home";
    }

    @GetMapping("/registerCustomerPage")
    public ModelAndView goToRegisterPage(){
        return new ModelAndView("registerCustomerPage","customer",new CustomerDto());
    }

    @GetMapping("/loginCustomerPage")
    public ModelAndView goToLoginPage(){
        return new ModelAndView("loginCustomerPage","loginCustomer",new LoginCustomerDto());
    }
}
