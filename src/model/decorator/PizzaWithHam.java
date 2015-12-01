package model.decorator;

import model.ingredientType.EIngredients;
import model.pizzaType.IPizza;

/**
 * Created by Marcin on 2015-11-19.
 */
public class PizzaWithHam extends PizzaDecorator {

    public PizzaWithHam(IPizza decorPizza) {
        super(decorPizza);
        addIngredient(EIngredients.HAM.toString().toLowerCase());
    }

    @Override
    public void addIngredient(String name) {
        super.addIngredient(name);
    }

}
