package com.gildedtros;

public class Keychain extends SubItem {

    public Keychain(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    /**
     * No quality change
     */
    @Override
    public void updateQuality() {
    }

    /**
     * No sellin change
     */
    @Override
    public void updateSellIn() {
    }
}
