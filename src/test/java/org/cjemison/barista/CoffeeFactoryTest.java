package org.cjemison.barista;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.cjemison.barista.drink.Drink;
import org.cjemison.barista.factory.DrinkFactorySingleton;
import org.cjemison.barista.util.DrinkType;

import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
public class CoffeeFactoryTest extends TestCase {

    private DrinkFactorySingleton drinkFactorySingleton = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CoffeeFactoryTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CoffeeFactoryTest.class);
    }

    @Override
    public void setUp()
    {
        this.drinkFactorySingleton = DrinkFactorySingleton.getInstance();
    }

    /**
     *  test creating the drink
     */
    public void testCoffeeFactory() throws Exception
    {
        assertNotNull(this.drinkFactorySingleton);

        Drink drink = drinkFactorySingleton.createDrink(DrinkType.COFFEE);
        assertNotNull(drink);

    }

    /**
     *  test the cost.
     */
    public void testCostBigDecimal()
    {
        Drink drink = drinkFactorySingleton.createDrink(DrinkType.COFFEE);
        assertNotNull(drink);
        BigDecimal tmp = BigDecimal.valueOf(2.75);
        assertEquals(tmp, drink.cost());
    }

    /**
     *  test cost string.
     */
    public void testCostString()throws Exception
    {
        assertEquals("$2.75", drinkFactorySingleton.drinkCost(DrinkType.COFFEE));
    }
}