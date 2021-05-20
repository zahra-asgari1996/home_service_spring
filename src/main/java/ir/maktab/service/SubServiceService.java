package ir.maktab.service;

import ir.maktab.data.domain.SubService;
import ir.maktab.dto.SubServiceDto;

import java.util.List;

public interface SubServiceService {

    void saveNewSubService(SubServiceDto dto);
    void updateSubService(SubServiceDto dto);
    void deleteSubService(SubServiceDto dto);
    SubServiceDto getSubService(SubServiceDto dto);
    List<SubServiceDto> fetchAllSubServices();
}
