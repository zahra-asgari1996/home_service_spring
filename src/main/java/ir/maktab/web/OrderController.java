package ir.maktab.web;

import ir.maktab.dto.OrderDto;
import ir.maktab.service.OrderService;
import ir.maktab.service.ServiceService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor( Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @GetMapping("/createOrder")
    public String createOrder(Model model, HttpServletRequest request){
        model.addAttribute("newOrder", new OrderDto());
        model.addAttribute("serviceList",service.fetchAllServices());
        model.addAttribute("selectedService","select");
        HttpSession session = request.getSession();
        session.setAttribute("serviceList" ,service.fetchAllServices());
        session.setAttribute("newOrder" ,model.getAttribute("newOrder"));
        return "createOrderPage";
    }

    @PostMapping("/createOrder")
    public String createNewOrder(@ModelAttribute("newOrder")@Valid OrderDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        }

//        dto.setDateOfWork(date);
        orderService.saveNewOrder(dto);
        //model.addAttribute("subServiceList",subServiceService.fetchAllSubServices());
        return"customerHomePage";
    }


}
