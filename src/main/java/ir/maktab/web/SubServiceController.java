package ir.maktab.web;

import ir.maktab.dto.OrderDto;
import ir.maktab.dto.ServiceDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.DuplicatedDataException;
import ir.maktab.service.exception.NotFoundServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("subService")
public class SubServiceController {
    private final SubServiceService subServiceService;

    public SubServiceController(SubServiceService subServiceService) {
        this.subServiceService = subServiceService;
    }

    public void saveNewSubService(SubServiceDto subServiceDto) throws DuplicatedDataException, NotFoundServiceException {
        subServiceService.saveNewSubService(subServiceDto);
    }

    @GetMapping("/addNewSubService")
    public String addNewSubService(Model model) {
        model.addAttribute("newSubService", new SubServiceDto());
        return "addNewSubService";
    }

    @PostMapping("/addNewSubService")
    public String addNewSubService(@ModelAttribute("newSubService") SubServiceDto dto) throws DuplicatedDataException, NotFoundServiceException {
        System.out.println(dto.getService().getName());
        subServiceService.saveNewSubService(dto);
        return "managerHomePage";

    }

    @GetMapping("/getSubService")
    public String getSubServices(@RequestParam("service") String service, Model model,
                                 @SessionAttribute("serviceList") List<ServiceDto> serviceList
            , @SessionAttribute("newOrder") OrderDto dto,
                                 HttpServletRequest request
    ) {
        HttpSession session = request.getSession(false);
        List<String> subServices = subServiceService.getSubServicesByServiceName(service);
//        if (serviceList.contains(service)){
//
//        }
        model.addAttribute("newOrder", dto);
        model.addAttribute("subServiceList", subServices);
//        serviceList.remove(service);
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("selectedService", service);
        return "createOrderPage";
    }
}
