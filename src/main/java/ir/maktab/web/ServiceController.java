package ir.maktab.web;

import ir.maktab.dto.ServiceDto;
import ir.maktab.service.ServiceService;
import ir.maktab.service.exception.DuplicatedDataException;
import org.springframework.stereotype.Controller;

@Controller
public class ServiceController {
    private final ServiceService service;


    public ServiceController(ServiceService service) {
        this.service = service;
    }

    public void saveNewService(ServiceDto serviceDto) throws DuplicatedDataException {
        service.saveNewService(serviceDto);
    }
}
