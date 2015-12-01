package model;

import model.decorator.*;
import model.ingredientType.*;
import model.pizzaType.IPizza;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Marcin on 2015-11-19.
 */
public class Model implements IModel {
    private static Logger logger = Logger.getLogger(Model.class.getName());
    //ArrayList<Contact> contacts = new ArrayList<>();

    private static volatile Model instance = null;
    //private static DBrepo dBrepo = null;

    public static Model getInstance() {
        if (instance == null) {
            synchronized (Model.class) {
                if (instance == null) {
                    logger.info("Tworze instancje Model");
                    instance = new Model();
                }
            }
        }
        return instance;
    }

    /**
     * Konstruktor.
     */
    private Model() {
    }

    @Override
    public IPizza changePizzaWithType(IPizza pizza, List<EIngredients> ingredientsToAdd, List<EIngredients> ingredientsToRemove) {
        logger.info(pizza.toString());
        if (pizza != null) {
            if (ingredientsToAdd.contains(EIngredients.CHEESE)) {
                new PizzaWithCheese(pizza);
            } else if (ingredientsToRemove.contains(EIngredients.CHEESE)) {
                pizza.removeIngredient(EIngredients.CHEESE.toString().toLowerCase());
            }

            if (ingredientsToAdd.contains(EIngredients.SALAMI)) {
                new PizzaWithSalami(pizza);
            } else if (ingredientsToRemove.contains(EIngredients.SALAMI)) {
                pizza.removeIngredient(EIngredients.SALAMI.toString().toLowerCase());
            }

            if (ingredientsToAdd.contains(EIngredients.PAPRIKA)) {
                new PizzaWithPaprika(pizza);
            } else if (ingredientsToRemove.contains(EIngredients.PAPRIKA)) {
                pizza.removeIngredient(EIngredients.PAPRIKA.toString().toLowerCase());
            }

            if (ingredientsToAdd.contains(EIngredients.OLIVE)) {
                new PizzaWithOlive(pizza);
            } else if (ingredientsToRemove.contains(EIngredients.OLIVE)) {
                pizza.removeIngredient(EIngredients.OLIVE.toString().toLowerCase());
            }

            if (ingredientsToAdd.contains(EIngredients.HAM)) {
                new PizzaWithHam(pizza);
            } else if (ingredientsToRemove.contains(EIngredients.HAM)) {
                pizza.removeIngredient(EIngredients.HAM.toString().toLowerCase());
            }

            if (ingredientsToAdd.contains(EIngredients.TOMATO_SAUCE)) {
                new PizzaWithTomatoSauce(pizza);
            } else if (ingredientsToRemove.contains(EIngredients.TOMATO_SAUCE)) {
                pizza.removeIngredient(EIngredients.TOMATO_SAUCE.toString().toLowerCase());
            }

            return pizza;
        }

        return null;
    }


}
