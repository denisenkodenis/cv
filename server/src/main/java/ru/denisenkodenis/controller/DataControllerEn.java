package ru.denisenkodenis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/en")
public class DataControllerEn extends DataControllerImpl{
    @PostConstruct
    void onPostConstruct(){
        Service.setLang("en");
    }
}
