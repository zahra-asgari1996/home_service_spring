package ir.maktab.service;

import ir.maktab.data.repository.SubServiceRepository;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.mapper.SubServiceMapper;
import org.springframework.stereotype.Service;

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
}
