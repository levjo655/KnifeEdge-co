package Mojodoo.KnifeEdge.co.services;

import Mojodoo.KnifeEdge.co.models.Recipe;
import Mojodoo.KnifeEdge.co.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;  // Use correct repository name

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(String id) {  // Fixed method name
        try {
            return recipeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Recipe not found"));
        } catch (NoSuchElementException exception) {
            System.out.println("Could not find the requested recipe");
            throw exception;
        }
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public String deleteRecipe(String id) {
        recipeRepository.deleteById(id);  // Fixed repository reference
        return "Recipe deleted";
    }
}
