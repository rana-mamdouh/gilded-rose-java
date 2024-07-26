package com.gildedrose;

public class DefaultItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        decreaseSellIn(item);
        decreaseQuality(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
