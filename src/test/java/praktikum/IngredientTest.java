package praktikum;

import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class IngredientTest {
    @Test
    public void getIngredientPriceIsSuccess() {
        Random random = new Random();
        IngredientType[] ingredients = {IngredientType.FILLING, IngredientType.SAUCE};

        float testPrice = (float) (random.nextFloat() * (100.0 - 10.0) + 10.0);
        String testName = "ing" + random.nextInt();
        IngredientType testIng = ingredients[random.nextInt(1)];

        Ingredient ing = new Ingredient(testIng, testName, testPrice);
        float actualPrice = ing.getPrice();
        assertEquals(testPrice, actualPrice, 0.01);
    }

    @Test
    public void getIngredientNameIsSuccess() {
        Random random = new Random();
        IngredientType[] ingredients = {IngredientType.FILLING, IngredientType.SAUCE};

        float testPrice = (float) (random.nextFloat() * (100.0 - 10.0) + 10.0);
        String testName = "ing" + random.nextInt();
        IngredientType testIng = ingredients[random.nextInt(1)];

        Ingredient ing = new Ingredient(testIng, testName, testPrice);
        String actualName = ing.getName();
        assertEquals(testName, actualName);
    }

    @Test
    public void getIngredientTypeIsSuccess() {
        Random random = new Random();
        IngredientType[] ingredients = {IngredientType.FILLING, IngredientType.SAUCE};

        float testPrice = (float) (random.nextFloat() * (100.0 - 10.0) + 10.0);
        String testName = "ing" + random.nextInt();
        IngredientType testIng = ingredients[random.nextInt(1)];

        Ingredient ing = new Ingredient(testIng, testName, testPrice);
        IngredientType actualIngredient = ing.getType();
        assertEquals(testIng, actualIngredient);
    }
}
