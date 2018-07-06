package guru.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guru.springframework.command.IngredientCommand;
import guru.springframework.command.converter.IngredientCommandToIngredient;
import guru.springframework.command.converter.IngredientToIngredientCommand;
import guru.springframework.model.Ingredient;
import guru.springframework.repositories.IngredientRepository;

@Service
public class IngredientServiceImpl implements IngredientService{
		
	IngredientRepository ingredientRepository;
	
	IngredientCommandToIngredient ingredientCommandToIngredient;
	
	IngredientToIngredientCommand ingredientToIngredientCommand;

	@Autowired
	public IngredientServiceImpl(IngredientRepository ingredientRepository,
			IngredientCommandToIngredient ingredientCommandToIngredient,
			IngredientToIngredientCommand ingredientToIngredientCommand) {
		this.ingredientRepository = ingredientRepository;
		this.ingredientCommandToIngredient = ingredientCommandToIngredient;
		this.ingredientToIngredientCommand = ingredientToIngredientCommand;
	}
	
	public void saveIngredient(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

	public IngredientCommand saveIngredientCommand(IngredientCommand command) {
		Ingredient ingredientDetached = ingredientCommandToIngredient.convert(command);
		Ingredient ingredientSaved = ingredientRepository.save(ingredientDetached);
		return ingredientToIngredientCommand.convert(ingredientSaved);
	}
	
}
