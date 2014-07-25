package org.cjemison.barista.util;

public class DrinkObject implements Comparable<DrinkObject>
{
    private IngredientType ingredientType;
    private int qty = 0;

    public DrinkObject() {
    }

    public DrinkObject(int qty, IngredientType ingredientType) {
        this.qty = qty;
        this.ingredientType = ingredientType;
    }

    public IngredientType getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "DrinkObject{" +
                "ingridentType=" + ingredientType +
                ", qty=" + qty +
                '}';
    }

    @Override
    public int compareTo(DrinkObject drinkObject) {
        return this.ingredientType.toString().compareTo(drinkObject.getIngredientType().toString());
    }
}
