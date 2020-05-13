package himanshu.springframwork.recipe.controllers;

import himanshu.springframwork.recipe.model.Recipe;
import himanshu.springframwork.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @RequestMapping("/add")
    public String addRecipe(Model model){
        model.addAttribute("recipe",new Recipe());
        return "recipe/recipeForm";
    }

    @PostMapping("")
    public String saveRecipe(@ModelAttribute Recipe recipe){
        Recipe savedRecipe = recipeService.save(recipe);
        return "redirect:/recipe/show/"+savedRecipe.getId();
    }

    @RequestMapping("/update/{id}")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe",recipeService.findRecipeById(Long.parseLong(id)));
        return  "recipe/recipeForm";
    }
    @RequestMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable String id){
        recipeService.deleteRecipe(Long.parseLong(id));
        return "redirect:/";
    }
}
