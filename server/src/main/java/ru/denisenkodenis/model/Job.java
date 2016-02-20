package ru.denisenkodenis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Jobs")
public class Job {
    @Id
    private String id;
    private String lang;
    private String duration;
    private List<NamedProperty> descriptions;

    public Job(String lang, String duration, List<NamedProperty> descriptions) {
        this.lang = lang;
        this.duration = duration;
        this.descriptions = descriptions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang(){
        return lang;
    }

    public void setLang(String lang){
        this.lang = lang;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<NamedProperty> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<NamedProperty> descriptions) {
        this.descriptions = descriptions;
    }
}
