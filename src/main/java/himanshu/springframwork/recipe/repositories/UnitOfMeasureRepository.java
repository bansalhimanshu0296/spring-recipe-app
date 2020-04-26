package himanshu.springframwork.recipe.repositories;

import himanshu.springframwork.recipe.model.Category;
import himanshu.springframwork.recipe.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {

    Optional<UnitOfMeasure> findByUom(String uom);
}
