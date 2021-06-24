package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.ExpertService;
import ir.maktab.service.OrderService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.*;
import ir.maktab.service.validation.LoginValidation;
import ir.maktab.service.validation.RegisterValidation;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(value = "/expert")
@SessionAttributes({"expert", "loginExpert"})
public class ExpertController {
    private final ExpertService expertService;
    private final SubServiceService subServiceService;
    private final OrderService orderService;
    private final MessageSource messageSource;

    public ExpertController(ExpertService expertService, SubServiceService subServiceService, OrderService orderService, MessageSource messageSource) {
        this.expertService = expertService;
        this.subServiceService = subServiceService;
        this.orderService = orderService;
        this.messageSource = messageSource;
    }

    @GetMapping("/register")
    public ModelAndView goToExpertRegisterPage() {
        return new ModelAndView("expertRegisterPage", "expert", new ExpertDto());
    }


    @PostMapping(value = "/register")
    public String save(@ModelAttribute("expert") @Validated(RegisterValidation.class) ExpertDto expertDto, Model model)
            throws DuplicatedEmailAddressException {
        ExpertDto expert = expertService.saveNewExpert(expertDto);
        model.addAttribute("credit", expert.getCredit());
        return "expertHomePage";
    }


    @GetMapping("/login")
    public ModelAndView goToLoginExpertPage() {
        return new ModelAndView("expertLoginPage", "loginExpert", new ExpertDto());
    }

    @PostMapping("/login")
    public String loginExpert(@ModelAttribute("loginExpert") @Validated(LoginValidation.class) ExpertDto dto, Model model)
            throws NotFoundExpertException, InvalidPassword {
        ExpertDto expert = expertService.loginExpert(dto);
        model.addAttribute("credit", expert.getCredit());
        return "expertHomePage";
    }

    @GetMapping("/changePassword")
    public String changePassword(Model model) {
        model.addAttribute("changePassword", new ExpertDto());
        return "expertPassChange";
    }

    @PostMapping("/changePassword")
    public String changePassword(HttpServletRequest request, @ModelAttribute("changePassword") ExpertDto dto) {
        dto.setEmail(returnExpert(request).getEmail());
        expertService.changePassword(dto);
        return "expertHomePage";
    }


    @GetMapping("/selectField")
    public String selectField(Model model) {
        model.addAttribute("listOfFields", subServiceService.fetchAllSubServices());
        return "selectFieldForExpert";
    }


    @GetMapping("/selectField/{id}")
    public String selectField(HttpServletRequest request, @PathVariable("id") Integer id)
            throws NotFoundExpertException,
            NotFoundSubServiceException {
        SubServiceDto subServiceDto = new SubServiceDto();
        subServiceDto.setId(id);
        expertService.addExpertToSubService(subServiceDto, returnExpert(request));
        return "expertHomePage";
    }

    @GetMapping("/showOrders")
    public String showOrders(HttpServletRequest request, Model model)
            throws NotFoundOrderForExpertException {
        model.addAttribute("ordersList", orderService.findOrdersBaseOnExpertSubServicesAndSituation(returnExpert(request)));
        return "showOrdersForExpertToSendOffer";
    }

    @GetMapping("/showOrdersToClickEndOfWork")
    public String showSuggestion(Model model, HttpServletRequest request)
            throws NotFoundOrderException {
        model.addAttribute("ordersList", orderService.findByExpert(returnExpert(request)));
        return "showOrdersForExpertToEndOfWork";
    }

    @ExceptionHandler(value = {NotFoundOrderForExpertException.class})
    public String notFoundOrderForExpertException(Exception e, Model model) {
        model.addAttribute("notFoundOrder", e.getLocalizedMessage());
        return "expertHomePage";
    }

    public ExpertDto returnExpert(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        ExpertDto expert = (ExpertDto) session.getAttribute("expert");
        ExpertDto loginExpert = (ExpertDto) session.getAttribute("loginExpert");
        if (expert != null) {
            return expert;
        }
        if (loginExpert != null) {
            return loginExpert;
        }
        return null;
    }

}
