package ir.maktab;

import ir.maktab.configuration.AppConfiguration;
import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Manager;
import ir.maktab.data.domain.Service;
import ir.maktab.data.domain.Users;
import ir.maktab.data.enums.Role;
import ir.maktab.data.repository.CustomerRepository;
import ir.maktab.data.repository.ManagerRepository;
import ir.maktab.data.repository.UserRepository;
import ir.maktab.data.repository.UserSpecification;
import ir.maktab.dto.FilterUsersDto;
import ir.maktab.dto.ServiceDto;
import ir.maktab.dto.UserDto;
import ir.maktab.service.UserService;
import ir.maktab.web.ServiceController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
//        CustomerRepository customerRepository=context.getBean(CustomerRepository.class);
//        ManagerRepository managerRepository=context.getBean(ManagerRepository.class);
//        Optional<Manager> manager=managerRepository.findByUserName("zahra");
//        if (manager.isPresent()){
//            System.out.println("true");
//        }
//        else {
//            System.out.println("false");
//        }
//        Users users=new Customer();
//        customer.setName("zahra");
//        customer.setEmail("aaaaa");
//        customer.setPassword("111");
//        customer.setPassword("22222");
//        customerRepository.save(customer);

//        UserRepository userRepository=iocContainer.getBean(UserRepository.class);
//        userRepository.changePassword(customer);
//        ServiceDto service=new ServiceDto();
//        service.setName("a");
//        ServiceController serviceController=iocContainer.getBean(ServiceController.class);
//        serviceController.saveNewService(service);

        UserRepository userRepository=context.getBean(UserRepository.class);
        UserService userService=context.getBean(UserService.class);
        FilterUsersDto filter=new FilterUsersDto();

        List<UserDto> userDtos = userService.filterUsers(filter);
        System.out.println(userDtos.size());

//


    }
}
