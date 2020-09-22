package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

/**
 * Interface for the updaters of the items
 */
public interface ItemUpdater {

    Integer MIN_QUALITY = 0;
    Integer MAX_QUALITY = 50;

    /**
     * Update quality of the given item
     * @param item the inventory item
     */
    void updateQuality(Item item);

    /**
     * Update SellIn date of the given item
     * @param item the inventory item
     */
    default void updateSellIn(Item item){
        item.sellIn--;
    }

    /**
     * Sets the quality at its minimum when the limit is exceeded
     * @param item the inventory item
     */
    default void ensureMinQuality(Item item) {
        if(item.quality < MIN_QUALITY){
            item.quality = MIN_QUALITY;
        }
    }

    /**
     * Sets the quality at its maximum when the limit is exceeded
     * @param item the inventory item
     */
    default void ensureMaxQuality(Item item) {
        if(item.quality > MAX_QUALITY){
            item.quality = MAX_QUALITY;
        }
    }
}
