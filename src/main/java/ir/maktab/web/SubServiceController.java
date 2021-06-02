package ir.maktab.web;

import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.DuplicatedDataException;
import ir.maktab.service.exception.NotFoundServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addNewSubService(Model model){
        model.addAttribute("newSubService",new SubServiceDto());
        return "addNewSubService";
    }

    @PostMapping("/addNewSubService")
    public String addNewSubService(@ModelAttribute("newSubService")SubServiceDto dto) throws DuplicatedDataException, NotFoundServiceException {
        System.out.println(dto.getService().getName());
        subServiceService.saveNewSubService(dto);
        return "managerHomePage";

    }
}
