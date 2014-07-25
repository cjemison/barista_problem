package org.cjemison.barista.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class IngredientSingleton {
    protected static IngredientSingleton instance;
    private Map<IngredientType, Integer> inventory = null;
    private boolean initialized = false;
    private Logger logger   = LoggerFactory.getLogger(this.getClass());
    private final int INGREDIENT_COUNT = 10;

    public static IngredientSingleton getInstance() {
        if (instance == null) {
            instance = new IngredientSingleton();
            instance.init();
        }
        return instance;
    }

    private void init()
    {
        this.inventory = new HashMap<IngredientType, Integer>();
        for(IngredientType ingredientType : IngredientType.values())
        {
            this.inventory.put(ingredientType, this.INGREDIENT_COUNT);
        }
    }

    public Map<IngredientType, Integer> inventory()
    {
        return this.inventory;
    }
}
