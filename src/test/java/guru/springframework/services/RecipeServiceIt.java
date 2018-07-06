package guru.springframework.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import guru.springframework.command.RecipeCommand;
import guru.springframework.command.converter.RecipeCommandToRecipe;
import guru.springframework.command.converter.RecipeToRecipeCommand;
import guru.springframework.model.Recipe;
import guru.springframework.repositories.RecipeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIt {
	
	private final String DEFAULT_DESCRIPTION = "New description ...";
	@Autowired
	RecipeService recipeService;
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	RecipeCommandToRecipe recipeCommandToRecipe;
	
	@Autowired
	RecipeToRecipeCommand recipeToRecipeCommand;
	
	
	@Test
	@Transactional
	public void test() {
		//Given
		Iterable<Recipe> recipes = recipeRepository.findAll();
		Recipe recipe = recipes.iterator().next();
		/*
		 * This line will fail due to the fact that when getting categories from
		 * recipe an exception is thrown because the categories are lazily fetched.
		 * There are two ways to solve it.
		 * 
		 * 1- Changing fetch type to Eager or...
		 * 2- Making this unit test as Transactional (Better approach)
		 */
		RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);
		
		//When
		recipeCommand.setDescription(DEFAULT_DESCRIPTION);
		RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);
		
		//Then
		assertEquals(DEFAULT_DESCRIPTION, savedRecipeCommand.getDescription());
		assertEquals(recipeCommand.getId(), savedRecipeCommand.getId());
	}

}
