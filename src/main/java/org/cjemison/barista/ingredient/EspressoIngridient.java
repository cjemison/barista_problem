package org.cjemison.barista.ingredient;

import org.cjemison.barista.util.IngredientType;
import org.cjemison.barista.drink.Drink;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EspressoIngridient extends DrinkDecarator
{
    private final IngredientType ingredientType = IngredientType.ESPRESSO;
    public EspressoIngridient(Drink drink)
    {
        super(drink);
    }

    @Override
    public BigDecimal cost()
    {
        return super.cost().add(BigDecimal.valueOf(1.10));
    }

    @Override
    public List<IngredientType> ingredientTypeList()
    {
        List<IngredientType> list = new ArrayList<IngredientType>();
        list.add(ingredientType);
        list.addAll(super.ingredientTypeList());
        return list;
    }
}
