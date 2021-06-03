package ir.maktab.service;

import ir.maktab.data.domain.Expert;
import ir.maktab.data.repository.ExpertRepository;
import ir.maktab.dto.ExpertDto;
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

    public ExpertServiceImpl(ExpertRepository expertRepository, ExpertMapper expertMapper) {
        this.expertRepository = expertRepository;
        this.expertMapper = expertMapper;
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
                .map(i->expertMapper.toExpertDto(i))
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
}
