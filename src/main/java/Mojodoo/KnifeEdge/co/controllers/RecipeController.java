package Mojodoo.KnifeEdge.co.controllers;

import Mojodoo.KnifeEdge.co.models.Recipe;
import Mojodoo.KnifeEdge.co.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "api/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;  // Make sure the service name matches

    @PostMapping()
    public Recipe createRecipeModel(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @GetMapping("/all")
    public List<Recipe> getAllRecipe() {
        return recipeService.getAllRecipe();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable String id) {
        try {
            return recipeService.getRecipeById(id);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
        }
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        return recipeService.updateRecipe(recipe);
    }

    @RequestMapping("/{id}")
    public String deleteRecipe(@PathVariable String id) {
        return recipeService.deleteRecipe(id);
    }
}
