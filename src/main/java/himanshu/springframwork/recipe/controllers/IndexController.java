package himanshu.springframwork.recipe.controllers;

import himanshu.springframwork.recipe.services.RecipeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index","index.html"})
    public String getIndexPage(Model model){
        log.debug("In Index Controller getIndexPage()");
        model.addAttribute("recipes",recipeService.findAll());
        return "index";
    }
}
