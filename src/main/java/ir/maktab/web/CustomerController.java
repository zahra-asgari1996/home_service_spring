package ir.maktab.web;

import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.LoginCustomerDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.CustomerService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.NotFoundCustomerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final SubServiceService subServiceService;

    public CustomerController(CustomerService customerService, SubServiceService subServiceService) {
        this.customerService = customerService;
        this.subServiceService = subServiceService;
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

    @PostMapping("loginCustomerPage/login")
    public String loginCustomer(@ModelAttribute("loginCustomer")LoginCustomerDto dto) throws NotFoundCustomerException {
        CustomerDto customer = customerService.findByEmail(dto.getEmail());
        if (customer!=null){
            if (customer.getPassword().equals(dto.getPassword())){
                return "customerHomePage";
            }else {
                return "loginCustomerPage";
            }
        }else{
            return "loginCustomerPage";
        }
    }

    @GetMapping("/createOrder")
    public String createOrder(Model model){
        model.addAttribute("newOrder", new OrderDto());
        return "createOrderPage";
    }

    @PostMapping("/createOrder")
    public String createNewOrder(@ModelAttribute("newOrder") OrderDto dto,Model model){
        model.addAttribute("subServiceList",subServiceService.fetchAllSubServices());
        return"createOrderPage";
    }
}
