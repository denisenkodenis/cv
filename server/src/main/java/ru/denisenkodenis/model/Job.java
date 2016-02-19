package ru.denisenkodenis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Jobs")
public class Job {

    @Id
    private String id;
    private String lang;

    private String duration;
    private String company;
    private String position;
    private String projects;
    private String description;
    private String technologies;
    private String projectrole;

    public Job(String lang, String duration, String company, String position, String projects,
               String description, String technologies, String projectrole) {
        this.lang = lang;
        this.duration = duration;
        this.company = company;
        this.position = position;
        this.projects = projects;
        this.description = description;
        this.technologies = technologies;
        this.projectrole = projectrole;
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() { return lang; }

    public void setLang(String lang) { this.lang = lang; }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProjects() { return projects; }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getProjectrole() {
        return projectrole;
    }

    public void setProjectrole(String projectrole) {
        this.projectrole = projectrole;
    }
}
