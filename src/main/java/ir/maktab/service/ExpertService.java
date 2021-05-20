package ir.maktab.service;

import ir.maktab.data.domain.Expert;
import ir.maktab.dto.ExpertDto;

import java.util.List;

public interface ExpertService {
    void saveNewExpert(ExpertDto expert);
    void deleteExpert(ExpertDto expert);
    void updateExpert(ExpertDto expert);
    List<ExpertDto> fetchAllExperts();
}
