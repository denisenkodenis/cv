package ru.denisenkodenis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.denisenkodenis.model.*;
import ru.denisenkodenis.service.DataService;

import java.util.List;

@RestController
public class DataController {
    @Autowired
    private DataService Service;

    @RequestMapping(value = "personalinfo")
    public PersonalInfo getPersonalInfo(){
        return Service.getPersonalInfo();
    }

    @RequestMapping(value = "skills")
    public List<Skill> getSkills(){
        return Service.getSkills();
    }

    @RequestMapping(value = "educations")
    public List<Education> getEducations() { return Service.getEducations(); }

    @RequestMapping(value = "jobs")
    public List<Job> getJobs() { return Service.getJobs(); }

    @RequestMapping(value = "headers")
    public Headers getHeaders() {return Service.getHeaders(); }
}
