package ru.denisenkodenis.controller;

import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;

@RestController
public class DataController extends DataControllerImpl{
    @PostConstruct
    void onPostConstract(){
        Service.setLang("ru");
    }
}
