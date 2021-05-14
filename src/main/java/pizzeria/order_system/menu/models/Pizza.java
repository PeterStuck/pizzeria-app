package pizzeria.order_system.menu.models;

import pizzeria.order_system.menu.exceptions.IngredientAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pizza extends MenuItem {

    private List<String> ingredients;

    public Pizza(int id, String name, Float price, ItemCategory category, List<String> ingredients) {
        super(id, name, price, category);
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String ingredientName) throws IngredientAlreadyExistsException {
        if (ingredients == null) {
            this.ingredients = new ArrayList<>();
        }

        if (checkIngredientAlreadyExists(ingredientName)) {
            throw new IngredientAlreadyExistsException("Ingredient " + ingredientName + " already exists!");
        }

        this.ingredients.add(ingredientName);
    }

    private boolean checkIngredientAlreadyExists(String ingredientName) {
        Optional<String> optionalIngredient = this.ingredients.stream()
                .filter(ingredient -> ingredient.equals(ingredientName))
                .findFirst();

        return optionalIngredient.isPresent();
    }
}
