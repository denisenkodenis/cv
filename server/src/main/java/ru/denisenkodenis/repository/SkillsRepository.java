package ru.denisenkodenis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.denisenkodenis.model.Skill;

import java.util.List;

public interface SkillsRepository extends MongoRepository<Skill, String>{
    List<Skill> findByLang(String lang);
}
