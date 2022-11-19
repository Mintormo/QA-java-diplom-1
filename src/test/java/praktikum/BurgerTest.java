package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient anotherIngredient;

    @Test
    public void receiptIsNotEmpty() {
        bun = Mockito.mock(Bun.class);
        ingredient = Mockito.mock(Ingredient.class);

        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(ingredient.getName()).thenReturn("ing");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getPrice()).thenReturn(100.0F);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String actualReceipt = burger.getReceipt();
        assertEquals(false, actualReceipt.isEmpty());
    }

    @Test
    public void removeIngredientIsSuccess() {
        bun = Mockito.mock(Bun.class);
        ingredient = Mockito.mock(Ingredient.class);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientIsSuccess() {
        bun = Mockito.mock(Bun.class);
        ingredient = Mockito.mock(Ingredient.class);
        anotherIngredient = Mockito.mock(Ingredient.class);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(0,1);
        assertEquals(ingredient, burger.ingredients.get(1));
    }
}
