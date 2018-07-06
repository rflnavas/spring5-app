package guru.springframework.services;

import guru.springframework.command.IngredientCommand;
import guru.springframework.model.Ingredient;

public interface IngredientService {
	
	void saveIngredient(Ingredient ingredient);

	IngredientCommand saveIngredientCommand(IngredientCommand command);
}
