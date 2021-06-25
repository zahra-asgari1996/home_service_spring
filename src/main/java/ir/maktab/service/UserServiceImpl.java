package ir.maktab.service;

import ir.maktab.data.repository.UserRepository;
import ir.maktab.data.repository.UserSpecification;
import ir.maktab.dto.FilterUsersDto;
import ir.maktab.dto.UserDto;
import ir.maktab.dto.UserHistoryDto;
import ir.maktab.service.exception.NotFoundUserException;
import ir.maktab.service.mapper.UserMapper;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final MessageSource messageSource;

    public UserServiceImpl(UserRepository repository, UserMapper mapper, MessageSource messageSource) {
        this.repository = repository;
        this.mapper = mapper;
        this.messageSource = messageSource;
    }

    @Override
    public List<UserDto> fetchAllUsers() {
        return repository.findAll()
                .stream().map
                        (i -> mapper.toUserDto(i))
                .collect(Collectors.toList());

    }

    @Override
    public void save(UserDto userDto) {

        repository.save(mapper.toUser(userDto));
    }

    @Override
    public List<UserDto> filterUsers(FilterUsersDto dto) {
        return repository.findAll(UserSpecification.filterUsers(dto)).stream().map(i -> mapper.toUserDto(i))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> userHistory(UserHistoryDto dto) throws NotFoundUserException {
        List<UserDto> collect =
                repository.findAll(UserSpecification.userHistory(dto))
                        .stream().map(i -> mapper.toUserDto(i)).collect(Collectors.toList());
        if (collect.size()==0){
            throw new NotFoundUserException(messageSource.getMessage("not.found.user",null,new Locale("fa_ir")));
        }
        return collect;
    }

}
