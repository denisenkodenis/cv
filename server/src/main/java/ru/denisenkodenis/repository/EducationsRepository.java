package ru.denisenkodenis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.denisenkodenis.model.Education;

import java.util.List;

public interface EducationsRepository extends MongoRepository<Education, String>{
    List<Education> findByLang(String lang);
}
