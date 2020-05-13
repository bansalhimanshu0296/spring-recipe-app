package himanshu.springframwork.recipe.services.implementation;

import himanshu.springframwork.recipe.model.Recipe;
import himanshu.springframwork.recipe.repositories.RecipeRepository;
import himanshu.springframwork.recipe.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    Recipe recipe;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
        recipe = new Recipe();
    }

    @Test
    public void findRecipeById(){
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        Mockito.when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        Recipe recipeReturned = recipeService.findRecipeById(1L);
        assertNotNull(recipeReturned,"Null Recipe returned");
        Mockito.verify(recipeRepository).findById(anyLong());
        Mockito.verify(recipeRepository,Mockito.never()).findAll();
    }
    @Test
    public void findAll() {


        HashSet<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);
        Set<Recipe> recipes = recipeService.findAll();

        assertEquals(recipes.size(),1);

        verify(recipeRepository,times(1)).findAll();
    }

    @Test
    void save() {
        when(recipeRepository.save(any())).thenReturn(recipe);
        Recipe retunedRecipe = recipeService.save(recipe);
        assertNotNull(retunedRecipe);
        assertEquals(recipe,retunedRecipe);
        verify(recipeRepository).save(any());
    }

    @Test
    void deleteRecipe() {
        Long id = Long.valueOf(2L);

        recipeService.deleteRecipe(id);
        verify(recipeRepository).deleteById(anyLong());
    }
}