package org.cjemison.barista;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.cjemison.barista.factory.DrinkFactorySingleton;
import org.cjemison.barista.factory.*;

public class CostTest extends TestCase
{
    private DrinkFactorySingleton drinkFactorySingleton = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CostTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CostTest.class);
    }

    @Override
    public void setUp() {
        this.drinkFactorySingleton = DrinkFactorySingleton.getInstance();
    }


    public void testCoffee()
    {
        assertNotNull(this.drinkFactorySingleton);

        CoffeeFactory coffeeFactory = new CoffeeFactory();
        assertNotNull(coffeeFactory);
        assertNotNull(coffeeFactory.drinkCost());
        assertEquals("$2.75", coffeeFactory.drinkCost());
    }

    public void testDecafCoffee()
    {
        assertNotNull(this.drinkFactorySingleton);

        DeCafCoffeeFactory coffeeFactory = new DeCafCoffeeFactory();
        assertNotNull(coffeeFactory);
        assertNotNull(coffeeFactory.drinkCost());
        assertEquals("$2.75", coffeeFactory.drinkCost());
    }

    public void testCafeMocha()
    {
        assertNotNull(this.drinkFactorySingleton);

        CafeMochaFactory coffeeFactory = new CafeMochaFactory();
        assertNotNull(coffeeFactory);
        assertNotNull(coffeeFactory.drinkCost());
        assertEquals("$3.35", coffeeFactory.drinkCost());
    }

    public void testCafeLatte()
    {
        assertNotNull(this.drinkFactorySingleton);

        CafeLatteFactory coffeeFactory = new CafeLatteFactory();
        assertNotNull(coffeeFactory);
        assertNotNull(coffeeFactory.drinkCost());
        assertEquals("$2.55", coffeeFactory.drinkCost());
    }

    public void testCafeAmericano()
    {
        assertNotNull(this.drinkFactorySingleton);

        CafeAmericanoFactory coffeeFactory = new CafeAmericanoFactory();
        assertNotNull(coffeeFactory);
        assertNotNull(coffeeFactory.drinkCost());
        assertEquals("$3.30", coffeeFactory.drinkCost());
    }

    public void testCappuccino()
    {
        assertNotNull(this.drinkFactorySingleton);

        CappuccinoFactory coffeeFactory = new CappuccinoFactory();
        assertNotNull(coffeeFactory);
        assertNotNull(coffeeFactory.drinkCost());
        assertEquals("$2.90", coffeeFactory.drinkCost());
    }
}