package himanshu.springframwork.recipe.controllers;

import himanshu.springframwork.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/show/{id}")
    public String getRecipeById(@PathVariable String id, Model model){
        model.addAttribute("recipe",recipeService.findRecipeById(Long.parseLong(id)));
        return "recipe/show";

    }
}
