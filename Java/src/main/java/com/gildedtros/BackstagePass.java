package com.gildedtros;

public class BackstagePass extends SubItem {

    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * Increase quality
     * Quality + 1 if sellin > 10
     * quality + 2 if 5 < sellin <= 10
     * quality + 2 if 0 <= sellin <= 5
     * quality = 0 if sellin date has passed
     */
    @Override
    public void updateQuality() {
        // if quality is smaller then 50, increase by 1.
        if (quality < 50) {
            if (sellIn > 10) {quality += 1;}
            else if (sellIn > 5) {
                quality = Math.min(quality + 2, 50);
            } else if (sellIn > 0) {
                quality = Math.min(quality + 3, 50);
            } else { quality = 0;}
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
