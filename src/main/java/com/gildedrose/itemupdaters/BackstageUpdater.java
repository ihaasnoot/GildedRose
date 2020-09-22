package com.gildedrose.itemupdaters;

import com.gildedrose.Item;

/**
 * Updater for backstage passes
 */
public class BackstageUpdater implements ItemUpdater {

    @Override
    public void updateQuality(Item item) {

        if(item.sellIn < 0){
            item.quality = 0;
        }else if(item.sellIn < 6){
            item.quality = item.quality + 3;
            ensureMaxQuality(item);
        }else if(item.sellIn < 11){
            item.quality = item.quality + 2;
            ensureMaxQuality(item);
        }else{
            item.quality++;
            ensureMaxQuality(item);
        }

    }
}
