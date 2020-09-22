package com.gildedrose;

/**
 * Class for the inventory of the Gilded Rose
 */
class GildedRose {

    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";

    private static final Integer MIN_QUALITY = 0;
    private static final Integer MAX_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Updates the quality of the items in inventory depending on the item
     */
    public void updateQuality() {
        for (Item item : items) {

            // no update for Sulfuras item
            if(SULFURAS.equals(item.name)){
                continue;
            }

            // update Sellin date
            item.sellIn--;

            // update quality depending on item
            if (BRIE.equals(item.name)) {
                updateQualityAgedBrie(item);
            } else if (BACKSTAGE.equals(item.name)) {
                updateQualityBackstage(item);
            } else if (isConjuredItem(item)) {
                updateQualityConjuredItem(item);
            } else {
                updateQualityOrdinaryItem(item);
            }

        }
    }

    private void updateQualityAgedBrie(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }

        if (item.sellIn < 0 && item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    private void updateQualityBackstage(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            if (item.quality < MAX_QUALITY) {
                item.quality++;

                //extra increase of quality of backstage passes depending on sellIn date
                if (item.sellIn < 11 && item.quality < MAX_QUALITY) {
                    item.quality++;
                }
                if (item.sellIn < 6 && item.quality < MAX_QUALITY) {
                    item.quality++;
                }
            }
        }
    }

    private boolean isConjuredItem(Item item) {
        return item.name != null && item.name.startsWith(CONJURED);
    }

    private void updateQualityConjuredItem(Item item) {
        updateQualityOrdinaryItem(item);
        updateQualityOrdinaryItem(item);
    }

    private void updateQualityOrdinaryItem(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
        if (item.sellIn < 0 && item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }

}