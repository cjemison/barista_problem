package org.cjemison.barista.ingredient;

import org.cjemison.barista.util.IngredientType;
import org.cjemison.barista.drink.Drink;

import java.math.BigDecimal;
import java.util.List;

public abstract class DrinkDecarator extends Drink
{
    protected final Drink drink ;

    public DrinkDecarator(Drink drink)
    {
        this.drink = drink;
    }

    @Override
    public BigDecimal cost()
    {
        return drink.cost();
    }

    @Override
    public List<IngredientType> ingredientTypeList() {
        return drink.ingredientTypeList();
    }
}
