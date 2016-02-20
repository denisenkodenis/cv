package ru.denisenkodenis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.denisenkodenis.model.Headers;

@Repository
public interface HeadersRepository extends MongoRepository<Headers, String> {
    Headers findByLang(String lang);
}
