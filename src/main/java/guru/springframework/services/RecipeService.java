package guru.springframework.services;

import java.util.Set;

import guru.springframework.command.RecipeCommand;
import guru.springframework.model.Recipe;

public interface RecipeService {

	void create(Recipe recipe);

	void update(Recipe recipe);

	Recipe findById(Long id);

	Set<Recipe> getRecipes();

	void delete(Recipe recipe);
	
	RecipeCommand saveRecipeCommand(RecipeCommand command);
	
	RecipeCommand findCommandById(Long id);
}
