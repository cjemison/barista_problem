package org.cjemison.barista.factory;


import org.cjemison.barista.drink.Drink;
import org.cjemison.barista.util.DrinkSingleton;
import org.cjemison.barista.util.DrinkType;
import org.cjemison.barista.util.IngredientSingleton;
import org.cjemison.barista.util.IngredientType;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DrinkFactorySingleton {
    private static DrinkFactorySingleton instance = null;
    private DrinkSingleton drinkSingleton = DrinkSingleton.getInstance();
    private IngredientSingleton ingredientSingleton = IngredientSingleton.getInstance();
    private CoffeeFactory coffeeFactory = null;
    private DeCafCoffeeFactory deCafCoffeeFactory = null;
    private CafeAmericanoFactory cafeAmericanoFactory = null;
    private CafeLatteFactory cafeLatteFactory = null;
    private CafeMochaFactory cafeMochaFactory = null;
    private CappuccinoFactory cappuccinoFactory = null;

    protected DrinkFactorySingleton() {

    }

    public static DrinkFactorySingleton getInstance() {
        if (instance == null) {
            instance = new DrinkFactorySingleton();
        }
        return instance;
    }

    public Drink createDrink(DrinkType drinkType) {
        return this.getBaseDrinkFactory(drinkType).createDrink();
    }

    public String drinkCost(DrinkType drinkType) {
        return this.getBaseDrinkFactory(drinkType).drinkCost();
    }

    public Boolean canDispense(DrinkType drinkType) {
        return this.getBaseDrinkFactory(drinkType).canCreateDrink();
    }

    public BaseDrinkFactory getBaseDrinkFactory(DrinkType drinkType)
    {
        BaseDrinkFactory baseDrinkFactory =null;


        switch (drinkType) {
            case COFFEE:
                if (coffeeFactory == null) {
                    coffeeFactory = new CoffeeFactory();
                }
                baseDrinkFactory = coffeeFactory;
                break;

            case DECAF_COFFEE:
                if (deCafCoffeeFactory == null) {
                    deCafCoffeeFactory = new DeCafCoffeeFactory();
                }
                baseDrinkFactory = deCafCoffeeFactory;
                break;

            case CAFE_AMERICANO:
                if (cafeAmericanoFactory == null) {
                    cafeAmericanoFactory = new CafeAmericanoFactory();
                }
                baseDrinkFactory = cafeAmericanoFactory;
                break;

            case CAFE_LATTE:
                if (cafeLatteFactory == null) {
                    cafeLatteFactory = new CafeLatteFactory();
                }
                baseDrinkFactory = cafeLatteFactory;
                break;

            case CAFE_MOCHA:
                if (cafeMochaFactory == null) {
                    cafeMochaFactory = new CafeMochaFactory();
                }
                baseDrinkFactory = cafeMochaFactory;
                break;

            case CAPPUCCINO:
                if (cappuccinoFactory == null) {
                    cappuccinoFactory = new CappuccinoFactory();
                }
                baseDrinkFactory = cappuccinoFactory;
                break;
        }
        return baseDrinkFactory;
    }


    public void printInventory() {
        System.out.println("\nInventory:");
        for (IngredientType key : IngredientType.values()) {
            String tmp = String.format("%s, %s", key.toString(), ingredientSingleton.inventory().get(key).toString());
            System.out.println(tmp);
        }
    }

    public List<String> printMenu() {
        List<String> list = new ArrayList<String>();
        for (DrinkType key : DrinkType.values()) {
            String tmp = String.format("%s, %s, %s", key.toString(), this.drinkCost(key), this.canDispense(key));
            list.add(tmp);
        }
        return list;
    }

    private String formatBigDecimal(BigDecimal bigDecimal) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format(bigDecimal);
    }

}
