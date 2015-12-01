import model.ingredientType.EIngredients;
import sample.View;

import java.util.logging.Logger;

/**
 * Created by Marcin on 2015-10-21.
 */
public class Start {
    private static Logger logger = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) {
        System.out.println(EIngredients.CHEESE.toString().toLowerCase());
        View.launch(View.class);
    }

}
