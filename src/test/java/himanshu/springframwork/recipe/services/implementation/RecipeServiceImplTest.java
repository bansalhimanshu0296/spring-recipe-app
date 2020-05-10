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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void findRecipeById(){
        Recipe recipe = new Recipe();
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

        Recipe recipe = new Recipe();
        HashSet<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);
        Set<Recipe> recipes = recipeService.findAll();

        assertEquals(recipes.size(),1);

        verify(recipeRepository,times(1)).findAll();
    }
}