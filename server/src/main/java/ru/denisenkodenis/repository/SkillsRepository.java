package ru.denisenkodenis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.denisenkodenis.model.Skill;

public interface SkillsRepository extends MongoRepository<Skill, String>{

}
