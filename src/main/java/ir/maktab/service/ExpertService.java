package ir.maktab.service;

import ir.maktab.data.domain.Expert;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SelectFieldForExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.DuplicatedEmailAddressException;
import ir.maktab.service.exception.InvalidPassword;
import ir.maktab.service.exception.NotFoundExpertException;

import java.util.List;

public interface ExpertService {
    void saveNewExpert(ExpertDto expert) throws DuplicatedEmailAddressException;
    void deleteExpert(ExpertDto expert);
    void updateExpert(ExpertDto expert);
    List<ExpertDto> fetchAllExperts();
    ExpertDto findByEmail(String email) throws NotFoundExpertException;
    public void addExpertToSubService(SubServiceDto service, ExpertDto expert);
    public void addExpertToSubService(SelectFieldForExpertDto dto);
    ExpertDto loginExpert(ExpertDto dto) throws NotFoundExpertException, InvalidPassword;

    void changePassword(ExpertDto dto);
}
