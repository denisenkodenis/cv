package ru.denisenkodenis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.denisenkodenis.model.Headers;

public interface HeadersRepository extends MongoRepository<Headers, String> {

}
