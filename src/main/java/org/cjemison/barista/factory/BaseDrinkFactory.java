package org.cjemison.barista.factory;


import org.cjemison.barista.drink.BaseDrink;
import org.cjemison.barista.drink.Drink;
import org.cjemison.barista.ingredient.*;
import org.cjemison.barista.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public abstract class BaseDrinkFactory {
    private DrinkSingleton drinkSingleton = DrinkSingleton.getInstance();
    private IngredientSingleton ingredientSingleton = IngredientSingleton.getInstance();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private DrinkType drinkType = null;

    public BaseDrinkFactory(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public abstract Drink createDrink();

    public Drink addIngredients(boolean updateInventory) throws Exception {
        List<DrinkObject> list = drinkSingleton.getMap().get(this.drinkType);
        Drink drink = new BaseDrink(this.drinkType);
        for (DrinkObject drinkObject : list) {
            for (int i = 0; i < drinkObject.getQty(); i++) {
                this.logger.debug(drinkObject.getIngredientType().toString());
                drink = this.addIngrident(drink, drinkObject.getIngredientType(), updateInventory);
                this.logger.debug(drink.cost().toString());

                if (updateInventory) {
                    this.updateRepository(drinkObject.getIngredientType());
                }
            }
        }
        return drink;
    }

    private Drink addIngrident(Drink drink, IngredientType ingredientType, boolean updateInventory) throws Exception {
        if (ingredientType == null) {
            throw new Exception("ingredientType is null.");
        }

        if (ingredientSingleton.inventory().get(ingredientType).intValue() < 0) {
            throw new Exception("No Inventory Available.");
        }

        if (ingredientType == IngredientType.COCOA) {
            return new CocoaIngredient(drink);
        } else if (ingredientType == IngredientType.COFFEE) {
            return new CoffeeIngredient(drink);
        } else if (ingredientType == IngredientType.CREAM) {
            return new CreamIngridient(drink);
        } else if (ingredientType == IngredientType.DECAF_COFFEE) {
            return new DecafCoffeeIngredient(drink);
        } else if (ingredientType == IngredientType.ESPRESSO) {
            return new EspressoIngridient(drink);
        } else if (ingredientType == IngredientType.FOAMED_MILK) {
            return new FoamedMilkIngridient(drink);
        } else if (ingredientType == IngredientType.STEAMED_MILK) {
            return new SteamedMilkIngridient(drink);
        } else if (ingredientType == IngredientType.SUGAR) {
            return new SugarIngridient(drink);
        } else if (ingredientType == IngredientType.WHIPPED_CREAM) {
            return new WhippedCreamIngridient(drink);
        } else {
            return drink;
        }
    }

    private void updateRepository(IngredientType ingredientType) throws Exception {
        Integer i = this.ingredientSingleton.inventory().get(ingredientType);
        if (i.intValue() > 0) {
            this.ingredientSingleton.inventory().remove(ingredientType);
            this.ingredientSingleton.inventory().put(ingredientType, Integer.valueOf(i.intValue() - 1));
        } else {
            throw new Exception("Not enough ingredients. " + ingredientType.toString());
        }
    }

    public String drinkCost() {
        Drink drink = new BaseDrink(this.drinkType);
        try {
            for (DrinkObject drinkObject : drinkSingleton.getMap().get(drinkType)) {
                this.logger.debug(drinkObject.toString());
                for (int i = 0; i < drinkObject.getQty(); i++) {
                    this.logger.debug(drinkObject.getIngredientType().toString());
                    drink = this.addIngrident(drink, drinkObject.getIngredientType(), false);
                }
            }
        } catch (Exception e) {
            this.logger.error("### ERROR ###", e);
            drink = new BaseDrink(this.drinkType);
        }
        return this.formatBigDecimal(drink.cost());
    }

    private String formatBigDecimal(BigDecimal bigDecimal) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format(bigDecimal);
    }

    public boolean canCreateDrink() {
        Drink drink = new BaseDrink(this.drinkType);
        try {
            for (DrinkObject drinkObject : drinkSingleton.getMap().get(drinkType)) {
                this.logger.debug(drinkObject.toString());
                for (int i = 0; i < drinkObject.getQty(); i++) {

                    int qty = this.ingredientSingleton.inventory().get(drinkObject.getIngredientType());

                    if (qty < drinkObject.getQty()) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            this.logger.error("### ERROR ###", e);
        }
        return true;
    }
}
