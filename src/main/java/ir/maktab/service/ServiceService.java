package ir.maktab.service;

import ir.maktab.data.domain.Service;
import ir.maktab.dto.ServiceDto;

import java.util.List;

public interface ServiceService {
    void saveNewService(ServiceDto dto);
    ServiceDto getService(ServiceDto dto);
    void  deleteService(ServiceDto dto);
    void updateService(ServiceDto dto);
    List<ServiceDto> fetchAllServices();
}
