package himanshu.springframwork.recipe.services;

import himanshu.springframwork.recipe.model.Recipe;

import java.util.Optional;
import java.util.Set;


public interface RecipeService {

    Set<Recipe> findAll();
    Recipe findRecipeById(Long id);
}
