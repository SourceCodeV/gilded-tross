package com.gildedtros;

public class SubItem extends Item {
    public SubItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * Quality base behavior
     * quality -1
     * quality -2 if sell in has passed
     */
    public void updateQuality() {
        if (sellIn >= 0) {
            quality -= 1;
        } else { quality = Math.max(quality - 2, 0);}
    };

    /**
     * SellIn base behavior
     * sellIn -1
     */
    public void updateSellIn() {sellIn -=1; };
}
