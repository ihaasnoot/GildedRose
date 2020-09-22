package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

/**
 * Updater for conjured items
 */
public class ConjuredItemUpdater implements ItemUpdater {

    @Override
    public void updateQuality(Item item) {
        item.quality = item.quality - 2;

        if (item.sellIn < 0 ) {
            item.quality = item.quality - 2;
        }

        ensureMinQuality(item);
    }
}
