package ru.denisenkodenis.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Skills")
public class Skill extends NamedProperty{

    private String lang;

    public Skill(String lang, String name, String description){
        super(name, description);
        this.lang = lang;
    }

    public String getId() { return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() { return lang; }

    public void setLang(String lang) { this.lang = lang; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
