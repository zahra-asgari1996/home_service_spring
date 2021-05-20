package ir.maktab.service;

import ir.maktab.data.repository.ServiceRepository;
import ir.maktab.dto.ServiceDto;
import ir.maktab.service.mapper.ServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ServiceDto getService(ServiceDto dto) {
        return null;
    }

    @Override
    public void deleteService(ServiceDto dto) {
        serviceRepository.deleteService(serviceMapper.convertToService(dto));
    }

    @Override
    public void updateService(ServiceDto dto) {
        serviceRepository.updateService(serviceMapper.convertToService(dto));
    }

    @Override
    public List<ServiceDto> fetchAllServices() {
        return serviceRepository.fetchAllServices()
                .stream().map(i->serviceMapper.convertToServiceDto(i))
                .collect(Collectors.toList());
    }
}
