package ir.maktab.service;

import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.repository.ExpertRepository;
import ir.maktab.data.repository.SubServiceRepository;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SelectFieldForExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.NotFoundExpertException;
import ir.maktab.service.mapper.ExpertMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ExpertServiceImpl implements ExpertService {
private final ExpertRepository expertRepository;
private final ExpertMapper expertMapper;
private final SubServiceRepository subServiceRepository;

    public ExpertServiceImpl(ExpertRepository expertRepository, ExpertMapper expertMapper, SubServiceRepository subServiceRepository) {
        this.expertRepository = expertRepository;
        this.expertMapper = expertMapper;
        this.subServiceRepository = subServiceRepository;
    }

    @Override
    public void saveNewExpert(ExpertDto expert) {
        expertRepository.save(expertMapper.toExpert(expert));
    }

    @Override
    public void deleteExpert(ExpertDto expert) {
        expertRepository.delete(expertMapper.toExpert(expert));
    }

    @Override
    public void updateExpert(ExpertDto expert) {
        expertRepository.save(expertMapper.toExpert(expert));
    }

    @Override
    public List<ExpertDto> fetchAllExperts() {
        return expertRepository.findAll()
                .stream()
                .map(expertMapper::toExpertDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExpertDto findByEmail(String email) throws NotFoundExpertException {
        Optional<Expert> expert = expertRepository.findByEmail(email);
        if (expert.isPresent()){
            return expertMapper.toExpertDto(expert.get());
        }
        throw new NotFoundExpertException("Expert Is Not Available");

    }

    @Override
    public void addExpertToSubService(SubServiceDto service, ExpertDto expert) {
        expert.getServices().add(service);
        expertRepository.save(expertMapper.toExpert(expert));
//        System.out.println(service.getExperts().size());
//        service.getExperts().add(expert);
//        System.out.println(service.getExperts().size());
//        subServiceRepository.save(subServiceMapper.convertToSubService(service));
    }

    @Override
    public void addExpertToSubService(SelectFieldForExpertDto dto) {
        //is present
        Optional<SubService> service = subServiceRepository.findByName(dto.getSubServiceDto().getName());
        Optional<Expert> expert = expertRepository.findByEmail(dto.getExpertDto().getEmail());
        expert.get().getServices().add(service.get());
        expertRepository.save(expert.get());
    }
}
