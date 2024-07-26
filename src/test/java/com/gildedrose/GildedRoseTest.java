package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  @Test
  public void testNormalItem() {
    Item[] items = new Item[] { new Item("Normal Item", 10, 20) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(19, app.items[0].quality);
  }

  @Test
  public void testNormalItemPastSellByDate() {
    Item[] items = new Item[] { new Item("Normal Item", 0, 20) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(-1, app.items[0].sellIn);
    assertEquals(18, app.items[0].quality);
  }

  @Test
  public void testQualityNeverNegative() {
    Item[] items = new Item[] { new Item("Normal Item", 5, 0) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(4, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
  }

  @Test
  public void testAgedBrie() {
    Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(21, app.items[0].quality);
  }

  @Test
  public void testAgedBrieQualityCap() {
    Item[] items = new Item[] { new Item("Aged Brie", 10, 49) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(50, app.items[0].quality);
  }

  @Test
  public void testSulfuras() {
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 40) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(5, app.items[0].sellIn);
    assertEquals(40, app.items[0].quality);
  }

  @Test
  public void testBackstagePasses() {
    Item[] items = new Item[] {
        new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20),
        new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(14, app.items[0].sellIn);
    assertEquals(21, app.items[0].quality);

    assertEquals(9, app.items[1].sellIn);
    assertEquals(22, app.items[1].quality);

    assertEquals(4, app.items[2].sellIn);
    assertEquals(23, app.items[2].quality);

    assertEquals(-1, app.items[3].sellIn);
    assertEquals(0, app.items[3].quality); 
  }

  @Test
  public void testConjuredItems() {
    Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 20) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(18, app.items[0].quality);

    Item[] pastItems = new Item[] { new Item("Conjured Mana Cake", 0, 20) };
    GildedRose pastApp = new GildedRose(pastItems);

    pastApp.updateQuality();
    assertEquals(-1, pastApp.items[0].sellIn);
    assertEquals(16, pastApp.items[0].quality);
  }
}
