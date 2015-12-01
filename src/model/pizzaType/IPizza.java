package model.pizzaType;

import java.util.List;

/**
 * Created by Marcin on 2015-11-19.
 */
public interface IPizza {
    void addIngredient(String name);
    void removeIngredient(String name);
    List<String> showIngredients();
    String showType();
}
