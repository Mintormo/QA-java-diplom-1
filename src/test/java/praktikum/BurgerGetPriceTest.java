package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerGetPriceTest {
    private List<Ingredient> ings;
    private float burgerPrice;

    @Mock
    private Bun bun;
    private Burger burger;

    final static float costOfBun = 300.0F;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    public BurgerGetPriceTest(List<Ingredient> ings, float burgerPrice) {
        this.ings = ings;
        this.burgerPrice = burgerPrice;
    }

    @Parameterized.Parameters(name = "burger price - {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {List.of(), costOfBun * 2},
                {List.of(new Ingredient(IngredientType.SAUCE, "Кетчуп", 50.0F)), costOfBun * 2 + 50.0F},
                {List.of(new Ingredient(IngredientType.FILLING, "Лук", 30.0F),
                         new Ingredient(IngredientType.FILLING, "Огурцы", 20.0F)), costOfBun * 2 + 50.0F}
        };
    }

    @Test
    public void priceOfBurgerIsCorrect() {
        bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getName()).thenReturn("Сдобная булочка");
        Mockito.when(bun.getPrice()).thenReturn(costOfBun);

        burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient i : ings) {
            burger.addIngredient(i);
        }
        assertEquals(burgerPrice, burger.getPrice(), 0.01);
    }
}