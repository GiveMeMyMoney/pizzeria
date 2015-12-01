package model.decorator;

import model.pizzaType.IPizza;
import model.pizzaType.Pizza;

import java.util.List;

public abstract class PizzaDecorator implements IPizza {
   protected IPizza decorPizza;

   public PizzaDecorator(IPizza decorPizza){
      this.decorPizza = decorPizza;
   }

   public IPizza getDecorPizza() {
      return decorPizza;
   }

   public void setDecorPizza(IPizza decorPizza) {
      this.decorPizza = decorPizza;
   }

   @Override
   public void addIngredient(String name) {
      decorPizza.addIngredient(name);
   }

   @Override
   public void removeIngredient(String name) {
      decorPizza.removeIngredient(name);
   }

   @Override
   public List<String> showIngredients() {
      return decorPizza.showIngredients();
   }

   @Override
   public String showType() {
      return decorPizza.showType();
   }
}