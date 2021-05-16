package ir.maktab.web;

import ir.maktab.dto.ServiceDto;
import ir.maktab.service.ServiceService;
import org.springframework.stereotype.Controller;

@Controller
public class ServiceController {
    private final ServiceService service;


    public ServiceController(ServiceService service) {
        this.service = service;
    }

    public void saveNewService(ServiceDto serviceDto){
        service.saveNewService(serviceDto);
    }
}
