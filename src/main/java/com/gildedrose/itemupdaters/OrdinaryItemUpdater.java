package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

/**
 * Updater for ordinary items
 */
public class OrdinaryItemUpdater implements ItemUpdater {

    @Override
    public void updateQuality(Item item) {
        item.quality--;

        if(item.sellIn < 0){
            item.quality--;
        }

        ensureMinQuality(item);
    }
}
