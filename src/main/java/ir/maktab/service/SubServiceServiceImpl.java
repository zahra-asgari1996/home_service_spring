package ir.maktab.service;

import ir.maktab.data.repository.SubServiceRepository;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.mapper.ExpertMapper;
import ir.maktab.service.mapper.SubServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubServiceServiceImpl implements SubServiceService{
    private final SubServiceRepository subServiceRepository;
    private final SubServiceMapper subServiceMapper;
    private final ExpertMapper mapper;

    public SubServiceServiceImpl(SubServiceRepository subServiceRepository, SubServiceMapper subServiceMapper, ExpertMapper mapper) {
        this.subServiceRepository = subServiceRepository;
        this.subServiceMapper = subServiceMapper;
        this.mapper = mapper;
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

    @Override
    public void deleteExpertFromSubService(SubServiceDto service, ExpertDto expert) {
        subServiceRepository.
                deleteExpertFromSubService(
                        subServiceMapper.convertToSubService(service),mapper.toExpert(expert) );
    }

    @Override
    public void updateExpertInSubService(SubServiceDto service, ExpertDto newExpert, ExpertDto oldExpert) {
        subServiceRepository.
                updateExpertInSubService
                        (subServiceMapper.convertToSubService(service),mapper.toExpert(newExpert),mapper.toExpert(oldExpert) );

    }

    @Override
    public void addExpertToSubService(SubServiceDto service, ExpertDto expert) {
        subServiceRepository.
                addExpertToSubService
                        (subServiceMapper.convertToSubService(service),mapper.toExpert(expert) );

    }
}
