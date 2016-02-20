package ru.denisenkodenis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.denisenkodenis.model.Education;

import java.util.List;

@Repository
public interface EducationsRepository extends MongoRepository<Education, String>{
    List<Education> findByLang(String lang);
}
