package ir.maktab.service;

import ir.maktab.data.repository.ExpertRepository;
import ir.maktab.dto.ExpertDto;
import ir.maktab.service.mapper.ExpertMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
