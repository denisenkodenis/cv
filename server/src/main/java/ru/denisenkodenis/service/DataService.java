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

    public PersonalInfo getPersonalInfo(){
        if (1 != personalInfoRepository.count())
            return null;
        return personalInfoRepository.findAll().get(0);
    }

    public List<Skill> getSkills() {
        return skillsRepository.findAll();
    }

    public List<Education> getEducations(){
        return educationsRepository.findAll();
    }

    public List<Job> getJobs(){
        return jobsRepository.findAll();
    }

    public Headers getHeaders(){
        if (1 != headersRepository.count())
            return null;
        return headersRepository.findAll().get(0);

    }
}