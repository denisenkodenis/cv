package ru.denisenkodenis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Headers")
public class Headers {

    @Id
    private String id;
    private String lang;
    
    private String skills;
    private String jobs;
    private String education;
    private String code;

    public Headers(String lang, String skills, String jobs, String education, String code) {
        this.lang = lang;
        this.skills = skills;
        this.jobs = jobs;
        this.education = education;
        this.code = code;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getLang() { return lang; }

    public void setLang(String lang) { this.lang = lang; }

    public String getSkills() { return skills; }

    public void setSkills(String skills) { this.skills = skills; }

    public String getJobs() { return jobs; }

    public void setJobs(String jobs) { this.jobs = jobs; }

    public String getEducation() { return education; }

    public void setEducation(String education) { this.education = education; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }
}
