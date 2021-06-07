package ir.maktab.web;

import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.OfferService;
import ir.maktab.service.exception.LessOfferPriceException;
import ir.maktab.service.exception.NotSubServiceInExpertsListException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("offer")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor( Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }


    @GetMapping("/sendOffer/{id}")
    public ModelAndView sendOffer(@PathVariable("id") Integer id, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Object expert = session.getAttribute("expert");
        OfferDto offerDto=new OfferDto();
        offerDto.setOrders(new OrderDto());
        offerDto.getOrders().setId(id);
        offerDto.setExpert((ExpertDto) expert);
        return new ModelAndView("createOfferPage","newOffer",offerDto);
    }

    @PostMapping("/createOffer")
    public String createOffer(@ModelAttribute("newOffer")OfferDto dto) throws LessOfferPriceException, NotSubServiceInExpertsListException {
        offerService.saveNewOffer(dto);
        return "showOrdersPage";
    }
}
