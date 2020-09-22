package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

/**
 * Updater for Aged brie item
 */
public class BrieUpdater implements ItemUpdater {

    @Override
    public void updateQuality(Item item) {
        item.quality++;

        if (item.sellIn < 0 ) {
            item.quality++;
        }

        ensureMaxQuality(item);
    }
}
