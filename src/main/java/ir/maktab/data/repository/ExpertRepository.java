package ir.maktab.data.repository;

import ir.maktab.data.domain.Expert;

import java.util.List;

public interface ExpertRepository {
    void saveNewExpert(Expert expert);
    void deleteExpert(Expert expert);
    void updateExpert(Expert expert);
    List<Expert> fetchAllExperts();
}
