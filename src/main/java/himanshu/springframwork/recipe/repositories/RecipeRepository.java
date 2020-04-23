package himanshu.springframwork.recipe.repositories;

import himanshu.springframwork.recipe.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
