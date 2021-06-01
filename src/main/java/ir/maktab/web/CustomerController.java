package ir.maktab.web;

import ir.maktab.dto.CustomerDto;
import ir.maktab.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public String saveNewCustomer(@ModelAttribute("customer")CustomerDto customerDto){
        customerService.saveNewCustomer(customerDto);
        return "home";
    }
}
