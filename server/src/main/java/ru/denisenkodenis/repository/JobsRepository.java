package ru.denisenkodenis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.denisenkodenis.model.Job;

public interface JobsRepository extends MongoRepository<Job, String>{

}
