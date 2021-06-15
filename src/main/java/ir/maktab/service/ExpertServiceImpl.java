package ir.maktab.service;

import ir.maktab.data.domain.Expert;
import ir.maktab.data.domain.SubService;
import ir.maktab.data.repository.ExpertRepository;
import ir.maktab.data.repository.SubServiceRepository;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SelectFieldForExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.DuplicatedEmailAddressException;
import ir.maktab.service.exception.InvalidPassword;
import ir.maktab.service.exception.NotFoundExpertException;
import ir.maktab.service.exception.NotFoundSubServiceException;
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
    private final SubServiceService subServiceService;

    public ExpertServiceImpl(ExpertRepository expertRepository, ExpertMapper expertMapper, SubServiceRepository subServiceRepository, SubServiceService subServiceService) {
        this.expertRepository = expertRepository;
        this.expertMapper = expertMapper;
        this.subServiceRepository = subServiceRepository;
        this.subServiceService = subServiceService;
    }

    @Override
    public void saveNewExpert(ExpertDto expert) throws DuplicatedEmailAddressException {
        Optional<Expert> optionalExpert = expertRepository.findByEmail(expert.getEmail());
        if (optionalExpert.isPresent()) {
            throw new DuplicatedEmailAddressException("This Email Is Available ! Please Choose Another Email Or Login... ");
        }
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
        if (expert.isPresent()) {
            return expertMapper.toExpertDto(expert.get());
        }
        throw new NotFoundExpertException("Expert Is Not Available");

    }

    @Override
    public void addExpertToSubService(SubServiceDto service, ExpertDto expert) throws NotFoundSubServiceException, NotFoundExpertException {
        Optional<SubService> subService = subServiceRepository.findById(service.getId());
        Optional<Expert> expertOptional = expertRepository.findByEmail(expert.getEmail());
        if (!subService.isPresent()){
            throw new NotFoundSubServiceException("This SubService Is Not Available !");
        }if (!expertOptional.isPresent()){
            throw  new NotFoundExpertException("This Expert Is Not Available !");
        }
        expertOptional.get().getServices().add(subService.get());
        expertRepository.save(expertOptional.get());

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

    @Override
    public ExpertDto loginExpert(ExpertDto dto) throws NotFoundExpertException, InvalidPassword {
        Optional<Expert> expert = expertRepository.findByEmail(dto.getEmail());
        if (expert.isPresent()) {
            if (!expert.get().getPassword().equals(dto.getPassword())) {
                throw new InvalidPassword("Password Is Incorrect ! Please Try Again...");
            } else {
                return expertMapper.toExpertDto(expert.get());
            }
        } else {
            throw new NotFoundExpertException("This Email Is Not Available ! Please Try Again... ");
        }
    }


    @Override
    public void changePassword(ExpertDto dto) {
        Optional<Expert> expert = expertRepository.findByEmail(dto.getEmail());
        Expert expert1 = expert.get();
        expert1.setPassword(dto.getPassword());
        expertRepository.save(expert1);
    }

    @Override
    public Double showAvgRate(ExpertDto dto) throws NotFoundExpertException {
        Optional<Expert> byEmail = expertRepository.findByEmail(dto.getEmail());
        if (!byEmail.isPresent()){
            throw new NotFoundExpertException("This Expert Is Not Available !");
        }
        return byEmail.get().getRate();
    }
}
