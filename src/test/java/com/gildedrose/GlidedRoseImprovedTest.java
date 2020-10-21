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

    @Test
    void decreaseSellIn() {
        Item[] items = new Item[] { new Item("default", 11, 10) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }
	
    @Test
    void expiredSellIn() {
        Item[] items = new Item[] { new Item("default", 0, 10) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(8, app.getItemQuality());
    }	   

    @Test
    void nonNegativeQuality() {
        Item[] items = new Item[] { new Item("default", 10, 0) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(0, app.getItemQuality());
    }	

    @Test
    void decreaseQuality() {
        Item[] items = new Item[] { new Item("default", 10, 10) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(9, app.getItemQuality());
    }

    @Test
    void maxQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(50, app.getItemQuality());
    }	    

    @Test
    void expiredSellInAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", -1, 40) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(41, app.getItemQuality());
    }

    @Test
    void qualityItemSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras", 10, 30) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(80, app.getItemQuality());
        assertEquals(0, app.getItemSellIn());
    }

    @Test
    void tenDaysSellInbaskstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes", 10, 6) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(8, app.getItemQuality());
    }

    @Test
    void fiveDaysSellInbaskstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes", 5, 5) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(8, app.getItemQuality());
    }

    @Test
    void expiredSellInbaskstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes", 0, 5) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(0, app.getItemQuality());
    }

    @Test
    void decreaseQualityConjured() {
        Item[] items = new Item[] { new Item("Conjured", 5, 10) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        app.updateQuality();
        assertEquals(8, app.getItemQuality());
    }
    
    @Test
    void testGetItemSellIn() {
        Item[] items = new Item[] { new Item("default", 5, 10) };
        GlidedRoseImproved app = new GlidedRoseImproved(items);
        assertEquals(5, app.getItemSellIn());
    }
    
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