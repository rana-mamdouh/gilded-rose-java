package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdaterFactory {
    private static final Map<String, ItemUpdater> updaterMap = new HashMap<>();

    static {
        updaterMap.put("Aged Brie", new AgedBrieUpdater());
        updaterMap.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        updaterMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaterMap.put("Conjured Mana Cake", new ConjuredItemUpdater());
    }

    public static ItemUpdater getItemUpdater(Item item) {
        return updaterMap.getOrDefault(item.name, new DefaultItemUpdater());
    }
}
