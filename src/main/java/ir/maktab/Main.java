package ir.maktab;

import ir.maktab.configuration.AppConfiguration;
import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Service;
import ir.maktab.data.domain.Users;
import ir.maktab.data.repository.CustomerRepository;
import ir.maktab.data.repository.UserRepository;
import ir.maktab.dto.ServiceDto;
import ir.maktab.dto.UserDto;
import ir.maktab.web.ServiceController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        CustomerRepository customerRepository=context.getBean(CustomerRepository.class);
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

    }
}
