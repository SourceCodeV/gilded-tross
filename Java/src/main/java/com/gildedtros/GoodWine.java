package com.gildedtros;

public class GoodWine extends SubItem {

    public GoodWine(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * Increase quality
     * quality + 1
     * quality + 2 if sellin date has passed
     */
    @Override
    public void updateQuality() {
        if (quality < 50) {
            if (sellIn < 0) {
                quality = Math.min(quality + 2, 50);
            } else {
                quality += 1;
            }
        }
    }

    /**
     * SellIn base behavior
     * sellIn -1
     */
    @Override
    public void updateSellIn() {
        sellIn -= 1;
    }
}
