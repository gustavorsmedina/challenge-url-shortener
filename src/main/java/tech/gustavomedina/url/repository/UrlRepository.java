package tech.gustavomedina.url.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.gustavomedina.url.entity.UrlEntity;

public interface UrlRepository extends MongoRepository<UrlEntity, String> {
}
