package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

  @Test
  public void at_the_end_of_each_day_system_lowers_quality_sellin_values_for_every_item() {
    Item[] items = new Item[] { new Item("item", 5, 2) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(4, app.items[0].sellIn);
    assertEquals(1, app.items[0].quality);
  }

  @Test
  public void once_the_sell_by_date_has_passed_quality_degrades_twice_as_fast() {
    Item[] items = new Item[] { new Item("item", -1, 4) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(-2, app.items[0].sellIn);
    assertEquals(2, app.items[0].quality);
  }

  @Test
  public void the_quality_of_an_item_is_never_negative() {
    Item[] items = new Item[] { new Item("item", 5, 0) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(4, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
  }

  @Test
  public void Aged_Brie_increases_in_quality_the_older_it_gets() {
    Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(4, app.items[0].sellIn);
    assertEquals(6, app.items[0].quality);
  }

  @Test
  public void the_quality_of_an_item_is_never_more_than_50() {
    Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(4, app.items[0].sellIn);
    assertEquals(50, app.items[0].quality);
  }

  @Test
  public void sulfuras_never_has_to_be_sold_or_decreases() {
    Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 5) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(5, app.items[0].sellIn);
    assertEquals(5, app.items[0].quality);
  }

  @Test
  public void backstage_passes_increases_in_quality_as_its_sellIn_value_approaches() {
    Item[] items = new Item[] {
      new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10),
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(19, app.items[0].sellIn);
    assertEquals(11, app.items[0].quality);
  }

  @Test
  public void backstage_passes_increases_in_quality_by_2_as_its_sellIn_value_10_or_less() {
    Item[] items = new Item[] {
      new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(12, app.items[0].quality);
  }

  @Test
  public void backstage_passes_increases_in_quality_by_3_as_its_sellIn_value_5_or_less() {
    Item[] items = new Item[] {
      new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10),
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(4, app.items[0].sellIn);
    assertEquals(13, app.items[0].quality);
  }

  @Test
  public void backstage_passes_quality_of_an_item_is_never_more_than_50() {
    Item[] items = new Item[] {
      new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50),
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(50, app.items[0].quality);
  }

  @Test
  public void backstage_passes_quality_of_an_item_drops_to_0_after_the_concert() {
    Item[] items = new Item[] {
      new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10),
    };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(-2, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
  }

  @Test
  public void conjured_mana_cake_degrade_in_quality_twice_as_fast_as_normal_items() {
    Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 10) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(8, app.items[0].quality);
  }
  
  @Test
  public void once_the_sell_by_date_has_passed_quality_of_conjured_mana_cake_degrades_twice_as_fast_as_normal_items() {
    Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 4) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(-2, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
  }
  
  @Test
  public void the_quality_of_conjured_mana_cake_item_is_never_negative() {
    Item[] items = new Item[] { new Item("item", 10, 0) };
    GildedRose app = new GildedRose(items);

    app.updateQuality();

    assertEquals(9, app.items[0].sellIn);
    assertEquals(0, app.items[0].quality);
  }
}
