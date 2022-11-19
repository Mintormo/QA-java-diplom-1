package praktikum;

import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void returnBunNameIsSuccess() {
        Random random = new Random();
        float testPrice = (float) (random.nextFloat() * (100.0 - 10.0) + 10.0);
        String testName = "bun" + random.nextInt();

        Bun bun = new Bun(testName, testPrice);
        String actualResult = bun.getName();
        assertEquals(actualResult, testName);
    }

    @Test
    public void returnBunPriceIsSuccess() {
        Random random = new Random();
        float testPrice = (float) (random.nextFloat() * (100.0 - 10.0) + 10.0);
        String testName = "bun" + random.nextInt();

        Bun bun = new Bun(testName, testPrice);
        float actualResult = bun.getPrice();
        assertEquals(actualResult, testPrice, 0.01);
    }
}
