package org.cjemison.barista.ingredient;

import org.cjemison.barista.drink.Drink;
import org.cjemison.barista.util.IngredientType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CocoaIngredient extends DrinkDecarator
{
    private final IngredientType ingredientType = IngredientType.COCOA;
    public CocoaIngredient(Drink drink)
    {
        super(drink);
    }

    @Override
    public BigDecimal cost()
    {
        return super.cost().add(BigDecimal.valueOf(0.90));
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
