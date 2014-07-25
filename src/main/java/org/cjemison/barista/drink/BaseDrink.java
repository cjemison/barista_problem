package org.cjemison.barista.drink;


import org.cjemison.barista.util.DrinkType;
import org.cjemison.barista.util.IngredientType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BaseDrink extends Drink
{
    private List<IngredientType> list = new ArrayList<IngredientType>();

    public BaseDrink(DrinkType drinkType)
    {
        super(drinkType);
    }

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(0);
    }

    @Override
    public List<IngredientType> ingredientTypeList() {
        return list;
    }
}
