package com.gildedrose;

public class BackstagePassUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn < 5) {
            increaseQuality(item, 3);
        } else if (item.sellIn < 10) {
            increaseQuality(item, 2);
        } else {
            increaseQuality(item, 1);
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void increaseQuality(Item item, int increment) {
        item.quality = Math.min(item.quality + increment, 50);
    }
}
