package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
* Unit tests for GlidedRoseImproved class.
*
* @author  diavbolo
* @version 1.0
*/
class GlidedRoseImprovedTest {

    /**
     * Decrease the sellIn of a normal item
     */
    @Test
    void decreaseSellIn() {
        Item[] items = new Item[] { new Item("Normal", 11, 10) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }

    /**
     * Once the sell by date has passed, Quality degrades twice as fast.
     */
    @Test
    void expiredSellIn() {
        Item[] items = new Item[] { new Item("Normal", 0, 10) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(8, app.getItemQuality());
    }   

    /**
     * The Quality of an item is never negative.
     */
    @Test
    void nonNegativeQuality() {
        Item[] items = new Item[] { new Item("Normal", 10, 0) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(0, app.getItemQuality());
    }

    /**
     * Decrease the quality of a normal item
     */
    @Test
    void decreaseQuality() {
        Item[] items = new Item[] { new Item("Normal", 10, 10) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(9, app.getItemQuality());
    }

    /**
     * The Quality of an item is never more than 50.
     */
    @Test
    void maxQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(50, app.getItemQuality());
    }    

    /**
     * "Aged Brie" actually increases in Quality the older it gets.
     */
    @Test
    void expiredSellInAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 40) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(41, app.getItemQuality());
    }

    /**
     * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality.
     */
    @Test
    void qualityItemSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras", 10, 30) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(80, app.getItemQuality());
        assertEquals(0, app.getItemSellIn());
    }

    /**
     * "Backstage passes" quality increases by 2 when there are 10 days or less
     */
    @Test
    void tenDaysSellInbaskstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes", 10, 6) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(8, app.getItemQuality());
    }

    /**
     * "Backstage passes" quality increases by 3 when there are 5 days or less
     */
    @Test
    void fiveDaysSellInbaskstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes", 5, 5) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(8, app.getItemQuality());
    }

    /**
     * "Backstage passes" quality drops to 0 after the concert.
     */
    @Test
    void expiredSellInbaskstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes", 0, 5) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(0, app.getItemQuality());
    }

    /**
     * "Conjured" items degrade in Quality twice as fast as normal items.
     */
    @Test
    void decreaseQualityConjured() {
        Item[] items = new Item[] { new Item("Conjured", 5, 10) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(8, app.getItemQuality());
    }

    /**
     * At the end of each day our system lowers sellIn value
     */
    @Test
    void testGetItemSellIn() {
        Item[] items = new Item[] { new Item("Normal", 5, 10) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(4, app.getItemSellIn());
    }

    /**
     * Test a list of items
     */
    @Test
    void testUpdateQuality() {
        Item[] items = new Item[] { new Item("Conjured", 5, 10), new Item("Conjured", 4, 9) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(7, app.getItemQuality());
        app.setPosition(0);
        assertEquals(8, app.getItemQuality());
    }
    
}