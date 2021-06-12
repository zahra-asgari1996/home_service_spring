package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.LoginCustomerDto;
import ir.maktab.service.CustomerService;
import ir.maktab.service.OrderService;
import ir.maktab.service.exception.DuplicatedEmailAddressException;
import ir.maktab.service.exception.InvalidPassword;
import ir.maktab.service.exception.NotFoundCustomerException;
import ir.maktab.service.exception.NotFoundOrderException;
import ir.maktab.service.validation.ChangePasswordValidation;
import ir.maktab.service.validation.LoginValidation;
import ir.maktab.service.validation.RegisterValidation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/customer")
@SessionAttributes({"loginCustomer", "customer"})
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService orderService;


    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;

        this.orderService = orderService;
    }

    @PostMapping("/register")
    public String saveNewCustomer(@ModelAttribute("customer") @Validated(RegisterValidation.class) CustomerDto customerDto)
            throws DuplicatedEmailAddressException {
        customerService.saveNewCustomer(customerDto);
        return "customerHomePage";
    }

    @GetMapping("/register")
    public ModelAndView goToRegisterPage() {
        return new ModelAndView("customerRegisterPage", "customer", new CustomerDto());
    }

    @GetMapping("/login")
    public ModelAndView goToLoginPage() {
        return new ModelAndView("customerLoginPage", "loginCustomer", new CustomerDto());
    }

    @PostMapping("/login")
    public String loginCustomer(@ModelAttribute("loginCustomer") @Validated(LoginValidation.class) CustomerDto dto)
            throws InvalidPassword, NotFoundCustomerException {
        System.out.println("customer home page");
        customerService.loginCustomer(dto);
        return "customerHomePage";
    }

    @GetMapping("/changePassword")
    public String changePassword(Model model) {
        model.addAttribute("changePassword", new CustomerDto());
        return "customerPassChange";
    }

    @PostMapping("/changePassword")
    public String changePassword(@ModelAttribute("changePassword") @Validated(ChangePasswordValidation.class) CustomerDto dto,
                                 HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        CustomerDto loginCustomer = (CustomerDto) session.getAttribute("loginCustomer");
        if (customer != null)
            dto.setEmail(customer.getEmail());
        customerService.changePassword(dto);
        if (loginCustomer != null)
            dto.setEmail(loginCustomer.getEmail());
        customerService.changePassword(dto);
        return "customerHomePage";
    }

    @GetMapping("/showSuggestions")
    public String showSuggestions(Model model,HttpServletRequest request) throws NotFoundOrderException, NotFoundCustomerException {
        HttpSession session = request.getSession(false);
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        CustomerDto loginCustomer = (CustomerDto) session.getAttribute("loginCustomer");
        if (customer != null)
            model.addAttribute("suggestionList",orderService.findByCustomer(customer));
        if (loginCustomer != null)
            model.addAttribute("suggestionList",orderService.findByCustomer(loginCustomer));

        return "showOrdersForCustomerHomePage";

    }


    @ExceptionHandler({NotFoundCustomerException.class, InvalidPassword.class,
            DuplicatedEmailAddressException.class,NotFoundOrderException.class})
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("loginCustomer", new LoginCustomerDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        System.out.println(lastView);
        return new ModelAndView(lastView, model);
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        System.out.println(lastView);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }


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
