package com.gildedrose;

/**
 * Class for the inventory of the Gilded Rose
 */
class GildedRose {

    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Updates the quality of the items in inventory depending on the item
     */
    public void updateQuality() {
        for (Item item : items) {
            //decrease quality of ordinary items
            if (!BRIE.equals(item.name)
                && !BACKSTAGE.equals(item.name)
                && item.quality > 0
                && !SULFURAS.equals(item.name)) {
                    item.quality--;
            } else {
                //increase quality of "better with age"-items
                if (item.quality < 50) {
                    item.quality++;

                    //extra increase of quality of backstage passes depending on sellIn date
                    if (BACKSTAGE.equals(item.name)) {
                        if (item.sellIn < 11 && item.quality < 50) {
                            item.quality++;
                        }
                        if (item.sellIn < 6 && item.quality < 50) {
                            item.quality++;
                        }
                    }
                }
            }

            //decrease sellIn date for all items except Sulfuras
            if (!SULFURAS.equals(item.name)) {
                item.sellIn--;
            }

            //extra update of quality when sellIn date has past
            if (item.sellIn < 0) {
                //extra decrease of quality of ordinary items
                if (!BRIE.equals(item.name)) {
                    if (!BACKSTAGE.equals(item.name)) {
                        if(item.quality > 0 && !SULFURAS.equals(item.name)) {
                            item.quality--;
                        }
                      //set quality of backstage passes at zero
                    } else {
                        item.quality = 0;
                    }
                } else {
                    //extra increase of quality of brie
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
            }
        }
    }
}