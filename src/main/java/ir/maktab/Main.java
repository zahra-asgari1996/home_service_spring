package ir.maktab;

import ir.maktab.configuration.Config;
import ir.maktab.data.domain.Service;
import ir.maktab.dto.ServiceDto;
import ir.maktab.web.ServiceController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static ApplicationContext iocContainer=
            new AnnotationConfigApplicationContext(Config.class);
    public static void main(String[] args) {
//        ServiceDto service=new ServiceDto();
//        service.setName("a");
//        ServiceController serviceController=iocContainer.getBean(ServiceController.class);
//        serviceController.saveNewService(service);

    }
}
