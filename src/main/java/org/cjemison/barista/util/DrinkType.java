package org.cjemison.barista.util;

public enum DrinkType
{
    CAFE_AMERICANO("Caffe Americano"),
    CAFE_LATTE("Caffe Latte"),
    CAFE_MOCHA("Caffe Mocha"),
    CAPPUCCINO("Cappuccino"),
    COFFEE("Coffee"),
    DECAF_COFFEE("Decafe Coffee");

    private String text="";

    private DrinkType(String text)
    {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString()
    {
        return text.trim();
    }

    public static DrinkType getEnum(String value) {
        for(DrinkType v : values())
        {
            if(v.getText().equalsIgnoreCase(value)) return v;
        }
        throw new IllegalArgumentException("Invalid Value: "+value);
    }

}
