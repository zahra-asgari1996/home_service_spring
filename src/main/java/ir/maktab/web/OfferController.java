package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.OfferService;
import ir.maktab.service.exception.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
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
@RequestMapping("offer")
@SessionAttributes({"newOffer"})
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }


    @GetMapping("/sendOffer/{id}")
    public ModelAndView sendOffer(@PathVariable("id") Integer id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        ExpertDto expert = (ExpertDto) session.getAttribute("expert");
        ExpertDto loginExpert = (ExpertDto) session.getAttribute("loginExpert");
        OfferDto offerDto = new OfferDto();
        offerDto.setOrders(new OrderDto());
        offerDto.getOrders().setId(id);
        if (expert != null) {
            offerDto.setExpert(expert);
        }
        if (loginExpert != null) {
            offerDto.setExpert(loginExpert);
        }
        return new ModelAndView("createOfferPage", "newOffer", offerDto);
    }

    @PostMapping("/createOffer")
    public String createOffer(@ModelAttribute("newOffer") @Valid OfferDto dto, HttpServletRequest request)
            throws LessOfferPriceException, NotSubServiceInExpertsListException, NotFoundExpertException, NotFoundOrderException {
        HttpSession session = request.getSession(false);
        OfferDto newOffer = (OfferDto) session.getAttribute("newOffer");
        //session.getAttribute("loginExpert");
        dto.setExpert(newOffer.getExpert());
        dto.getOrders().setId(newOffer.getOrders().getId());
        offerService.saveNewOffer(dto);
        return "expertHomePage";
    }

    @ExceptionHandler({LessOfferPriceException.class, NotSubServiceInExpertsListException.class
            , NotFoundExpertException.class, NotFoundOrderException.class})
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
