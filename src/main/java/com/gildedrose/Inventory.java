package com.gildedrose;

import com.gildedrose.itemupdaters.*;

/**
 * Enum for specifying inventory items with their updaters
 */
public enum Inventory {
    BRIE("Aged Brie", new BrieUpdater()),
    BACKSTAGE("Backstage passes to a TAFKAL80ETC concert", new BackstageUpdater()),
    CONJURED("Conjured", new ConjuredItemUpdater()),
    SULFURAS("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());

    String name;
    ItemUpdater itemUpdater;

    Inventory(String name, ItemUpdater itemUpdater) {
        this.name = name;
        this.itemUpdater = itemUpdater;
    }

    /**
     * Gives the updater for the given item.
     * If the updater is not specified in the inventory, the updater for ordinary items will be returned
     * @param item item to get updater for
     * @return the updater for the item
     */
    public static ItemUpdater getItemUpdaterForItem(Item item) {
        for (Inventory inventoryItem : Inventory.values()) {
            if ((item.name != null && item.name.startsWith(inventoryItem.name))) {
                return inventoryItem.itemUpdater;
            }
        }
        return new OrdinaryItemUpdater();
    }

}
