package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.OrderService;
import ir.maktab.service.ServiceService;
import ir.maktab.service.exception.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/order")
@SessionAttributes({"newOrder"})
public class OrderController {
    private final ServiceService service;
    private final OrderService orderService;


    public OrderController(ServiceService service, OrderService orderService) {
        this.service = service;
        this.orderService = orderService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/createOrder")
    public String createOrder(Model model, HttpServletRequest request) {
        model.addAttribute("newOrder", new OrderDto());
        model.addAttribute("serviceList", service.fetchAllServices());
        model.addAttribute("selectedService", "select");
        HttpSession session = request.getSession();
        session.setAttribute("serviceList", service.fetchAllServices());
        session.setAttribute("newOrder", model.getAttribute("newOrder"));
        return "createNewOrderPage";
    }

    @PostMapping("/createOrder")
    public String createNewOrder(@ModelAttribute("newOrder") @Valid OrderDto dto, HttpServletRequest request)
            throws NotFoundCustomerException {
        HttpSession session = request.getSession(false);
        CustomerDto customer = (CustomerDto) session.getAttribute("customer");
        CustomerDto loginCustomer = (CustomerDto) session.getAttribute("loginCustomer");
        CustomerDto customerDto = new CustomerDto();
        if (customer != null)
            customerDto.setEmail(customer.getEmail());
        if (loginCustomer != null)
            customerDto.setEmail(loginCustomer.getEmail());
        dto.setCustomer(customerDto);
        orderService.saveNewOrder(dto);
        return "customerHomePage";
    }

    @ExceptionHandler({NotFoundCustomerException.class})
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("newOffer", new OfferDto());
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


}
