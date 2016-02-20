package ru.denisenkodenis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.denisenkodenis.model.Job;

import java.util.List;

@Repository
public interface JobsRepository extends MongoRepository<Job, String>{
    List<Job> findByLang(String lang);
}
