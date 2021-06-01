package ir.maktab.web;

import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.DuplicatedDataException;
import org.springframework.stereotype.Controller;

@Controller
public class SubServiceController {
    private final SubServiceService subServiceService;

    public SubServiceController(SubServiceService subServiceService) {
        this.subServiceService = subServiceService;
    }

    public void saveNewSubService(SubServiceDto subServiceDto) throws DuplicatedDataException {
        subServiceService.saveNewSubService(subServiceDto);
    }
}
