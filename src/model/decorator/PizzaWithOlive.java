package model.decorator;

import model.ingredientType.EIngredients;
import model.pizzaType.IPizza;

/**
 * Created by Marcin on 2015-11-19.
 */
public class PizzaWithOlive extends PizzaDecorator {

    public PizzaWithOlive(IPizza decorPizza) {
        super(decorPizza);
        addIngredient(EIngredients.OLIVE.toString().toLowerCase());

    }

    @Override
    public void addIngredient(String name) {
        super.addIngredient(name);
    }
}
