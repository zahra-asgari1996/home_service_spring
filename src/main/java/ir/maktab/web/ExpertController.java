package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SelectFieldForExpertDto;
import ir.maktab.service.ExpertService;
import ir.maktab.service.OrderService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.*;
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
@RequestMapping(value = "/expert")
@SessionAttributes({"expert", "loginExpert"})
public class ExpertController {
    private final ExpertService expertService;
    private final SubServiceService subServiceService;
    private final OrderService orderService;

    public ExpertController(ExpertService expertService, SubServiceService subServiceService, OrderService orderService) {
        this.expertService = expertService;
        this.subServiceService = subServiceService;
        this.orderService = orderService;
    }

    @GetMapping("/register")
    public ModelAndView goToExpertRegisterPage() {
        return new ModelAndView("expertRegisterPage", "expert", new ExpertDto());
    }


    @PostMapping(value = "/register")
    public String save(@ModelAttribute("expert") @Validated(RegisterValidation.class) ExpertDto expertDto)
            throws DuplicatedEmailAddressException {
        expertService.saveNewExpert(expertDto);
        return "expertHomePage";
    }


    @GetMapping("/login")
    public ModelAndView goToLoginExpertPage() {
        return new ModelAndView("expertLoginPage", "loginExpert", new ExpertDto());
    }

    @PostMapping("/login")
    public String loginExpert(@ModelAttribute("loginExpert") @Validated(LoginValidation.class) ExpertDto dto)
            throws NotFoundExpertException, InvalidPassword {
        expertService.loginExpert(dto);
        return "expertHomePage";
    }

    @GetMapping("/changePassword")
    public String changePassword(Model model) {
        model.addAttribute("changePassword", new ExpertDto());
        return "expertPassChange";
    }

    @PostMapping("/changePassword")
    public String changePassword(HttpServletRequest request, @ModelAttribute("changePassword") ExpertDto dto) {
        HttpSession session = request.getSession(false);
        ExpertDto expert = (ExpertDto) session.getAttribute("expert");
        ExpertDto loginExpert = (ExpertDto) session.getAttribute("loginExpert");
        if (expert != null) {
            dto.setEmail(expert.getEmail());
            expertService.changePassword(dto);
        }
        if (loginExpert != null) {
            dto.setEmail(loginExpert.getEmail());
            expertService.changePassword(dto);
        }
        return "expertHomePage";
    }

    @GetMapping("/selectField")
    public String selectField(Model model, @SessionAttribute("expert") ExpertDto expertDto) {
        model.addAttribute("selectFieldForExpert", new SelectFieldForExpertDto());
        //HttpSession session = request.getSession(false);
        return "selectFieldForExpert";
    }

    @PostMapping("/selectField")
    public String selectField(@ModelAttribute("selectFieldForExpert") SelectFieldForExpertDto dto,
                              //@ModelAttribute ("email") String email,
                              @SessionAttribute("expert") ExpertDto expert
    ) throws NotFoundExpertException, NotFoundSubServiceException {
//        ExpertDto expertDto= expertService.findByEmail(expert.getEmail());
//        SubServiceDto subServiceDto=subServiceService.findByName(dto.getSubServiceDto().getName());
//        String email = (String) model.getAttribute("email");
        dto.setExpertDto(expert);
        expertService.addExpertToSubService(dto);
        //subServiceService.addExpertToSubService(subServiceDto,expertDto);
        return "expertHomePage";
    }

    @GetMapping("/showOrders")
    public String showOrders(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        ExpertDto expert = (ExpertDto) session.getAttribute("expert");
        ExpertDto loginExpert = (ExpertDto) session.getAttribute("loginExpert");
        if (expert != null) {
            model.addAttribute("ordersList", orderService.findOrdersBaseOnExpertSubServicesAndSituation(expert));
        }
        if (loginExpert != null) {
            model.addAttribute("ordersList", orderService.findOrdersBaseOnExpertSubServicesAndSituation(loginExpert));
        }
        return "showOrdersPage";
    }

    @GetMapping("/showSuggestion")
    public String showSuggestion(Model model,HttpServletRequest request) throws NotFoundOrderException {
        HttpSession session = request.getSession(false);
        ExpertDto expert = (ExpertDto) session.getAttribute("expert");
        ExpertDto loginExpert = (ExpertDto) session.getAttribute("loginExpert");
        if (expert != null) {
            model.addAttribute("suggestionList",orderService.findByExpert(expert));
        }
        if (loginExpert != null) {
            model.addAttribute("ordersList", orderService.findOrdersBaseOnExpertSubServicesAndSituation(loginExpert));
        }
        return "showOrdersForExpertHomePage";
    }



    @ExceptionHandler({NotFoundExpertException.class, InvalidPassword.class, DuplicatedEmailAddressException.class
    })
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("loginExpert", new ExpertDto());
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
