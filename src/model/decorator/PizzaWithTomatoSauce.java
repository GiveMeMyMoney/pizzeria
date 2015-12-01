package model.decorator;

import model.ingredientType.EIngredients;
import model.pizzaType.IPizza;

/**
 * Created by Marcin on 2015-11-19.
 */
public class PizzaWithTomatoSauce extends PizzaDecorator {

    public PizzaWithTomatoSauce(IPizza decorPizza) {
        super(decorPizza);
        addIngredient(EIngredients.TOMATO_SAUCE.toString().toLowerCase());

    }

    @Override
    public void addIngredient(String name) {
        super.addIngredient(name);
    }
}
