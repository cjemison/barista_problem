package org.cjemison.barista.ingredient;

import org.cjemison.barista.drink.Drink;
import org.cjemison.barista.util.IngredientType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SugarIngridient extends DrinkDecarator {
    private final IngredientType ingredientType = IngredientType.SUGAR;

    public SugarIngridient(Drink drink) {
        super(drink);
    }

    @Override
    public BigDecimal cost() {
        return super.cost().add(BigDecimal.valueOf(0.25));
    }

    @Override
    public List<IngredientType> ingredientTypeList() {
        List<IngredientType> list = new ArrayList<IngredientType>();
        list.add(ingredientType);
        list.addAll(super.ingredientTypeList());

        return list;
    }
}
