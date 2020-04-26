package himanshu.springframwork.recipe.services.implementation;

import himanshu.springframwork.recipe.model.Recipe;
import himanshu.springframwork.recipe.repositories.RecipeRepository;
import himanshu.springframwork.recipe.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().forEach(recipe -> recipeSet.add(recipe));
        return recipeSet;
    }
}
