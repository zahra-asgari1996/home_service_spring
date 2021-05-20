package ir.maktab.service;

import ir.maktab.data.repository.SubServiceRepository;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.mapper.SubServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubServiceServiceImpl implements SubServiceService{
    private final SubServiceRepository subServiceRepository;
    private final SubServiceMapper subServiceMapper;

    public SubServiceServiceImpl(SubServiceRepository subServiceRepository, SubServiceMapper subServiceMapper) {
        this.subServiceRepository = subServiceRepository;
        this.subServiceMapper = subServiceMapper;
    }

    @Override
    public void saveNewSubService(SubServiceDto subServiceDto) {
        subServiceRepository.saveNewSubService(
                subServiceMapper.convertToSubService(subServiceDto));
    }

    @Override
    public void updateSubService(SubServiceDto dto) {
        subServiceRepository.updateSubService(subServiceMapper.convertToSubService(dto));

    }

    @Override
    public void deleteSubService(SubServiceDto dto) {
        subServiceRepository.deleteSubService(subServiceMapper.convertToSubService(dto));

    }

    @Override
    public SubServiceDto getSubService(SubServiceDto dto) {
        return null;
    }

    @Override
    public List<SubServiceDto> fetchAllSubServices() {
        return subServiceRepository.fetchAllSubServices()
                .stream().map(i->subServiceMapper.covertToSubServiceDto(i))
                .collect(Collectors.toList());
    }
}
