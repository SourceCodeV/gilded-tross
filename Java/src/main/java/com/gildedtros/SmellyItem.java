package com.gildedtros;

public class SmellyItem extends SubItem {

    public SmellyItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * Decreased quality twice as fast
     */
    @Override
    public void updateQuality() {
        if (sellIn > 0) {
            quality = Math.max(quality - 2, 0);
        } else {
            quality = Math.max(quality - 4, 0);
        }
    }

    /**
     * Decrease Sell In by 1.
     */
    @Override
    public void updateSellIn() {
        sellIn -= 1;
    }
}
