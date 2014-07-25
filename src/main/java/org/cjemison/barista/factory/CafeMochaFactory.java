package org.cjemison.barista.factory;


import org.cjemison.barista.drink.Drink;
import org.cjemison.barista.util.DrinkType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CafeMochaFactory extends BaseDrinkFactory {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CafeMochaFactory() {
        super(DrinkType.CAFE_MOCHA);
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

