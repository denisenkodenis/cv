package ru.denisenkodenis.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PersonalInfo")
public class PersonalInfo {

    @Id
    private String id;
    private String lang;

    private String name;
    private String birthDay;
    private String description;
    private String mail;
    private String phone;
    private String skype;
    private String city;

    public PersonalInfo(String lang, String name, String birthDay, String description,
                        String mail, String phone, String skype, String city) {
        this.lang = lang;
        this.name = name;
        this.birthDay = birthDay;
        this.description = description;
        this.mail = mail;
        this.phone = phone;
        this.skype = skype;
        this.city = city;
    }

    public String getId() {
        return id;
    }

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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

}