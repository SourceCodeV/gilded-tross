package com.gildedtros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedTrosTest {

    /**
     * update all items once with their base behavior
     */
    @Test
    void testBaseBehavior() {
        Item[] items = new Item[] {
                new BackstagePass("Pass", 12,10),
                new GoodWine("Wine", 12,10),
                new Keychain("B-DAWG keychain", 11,10),
                new SmellyItem("Duplicate Code", 12,10),
                new SmellyItem("Long Methods", 12,10),
                new SmellyItem("Ugly Variable Names", 12,10)
        };
        GildedTros app = new GildedTros(items);
        app.updateQuality();

        for (Item item : app.items) {
            assertEquals(11, item.sellIn);
        }
        assertEquals(11, app.items[0].quality );
        assertEquals(11, app.items[1].quality );
        assertEquals(10, app.items[2].quality );
        assertEquals(8, app.items[3].quality );
    }

    /**
     * wine base and edge behavior test, update once
     */
    @Test
    void testWine() {
        Item[] items = new Item[] {
                new GoodWine("BaseWine", 10,10),
                new GoodWine("OldWine", -1,10),
                new GoodWine("EdgeWine", 0,10),
                new GoodWine("QualitativeOldWine", -1,49),
                new GoodWine("QualitativeEdgeWine", 0,50),
                new GoodWine("QualitativeNewWine", 5,49)
        };

        GildedTros app = new GildedTros(items);
        app.updateQuality();

        //Quality check
        assertEquals(11, app.items[0].quality );
        assertEquals(12, app.items[1].quality );
        assertEquals(11, app.items[2].quality );
        assertEquals(50, app.items[3].quality );
        assertEquals(50, app.items[3].quality );
        assertEquals(50, app.items[3].quality );

        //Sellin Check
        assertEquals(9, app.items[0].sellIn );
    }

    /**
     * Backstage passes base and edge behavior test, update once
     */
    @Test
    void testBackstagePass() {
        Item[] items = new Item[] {
                new BackstagePass("FarAwayPass", 15,9),
                new BackstagePass("MidAgedPass", 8,8),
                new BackstagePass("ClosebyPass", 5,7),
                new BackstagePass("PassedPass", -1,10),
        };

        GildedTros app = new GildedTros(items);
        app.updateQuality();

        assertEquals(10, app.items[0].quality);
        assertEquals(10, app.items[1].quality);
        assertEquals(10, app.items[2].quality);
        assertEquals(0, app.items[3].quality);

        assertEquals(14, app.items[0].sellIn);
        assertEquals(7, app.items[1].sellIn);
        assertEquals(4, app.items[2].sellIn);
        assertEquals(-2, app.items[3].sellIn);
    }

    /**
     * keychain behavior, update once
     */
    @Test
    void testKeychain() {
        Item[] items = new Item[] {
                new Keychain("B-DAWG keychain", 10,10)
        };

        GildedTros app = new GildedTros(items);
        app.updateQuality();

        assertEquals(10, app.items[0].quality );
        assertEquals(10, app.items[0].sellIn );
    }

    /**
     * smelly items base and edge behavior test, update once
     */
    @Test
    void testSmelly() {
        Item[] items = new Item[] {
                new SmellyItem("smelling", 10,10),
                new SmellyItem("oldSmelling", -1,10),
                new SmellyItem("lowQualitySmelling", -1,4),
                new SmellyItem("lowerQualitySmelling", -1,3),
                new SmellyItem("lowestQualitySmelling", -1,0),
        };

        GildedTros app = new GildedTros(items);
        app.updateQuality();

        assertEquals(8, app.items[0].quality );
        assertEquals(9, app.items[0].sellIn );

        assertEquals(6, app.items[1].quality );
        assertEquals(-2, app.items[1].sellIn );

        assertEquals(0, app.items[2].quality );
        assertEquals(0, app.items[3].quality );
        assertEquals(0, app.items[4].quality );
    }

    /**
     * all items, updated multiple times
     */
    @Test
    void testStory() {
        Item[] items = new Item[] {
                new BackstagePass("Pass", 12,10),
                new GoodWine("Wine", 12,10),
                new Keychain("B-DAWG keychain", 11,10),
                new SmellyItem("Duplicate Code", 12,10),
                new BackstagePass("Not0Pass", 21,0),
        };
        GildedTros app = new GildedTros(items);

        for (int i = 0; i < 20 ; i++) {
            app.updateQuality();
        }

        assertEquals(0, app.items[0].quality );
        assertEquals(-8, app.items[0].sellIn );

        // quality 37 = 10 + 13 * 1 + 7 * 2
        assertEquals(37, app.items[1].quality );
        assertEquals(-8, app.items[1].sellIn );

        assertEquals(10, app.items[2].quality );
        assertEquals(11, app.items[2].sellIn );

        assertEquals(0, app.items[3].quality );
        assertEquals(-8, app.items[3].sellIn );

        assertEquals(33, app.items[4].quality );
        assertEquals(1, app.items[4].sellIn );
    }
}
