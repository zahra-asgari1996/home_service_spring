package ir.maktab.service;

import ir.maktab.data.repository.UserRepository;
import ir.maktab.dto.SearchCustomerDto;
import ir.maktab.dto.UserDto;
import ir.maktab.service.mapper.UserMapper;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<UserDto> fetchAllUsers() {
        return  repository.fetchAllUsers()
                .stream().map
                        (i->mapper.toUserDto(i))
                .collect(Collectors.toList());

    }

    @Override
    public void changePassword(UserDto dto) {
        repository.changePassword(mapper.toUser(dto));

    }

    @Override
    public List<UserDto> findByProperty(SearchCustomerDto dto) {

        return repository.findByProperty(dto)
                .stream().map
                        (i->mapper.toUserDto(i)).collect(Collectors.toList());
    }
}