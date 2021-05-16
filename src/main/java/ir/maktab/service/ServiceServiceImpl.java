package ir.maktab.service;

import ir.maktab.data.repository.ServiceRepository;
import ir.maktab.dto.ServiceDto;
import ir.maktab.service.mapper.ServiceMapper;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl implements ServiceService{
    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    public ServiceServiceImpl(ServiceRepository serviceRepository, ServiceMapper serviceMapper) {
        this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
    }

    @Override
    public void saveNewService(ServiceDto serviceDto) {
        serviceRepository.saveNewService(serviceMapper.convertToService(serviceDto));
    }
}
