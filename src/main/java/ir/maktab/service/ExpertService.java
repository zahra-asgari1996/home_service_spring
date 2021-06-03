package ir.maktab.service;

import ir.maktab.data.domain.Expert;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.NotFoundExpertException;

import java.util.List;

public interface ExpertService {
    void saveNewExpert(ExpertDto expert);
    void deleteExpert(ExpertDto expert);
    void updateExpert(ExpertDto expert);
    List<ExpertDto> fetchAllExperts();
    ExpertDto findByEmail(String email) throws NotFoundExpertException;
    public void addExpertToSubService(SubServiceDto service, ExpertDto expert);
}
