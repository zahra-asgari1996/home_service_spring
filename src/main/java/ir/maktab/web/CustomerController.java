package ir.maktab.web;

import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.LoginCustomerDto;
import ir.maktab.service.CustomerService;
import ir.maktab.service.exception.InvalidPassword;
import ir.maktab.service.exception.NotFoundCustomerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/customer")

public class CustomerController {
    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    @PostMapping("/registerCustomerPage/register")
    public String saveNewCustomer(@ModelAttribute("customer") CustomerDto customerDto) {
        customerService.saveNewCustomer(customerDto);
        return "home";
    }

    @GetMapping("/registerCustomerPage")
    public ModelAndView goToRegisterPage() {
        return new ModelAndView("registerCustomerPage", "customer", new CustomerDto());
    }

    @GetMapping("/login")
    public ModelAndView goToLoginPage() {
        return new ModelAndView("customerLoginPage", "loginCustomer", new LoginCustomerDto());
    }

    @PostMapping("/login")
    public String loginCustomer(@ModelAttribute("loginCustomer") @Valid LoginCustomerDto dto,
                                BindingResult bindingResult,
                                HttpServletRequest request,

                                Model model) {

        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(error -> model.addAttribute(error.getField(), error.getDefaultMessage()));
            return "customerLoginPage";
        }
        boolean b = false;
        try {
            b = customerService.loginCustomer(dto);
        } catch (InvalidPassword invalidPassword) {
            model.addAttribute("invalidPassword", invalidPassword.getMessage());
        } catch (NotFoundCustomerException e) {
            model.addAttribute("notFoundEmail", e.getMessage());
        }
        if (b) {
            HttpSession session = request.getSession(true);
            session.setAttribute("customer", dto);
            return "customerHomePage";
        }
        return "customerLoginPage";

    }

//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView errorHandler(Exception e) {
//        Map<String, Object> model = new HashMap<>();
//        model.put("error", e.getMessage());
//        return new ModelAndView("teacher/error", model);
//    }


//    @GetMapping("/createOrder")
//    public String createOrder(Model model, HttpServletRequest request){
//        model.addAttribute("newOrder", new OrderDto());
//        model.addAttribute("serviceList",service.fetchAllServices());
//        model.addAttribute("selectedService","select");
//        HttpSession session = request.getSession();
//        session.setAttribute("serviceList" ,service.fetchAllServices());
//        return "createOrderPage";
//    }

//    @PostMapping("/createOrder")
//    public String createNewOrder(@ModelAttribute("newOrder") OrderDto dto,Model model){
//        //model.addAttribute("subServiceList",subServiceService.fetchAllSubServices());
//        return"createOrderPage";
//    }
}
