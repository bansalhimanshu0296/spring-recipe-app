package himanshu.springframwork.recipe.repositories;

import himanshu.springframwork.recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
