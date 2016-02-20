package ru.denisenkodenis.model;

import org.springframework.data.annotation.Id;

public class NamedProperty {
    @Id
    protected String id;

    protected String name;
    protected String description;

    public NamedProperty(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) { this.description = description; }
}
