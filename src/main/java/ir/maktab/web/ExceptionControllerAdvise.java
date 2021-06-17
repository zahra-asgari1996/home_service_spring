package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.LoginCustomerDto;
import ir.maktab.service.exception.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionControllerAdvise {

    @ExceptionHandler(value = NotEnoughAccountBalance.class)
    public String notEnoughBalanceException(Model model,Exception e){
        model.addAttribute("error", e.getLocalizedMessage());
        return "customerHomePage";
    }

    @ExceptionHandler(value = NotFoundOrderException.class)
    public ModelAndView showOrdersException(Exception e,HttpServletRequest request){
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, "error",e.getLocalizedMessage());
    }

    @ExceptionHandler(value = {NotFoundCustomerException.class,InvalidPassword.class})
    public ModelAndView loginCustomerException(Exception e,HttpServletRequest request){
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("loginCustomer", new LoginCustomerDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, model);
    }

    @ExceptionHandler(value = {DuplicatedEmailAddressException.class})
    public ModelAndView registerCustomerException(Exception e,HttpServletRequest request){
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("customer", new CustomerDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, model);
    }

}
