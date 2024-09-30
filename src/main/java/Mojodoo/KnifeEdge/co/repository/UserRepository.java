package Mojodoo.KnifeEdge.co.repository;

import Mojodoo.KnifeEdge.co.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
