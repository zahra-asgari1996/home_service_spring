package ir.maktab.service;

import ir.maktab.data.repository.ManagerRepository;
import ir.maktab.dto.ManagerDto;
import ir.maktab.service.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
        repository.saveNewManager(mapper.toManager(dto));
    }

    @Override
    public void deleteManager(ManagerDto dto) {
        repository.deleteManager(mapper.toManager(dto));
    }

    @Override
    public void updateManager(ManagerDto dto) {
        repository.updateManager(mapper.toManager(dto));
    }

    @Override
    public List<ManagerDto> fetchAllManagers() {
        return repository.fetchAllManagers()
                .stream().map(manager -> mapper.toManagerDto(manager))
                .collect(Collectors.toList());
    }
}
