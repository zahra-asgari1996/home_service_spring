package ir.maktab.service;

import ir.maktab.data.domain.Manager;
import ir.maktab.data.repository.ManagerRepository;
import ir.maktab.dto.ManagerDto;
import ir.maktab.service.exception.InvalidPassword;
import ir.maktab.service.exception.NotFoundManagerException;
import ir.maktab.service.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository repository;
    private final ManagerMapper mapper;

    public ManagerServiceImpl(ManagerRepository repository, ManagerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void saveNewManager(ManagerDto dto) {
        repository.save(mapper.toManager(dto));
    }

    @Override
    public void deleteManager(ManagerDto dto) {
        repository.delete(mapper.toManager(dto));
    }

    @Override
    public void updateManager(ManagerDto dto) {
        repository.save(mapper.toManager(dto));
    }

    @Override
    public List<ManagerDto> fetchAllManagers() {
        return repository.findAll()
                .stream().map(mapper::toManagerDto)
                .collect(Collectors.toList());
    }

    @Override
    public ManagerDto findByUserName(String userName) {
        Optional<Manager> manager = repository.findByUserName(userName);
        if (manager.isPresent()) {
            return mapper.toManagerDto(manager.get());
        }
        return null;
    }

    @Override
    public ManagerDto loginManager(ManagerDto dto) throws NotFoundManagerException, InvalidPassword {
        Optional<Manager> manager = repository.findByUserName(dto.getUserName());
        Manager correctManager = manager.get();
        if (manager.isPresent()) {
            if (correctManager.getPassword().equals(dto.getPassword())) {
                return mapper.toManagerDto(correctManager);
            } else {
                throw new InvalidPassword("Password Is Incorrect ! Please Try Again...");
            }
        } else {
            throw new NotFoundManagerException("This Email Is Not Available ! Please Try Again...");
        }
    }
}

