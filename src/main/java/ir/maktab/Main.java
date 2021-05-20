package ir.maktab;

import ir.maktab.configuration.Config;
import ir.maktab.data.domain.Customer;
import ir.maktab.data.domain.Service;
import ir.maktab.data.repository.CustomerRepository;
import ir.maktab.data.repository.UserRepository;
import ir.maktab.dto.ServiceDto;
import ir.maktab.web.ServiceController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static ApplicationContext iocContainer=
            new AnnotationConfigApplicationContext(Config.class);
    public static void main(String[] args) {
        CustomerRepository customerRepository=iocContainer.getBean(CustomerRepository.class);
        Customer customer=new Customer();
        customer.setName("zahra");
        customer.setEmail("aaaaa");
        customer.setPassword("111");
        customerRepository.saveNewCustomer(customer);
        customer.setPassword("22222");
        UserRepository userRepository=iocContainer.getBean(UserRepository.class);
        userRepository.changePassword(customer);
//        ServiceDto service=new ServiceDto();
//        service.setName("a");
//        ServiceController serviceController=iocContainer.getBean(ServiceController.class);
//        serviceController.saveNewService(service);

    }
}
