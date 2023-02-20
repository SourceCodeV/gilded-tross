package com.gildedtros;

class GildedTros {
    Item[] items;

    public GildedTros(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // update quality and sellin date for all items
        for (Item item : items) {
            if (item instanceof SubItem) {
                ((SubItem) item).updateQuality();
                ((SubItem) item).updateSellIn();
            }
        }
    }
}