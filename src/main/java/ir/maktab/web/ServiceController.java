package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.ServiceDto;
import ir.maktab.service.ServiceService;
import ir.maktab.service.exception.DuplicatedDataException;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {
    private final ServiceService service;
    private final MessageSource messageSource;


    public ServiceController(ServiceService service, MessageSource messageSource) {
        this.service = service;
        this.messageSource = messageSource;
    }


    @GetMapping(value = "/addNewService")
    public String addNewService(Model model) {
        model.addAttribute("newService", new ServiceDto());
        return "createNewServicePage";
    }

    @PostMapping(value = "/addNewService")
    public String addNewService(@ModelAttribute("newService") @Valid ServiceDto serviceDto,Model model) throws DuplicatedDataException {
        service.saveNewService(serviceDto);
        model.addAttribute("addNewService",
                messageSource.getMessage("new.service.added",null,new Locale("fa_ir")));
        return "managerHomePage";
    }

    @ExceptionHandler({DuplicatedDataException.class})
    public ModelAndView errorHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> model = new HashMap<>();
        model.put("error", e.getLocalizedMessage());
        model.put("newService", new ServiceDto());
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, model);
    }

}
