package ir.maktab.data.repository;

import ir.maktab.data.domain.Manager;

import java.util.List;

public interface ManagerRepository {
    void saveNewManager(Manager manager);
    void deleteManager(Manager manager);
    void updateManager(Manager manager);
    List<Manager> fetchAllManagers();
}
