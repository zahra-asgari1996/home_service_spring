package ir.maktab.service;

import ir.maktab.data.domain.Manager;
import ir.maktab.data.repository.ManagerRepository;
import ir.maktab.dto.ManagerDto;
import ir.maktab.service.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl  implements ManagerService{
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
                .stream().map(manager -> mapper.toManagerDto(manager))
                .collect(Collectors.toList());
    }

    @Override
    public ManagerDto findByUserName(String userName) {
        Optional<Manager> manager = repository.findByUserName(userName);
        if (manager.isPresent()){
            return mapper.toManagerDto(manager.get());
        }
        return null ;
    }
}

