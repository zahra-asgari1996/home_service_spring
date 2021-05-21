package ir.maktab.service;

import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.SubService;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.DuplicatedDataException;

import java.util.List;

public interface SubServiceService {

    void saveNewSubService(SubServiceDto dto) throws DuplicatedDataException;
    void updateSubService(SubServiceDto dto);
    void deleteSubService(SubServiceDto dto);
    SubServiceDto getSubService(SubServiceDto dto);
    List<SubServiceDto> fetchAllSubServices();
    void deleteExpertFromSubService(SubServiceDto service, ExpertDto expert);
    void updateExpertInSubService(SubServiceDto service,ExpertDto newExpert,ExpertDto oldExpert);
    void addExpertToSubService(SubServiceDto service,ExpertDto expert);
}
