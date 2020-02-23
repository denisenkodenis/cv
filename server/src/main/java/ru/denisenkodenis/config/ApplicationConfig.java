package ru.denisenkodenis.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.XmlViewResolver;
import ru.denisenkodenis.controller.DataController;
import ru.denisenkodenis.controller.DataControllerEn;
import ru.denisenkodenis.controller.PdfController;
import ru.denisenkodenis.service.DataService;

import java.net.UnknownHostException;

@Configuration
@EnableWebMvc
@EnableMongoRepositories(basePackages = "ru.denisenkodenis.repository")
public class ApplicationConfig {

    @Bean
    @Scope("prototype")
    public DataService dataService(){
        return new DataService();
    }

    @Bean
    public DataController dataController(){
        return new DataController();
    }

    @Bean
    public DataControllerEn dataControllerEn(){
        return new DataControllerEn();
    }

    @Bean
    public PdfController pdfController(){
        return new PdfController();
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(new Mongo("localhost", 27017), "cvData");
    }

    @Bean
    public XmlViewResolver xmlViewResolver(){
        return new XmlViewResolver();
    }
}
