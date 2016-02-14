package ru.denisenkodenis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.denisenkodenis.model.Education;

public interface EducationsRepository extends MongoRepository<Education, String>{

}
