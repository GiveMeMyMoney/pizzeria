package model;

import model.ingredientType.EIngredients;
import model.pizzaType.IPizza;
import model.pizzaType.Pizza;

import java.util.List;

/**
 * Created by Marcin on 2015-11-19.
 */
public interface IModel {
    IPizza changePizzaWithType(IPizza pizza, List<EIngredients> ingredientsToAdd, List<EIngredients> ingredientsToRemove);
}
