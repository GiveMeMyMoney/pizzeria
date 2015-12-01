package model.pizzaType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2015-11-19.
 */
public class Pizza implements IPizza {
    String type;
    List<String> ingredients = new ArrayList<>();

    //region Construct
    public Pizza() {
    }
    public Pizza(List<String> ingredients) {
        this.ingredients = ingredients;
    }
    public Pizza(String type) {
        this.type = type;
    }
    public Pizza(String type, List<String> ingredients) {
        this.type = type;
        this.ingredients = ingredients;
    }
    //endregion

    @Override
    public void addIngredient(String name) {
        ingredients.add(name);
    }

    @Override
    public void removeIngredient(String name) {
        ingredients.remove(name);
    }

    @Override
    public List<String> showIngredients() {
        return getIngredients();
    }

    @Override
    public String showType() {
        return getType();
    }

    //region GETTERs and SETTERs
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
    //endregion

    @Override
    public String toString() {
        return "Pizza{" +
                "type='" + type + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
