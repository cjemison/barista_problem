package org.cjemison.barista.drink;

import org.cjemison.barista.util.DrinkType;
import org.cjemison.barista.util.IngredientType;

import java.math.BigDecimal;
import java.util.List;


public abstract class Drink
{
    private DrinkType drinkType = null;

    public Drink(){
        this.drinkType = null;
    }

    public Drink(DrinkType drinkType) {
        this.drinkType = drinkType;
    }

    public abstract BigDecimal cost();

    public abstract List<IngredientType> ingredientTypeList();
}
