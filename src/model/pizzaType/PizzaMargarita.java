package model.pizzaType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-11-18.
 */
public class PizzaMargarita extends Pizza {
    final static String MARGARITA_NAME = "margarita";

    public PizzaMargarita() {
    }

    public PizzaMargarita(List<String> ingredients) {
        super(MARGARITA_NAME, ingredients);
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
        return "PizzaMargarita{" +
                "ingredients=" + ingredients +
                '}';
    }
}
