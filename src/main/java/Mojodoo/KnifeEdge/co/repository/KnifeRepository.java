package Mojodoo.KnifeEdge.co.repository;


import Mojodoo.KnifeEdge.co.models.Knife;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnifeRepository extends MongoRepository<Knife, String> {
}
