package ru.denisenkodenis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.denisenkodenis.model.Job;

import java.util.List;

public interface JobsRepository extends MongoRepository<Job, String>{
    List<Job> findByLang(String lang);
}
