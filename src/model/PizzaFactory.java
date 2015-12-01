package model;

import model.ingredientType.*;
import model.pizzaType.IPizza;
import model.pizzaType.Pizza;

import java.util.List;
import java.util.logging.Logger;

public class PizzaFactory {
    private static Logger logger = Logger.getLogger(PizzaFactory.class.getName());
    /*public enum ETypes {
        MARGARITA,
        DRACULA,
        VEGETARIAN
    }*/

    /*private Pizza makePizza(Pizza pizza, List<EIngredients> ingredientsToAdd, List<EIngredients> ingredientsToRemove) {

    }*/

    /*public static Pizza getPizza(int ID, String marka, String name, String price, boolean avibility, String type)
    {
        Vehicles currentVehicle = Vehicles.valueOf(type.toUpperCase());
        logger.info("Typ: " + currentVehicle);
        if(currentVehicle != null) {
            switch (currentVehicle) {
                case CAR:
                    Car car = new Car(ID, marka, name, price, avibility, type);
                    return car;
                case QUAD:
                    Quad quad = new Quad(ID, marka, name, price, avibility, type);
                    return quad;
                case MOTOR:
                    Motor motor = new Motor(ID, marka, name, price, avibility, type);
                    return motor;
            }
        }
        return null;
    }*/


}