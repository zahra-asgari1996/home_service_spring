package ir.maktab.web;

import ir.maktab.dto.ServiceDto;
import ir.maktab.service.ServiceService;
import ir.maktab.service.exception.DuplicatedDataException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {
    private final ServiceService service;


    public ServiceController(ServiceService service) {
        this.service = service;
    }

    public void saveNewService(ServiceDto serviceDto) throws DuplicatedDataException {
        service.saveNewService(serviceDto);
    }

    @GetMapping(value = "/addNewService")
    public String addNewService(Model model){
        model.addAttribute("newService",new ServiceDto());
        return "addNewService";
    }

    @PostMapping(value = "/addNewService")
    public String addNewService(@ModelAttribute("newService")ServiceDto serviceDto) throws DuplicatedDataException {
        service.saveNewService(serviceDto);
        return "managerHomePage";
    }
}
