package model.pizzaType;

import java.util.List;

/**
 * Created by Marcin on 2015-11-18.
 */
public class PizzaDracula extends Pizza {
    final static String DRACULA_NAME = "dracula";

    public PizzaDracula() {
    }

    public PizzaDracula(List<String> ingredients) {
        super(DRACULA_NAME, ingredients);
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
        return "PizzaDracula{" +
                "ingredients=" + ingredients +
                '}';
    }
}
