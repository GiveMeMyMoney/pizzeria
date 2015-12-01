package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.Model;
import model.decorator.PizzaWithCheese;
import model.decorator.PizzaWithOlive;
import model.decorator.PizzaWithPaprika;
import model.decorator.PizzaWithSalami;
import model.ingredientType.*;
import model.pizzaType.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Controller implements Initializable {
    private static Logger logger = Logger.getLogger(Controller.class.getName());

    ///"slabe" ladowanie modelu na sztywno. Brak konstr.
    private Model model = Model.getInstance();
    //View mam bezposrednio z fxmla.

    List<IPizza> pizzas = new ArrayList<>();
    /**
     * @see EIngredients
     */
    List<EIngredients> ingredientsToAdd = new ArrayList<>();
    List<EIngredients> ingredientsToRemove = new ArrayList<>();

    IPizza selectedPizza;
    int selectedIdx;

    ///FXML variable region
        @FXML private Text ingredientsText, costText;
        @FXML private ListView<IPizza> listViewPizzas;
        //Add CheckBoxes
        @FXML private CheckBox tsAddCB, hAddCB, oAddCB, sAddCB, cAddCB, pAddCB;
        //Remove CheckBoxes
        @FXML private CheckBox tsRemoveCB, hRemoveCB, oRemoveCB, sRemoveCB, cRemoveCB, pRemoveCB;
    //endregion

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("Initialize");
        /**
         * Brak polaczenia z baza danych(nie trzeba) wiec ladowanie
         * poczatkowych danych
         */
        initTempData();
        /**
         * Ustawianie poczatkowych zmiennych
         */
        if (pizzas.size() > 0 && pizzas != null) {
            selectedIdx = 0;
            selectedPizza = pizzas.get(0);
            List<String> ingredients = new ArrayList<>(pizzas.get(0).showIngredients());    //TODO do zmiany na global w obrebie klasy
            String ingredientsWithoutBrackets = ingredients.toString().replace("[", "").replace("]", "");
            ingredientsText.setText(ingredientsWithoutBrackets);
            separateCheckBoxes(ingredients);
        }
        /**
         * Ladowanie danych do ListView
         */
        setVehiclesArray();
        setListViewVehicle(pizzas);

    }

    //region private Methods
    private void initTempData() {
        pizzas.add(new PizzaWithCheese(new Pizza(ETypes.MARGARITA.toString().toLowerCase())));
        pizzas.add(new PizzaWithCheese(new PizzaWithSalami(new PizzaWithPaprika(new Pizza(ETypes.DRACULA.toString().toLowerCase())))));
        pizzas.add(new PizzaWithCheese(new PizzaWithOlive(new PizzaWithPaprika(new Pizza(ETypes.VEGETARIAN.toString().toLowerCase())))));
    }

    private void setListViewVehicle(List<IPizza> pizzas) {
        listViewPizzas.setCellFactory(new Callback<ListView<IPizza>, ListCell<IPizza>>() {
            @Override
            public ListCell<IPizza> call(ListView<IPizza> param) {
                ListCell<IPizza> cell = new ListCell<IPizza>() {
                    @Override
                    protected void updateItem(IPizza item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            String ingredientsWithoutBrackets = item.showIngredients().toString().replace("[", "").replace("]", "");
                            setText(String.valueOf(pizzas.indexOf(item) + 1) + ". " + item.showType() + " with ingredients: " + ingredientsWithoutBrackets);
                        }
                    }
                };
                return cell;
            }
        });
    }

    private void setVehiclesArray() {
        pizzas = new ArrayList<>(pizzas);
        ObservableList<IPizza> data = FXCollections.observableArrayList(pizzas);
        listViewPizzas.setItems(data);
    }

    private void separateCheckBoxes(List<String> ingredients) {
        if (ingredients.contains(EIngredients.CHEESE.toString().toLowerCase())) {
            cRemoveCB.setVisible(true);
            cAddCB.setVisible(false);
        } else {
            cRemoveCB.setVisible(false);
            cAddCB.setVisible(true);
        }

        if (ingredients.contains(EIngredients.SALAMI.toString().toLowerCase())) {
            sRemoveCB.setVisible(true);
            sAddCB.setVisible(false);
        } else {
            sRemoveCB.setVisible(false);
            sAddCB.setVisible(true);
        }

        if (ingredients.contains(EIngredients.PAPRIKA.toString().toLowerCase())) {
            pRemoveCB.setVisible(true);
            pAddCB.setVisible(false);
        } else {
            pRemoveCB.setVisible(false);
            pAddCB.setVisible(true);
        }

        if (ingredients.contains(EIngredients.OLIVE.toString().toLowerCase())) {
            oRemoveCB.setVisible(true);
            oAddCB.setVisible(false);
        } else {
            oRemoveCB.setVisible(false);
            oAddCB.setVisible(true);
        }

        if (ingredients.contains(EIngredients.HAM.toString().toLowerCase())) {
            hRemoveCB.setVisible(true);
            hAddCB.setVisible(false);
        } else {
            hRemoveCB.setVisible(false);
            hAddCB.setVisible(true);
        }

        if (ingredients.contains(EIngredients.TOMATO_SAUCE.toString().toLowerCase())) {
            tsRemoveCB.setVisible(true);
            tsAddCB.setVisible(false);
        } else {
            tsRemoveCB.setVisible(false);
            tsAddCB.setVisible(true);
        }
    }

    private void whichCheckBoxesAreSelected() {
        if (cAddCB.isSelected()) {
            ingredientsToAdd.add(EIngredients.CHEESE);
        } else if (cRemoveCB.isSelected()) {
            ingredientsToRemove.add(EIngredients.CHEESE);
        }
        if (sAddCB.isSelected()) {
            ingredientsToAdd.add(EIngredients.SALAMI);
        } else if (sRemoveCB.isSelected()) {
            ingredientsToRemove.add(EIngredients.SALAMI);
        }
        if (pAddCB.isSelected()) {
            ingredientsToAdd.add(EIngredients.PAPRIKA);
        } else if (pRemoveCB.isSelected()) {
            ingredientsToRemove.add(EIngredients.PAPRIKA);
        }
        if (oAddCB.isSelected()) {
            ingredientsToAdd.add(EIngredients.OLIVE);
        } else if (oRemoveCB.isSelected()) {
            ingredientsToRemove.add(EIngredients.OLIVE);
        }
        if (hAddCB.isSelected()) {
            ingredientsToAdd.add(EIngredients.HAM);
        } else if (hRemoveCB.isSelected()) {
            ingredientsToRemove.add(EIngredients.HAM);
        }
        if (tsAddCB.isSelected()) {
            ingredientsToAdd.add(EIngredients.TOMATO_SAUCE);
        } else if (tsRemoveCB.isSelected()) {
            ingredientsToRemove.add(EIngredients.TOMATO_SAUCE);
        }

    }

    private void clearListOfAddRemoveIngredients() {
        ingredientsToAdd.clear();
        ingredientsToRemove.clear();
    }

    private void clearCheckBoxes() {
        //Unselect all CB
        tsAddCB.setSelected(false); hAddCB.setSelected(false); oAddCB.setSelected(false); sAddCB.setSelected(false); cAddCB.setSelected(false); pAddCB.setSelected(false);
        tsRemoveCB.setSelected(false); hRemoveCB.setSelected(false); oRemoveCB.setSelected(false); sRemoveCB.setSelected(false); cRemoveCB.setSelected(false); pRemoveCB.setSelected(false);
    }

    private void commitChanges() {
        /**
         * Ladowanie danych do ListView
         */
        setVehiclesArray();
        setListViewVehicle(pizzas);
        List<String> ingredients = new ArrayList<>(selectedPizza.showIngredients());
        separateCheckBoxes(ingredients);

        String ingredientsWithoutBrackets = ingredients.toString().replace("[", "").replace("]", "");
        ingredientsText.setText(ingredientsWithoutBrackets);
    }
    //endregion

    @FXML protected void mouseClickLV() {
        selectedIdx = listViewPizzas.getSelectionModel().getSelectedIndex();
        selectedPizza = listViewPizzas.getSelectionModel().getSelectedItem();
        logger.info("Pizza INGREDIENTS: " + selectedPizza.showIngredients() + "\t With INDX: " + String.valueOf(selectedIdx));
        List<String> ingredients = new ArrayList<>(selectedPizza.showIngredients());
        separateCheckBoxes(ingredients);

        String ingredientsWithoutBrackets = ingredients.toString().replace("[", "").replace("]", "");
        ingredientsText.setText(ingredientsWithoutBrackets);
    }



    @FXML protected void changeIngredientsBtn() {
        clearListOfAddRemoveIngredients();
        whichCheckBoxesAreSelected();
        logger.info("AddCB: " + ingredientsToAdd + "\nRemoveCB: " + ingredientsToRemove);
        selectedPizza = model.changePizzaWithType(selectedPizza, ingredientsToAdd, ingredientsToRemove);
        pizzas.set(selectedIdx, selectedPizza);
        logger.info("NewPIZZA: " + selectedPizza.showIngredients());
        commitChanges();
        clearCheckBoxes();
    }




}
