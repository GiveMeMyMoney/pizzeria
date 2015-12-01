package model.pizzaType;

import java.util.List;

/**
 * Created by Marcin on 2015-11-18.
 */
public class PizzaVegetarian extends Pizza {
    final static String VEGETARIAN_NAME = "vegetarian";

    public PizzaVegetarian() {
    }

    public PizzaVegetarian(List<String> ingredients) {
        super(VEGETARIAN_NAME, ingredients);
        //addIngredient ?
    }

    /*@Override
    public void addIngredient(String name) {
        ingredients.add(name);
    }*/

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "PizzaVegetarian{" +
                "ingredients=" + ingredients +
                '}';
    }
}
