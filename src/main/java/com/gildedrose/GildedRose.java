package com.gildedrose;

import com.gildedrose.itemupdaters.ItemUpdater;

/**
 * Class for the inventory of the Gilded Rose
 */
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * Updates the quality of the items in inventory depending on the item
     */
    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater itemUpdater = Inventory.getItemUpdaterForItem(item);
            itemUpdater.updateSellIn(item);
            itemUpdater.updateQuality(item);
        }
    }

}