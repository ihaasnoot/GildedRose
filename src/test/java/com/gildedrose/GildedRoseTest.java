package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testUpdateQuality() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("foo", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void testUpdateQuality_QualityNotNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testUpdateQuality_QualityAfterSellIn() {
        Item[] items = new Item[] { new Item("foo", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void testUpdateQuality_QualityMax50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void testUpdateQuality_AgedBrie() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 10, 10),
                new Item("Aged Brie", -1, 10),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);

        assertEquals("Aged Brie", app.items[1].name);
        assertEquals(-2, app.items[1].sellIn);
        assertEquals(12, app.items[1].quality);
    }

    @Test
    void testUpdateQuality_Sulfuras() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 10, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[1].name);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(80, app.items[1].quality);
    }

    @Test
    void testUpdateQuality_Backstage() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 7, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 10),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10)
        };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals(6, app.items[1].sellIn);
        assertEquals(12, app.items[1].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[2].name);
        assertEquals(2, app.items[2].sellIn);
        assertEquals(13, app.items[2].quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[3].name);
        assertEquals(-2, app.items[3].sellIn);
        assertEquals(0, app.items[3].quality);
    }
}
