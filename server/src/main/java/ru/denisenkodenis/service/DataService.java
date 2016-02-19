package ru.denisenkodenis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.denisenkodenis.model.*;
import ru.denisenkodenis.repository.*;
import java.util.List;

@Component
public class DataService {
    @Autowired
    private PersonalInfoRepository personalInfoRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    @Autowired
    private EducationsRepository educationsRepository;

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private HeadersRepository headersRepository;

    private String lang = "ru";

    public void setLang(String lang){
        this.lang = lang;
    }

    public PersonalInfo getPersonalInfo(){
        return personalInfoRepository.findByLang(lang);
    }

    public List<Skill> getSkills() {
        return skillsRepository.findByLang(lang);
    }

    public List<Education> getEducations(){
        return educationsRepository.findByLang(lang);
    }

    public List<Job> getJobs(){
        return jobsRepository.findByLang(lang);
    }

    public Headers getHeaders(){
        return headersRepository.findByLang(lang);
    }
}