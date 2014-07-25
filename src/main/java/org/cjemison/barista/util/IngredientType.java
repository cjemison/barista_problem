package org.cjemison.barista.util;


public enum IngredientType
{
    COCOA("COCOA"),
    COFFEE("COFFEE"),
    DECAF_COFFEE("DECAF COFFEE"),
    CREAM("CREAM"),
    ESPRESSO("ESPRESSO"),
    FOAMED_MILK("FOAMED MILK"),
    SUGAR("SUGAR"),
    STEAMED_MILK("STEAMED MILK"),
    WHIPPED_CREAM("WHIPPED CREAM");


    private String text="";

    private IngredientType(String text)
    {
        this.text = text;
    }

    public String toString()
    {
        return text.trim().toUpperCase();
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static IngredientType getEnum(String value) {
        for(IngredientType v : values())
        {
            if(v.getText().equalsIgnoreCase(value)) return v;
        }
        throw new IllegalArgumentException("Invalid value "+value);
    }
}
