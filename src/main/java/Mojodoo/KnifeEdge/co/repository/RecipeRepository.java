package Mojodoo.KnifeEdge.co.repository;

import Mojodoo.KnifeEdge.co.models.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RecipeRepository extends MongoRepository <Recipe, String> {
}
