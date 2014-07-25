package org.cjemison.barista.factory;


import org.cjemison.barista.drink.Drink;
import org.cjemison.barista.util.DrinkType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeCafCoffeeFactory extends BaseDrinkFactory {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public DeCafCoffeeFactory() {
        super(DrinkType.DECAF_COFFEE);
    }


    @Override
    public Drink createDrink() {
        try {
            Drink drink = this.addIngredients(true);
            return drink;
        } catch (Exception e) {
            this.logger.error("### ERROR ###", e);
            return null;
        }

    }
}