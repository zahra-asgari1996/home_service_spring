package ir.maktab;

import ir.maktab.configuration.AppConfiguration;
import ir.maktab.data.domain.Expert;
import ir.maktab.data.repository.*;
import ir.maktab.service.exception.DuplicatedDataException;
import ir.maktab.service.exception.NotFoundExpertException;
import ir.maktab.service.exception.NotFoundServiceException;
import ir.maktab.service.exception.NotFoundSubServiceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class Main {

    public static void main(String[] args) throws DuplicatedDataException, NotFoundServiceException, NotFoundExpertException, NotFoundSubServiceException {
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

//        UserRepository userRepository=context.getBean(UserRepository.class);
//        UserService userService=context.getBean(UserService.class);
//        FilterUsersDto filter=new FilterUsersDto();
//
//        List<UserDto> userDtos = userService.filterUsers(filter);
//        System.out.println(userDtos.size());
//        SubServiceService service=context.getBean(SubServiceService.class);
//        SubServiceDto a = service.findByName("a");
//        System.out.println(a.getId());
//        ServiceDto serviceDto=new ServiceDto();
//        serviceDto.setName("t");
       // ServiceService serviceService=context.getBean(ServiceService.class);
        //serviceService.saveNewService(serviceDto);
//        SubServiceDto subServiceDto=new SubServiceDto();
//        subServiceDto.setName("a");
        //subServiceDto.setService(serviceDto);
//        ExpertService expertService=context.getBean(ExpertService.class);
//        ExpertDto byEmail = expertService.findByEmail("zahra.asgari1996@yahoo.com");
//        System.out.println(byEmail.getId());
//        ExpertDto expertDto=new ExpertDto();
//        expertDto.setEmail("ali@gmail.com");
//        expertDto.setPassword("123");
        //expertDto.getServices().add(subServiceDto);
//        expertService.addExpertToSubService(a,byEmail);
//        ServiceRepository serviceRepository=context.getBean(ServiceRepository.class);
//        Service tamir = serviceRepository.findByName("tamir");
//        System.out.println(tamir.getName());
//        SubServiceDto subServiceDto=new SubServiceDto();
//        subServiceDto.setService(serviceDto);
//        service.saveNewSubService(subServiceDto);

//
        OrderRepository orderRepository=context.getBean(OrderRepository.class);

//        List<Orders> list = orderRepository.findOrdersBaseOnExpertSubServicesAndSituation(1);
//        System.out.println(list.size());
//        System.out.println();
        ExpertRepository expertRepository=context.getBean(ExpertRepository.class);
        Optional<Expert> byEmail = expertRepository.findByEmail("zahra.asgari1996@yahoo.com");
        System.out.println(byEmail.get().getId());
        System.out.println(orderRepository.findOrdersBaseOnExpertSubServices(byEmail.get()).size());

    }
}
