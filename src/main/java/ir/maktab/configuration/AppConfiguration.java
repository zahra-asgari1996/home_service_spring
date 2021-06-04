package ir.maktab.configuration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("ir.maktab")
@PropertySource("classpath:database.properties")
@Import(DataBaseContext.class)
//@EnableWebMvc
public class AppConfiguration {

    @Bean("messageSource")
    public MessageSource getMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver(){
       CommonsMultipartResolver commonsMultipartResolver =new CommonsMultipartResolver();
       commonsMultipartResolver.setMaxUploadSize(100000);
       return commonsMultipartResolver;
    }
}

