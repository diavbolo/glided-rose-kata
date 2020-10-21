package com.gildedrose;

/**
* The GlidedRoseImproved class, defined as a child of 
* GildedRose, implements the handling of diverse items
* regarding the expiration and the quality.
*
* @author  diavbolo
* @version 1.0
*/
public class GlidedRoseImproved extends GildedRose {
	int position = 0;
    static final int MAXQUALITY = 50;

    /**
     * Constructor that initialises using the parent class.
     * @param Item[] List of items
     */
	public GlidedRoseImproved(Item[] items) {
		super(items);
	}

    /**
     * Getter that retrieves sellIn value.
     */	
	public int getItemSellIn() {
		return items[position].sellIn;
	}

    /**
     * Getter that retrieves quality value.
     */	
	public int getItemQuality() {
		return items[position].quality;
	}

    /**
     * Setter that sets sellIn value.
     * @param value
     */	
	public void setItemSellIn(int value) {
		items[position].sellIn = value;
	}

    /**
     * Setter that sets quality value.
     * @param value
     */
	public void setItemQuality(int value) {
		items[position].quality = value;
	}

    /**
     * Setter that sets the list position.
     * @param position
     */
	public void setPosition(int position) {
		this.position = position;
	}

    /**
     * Function that updates the items quality based on its name.
     */	
	@Override
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	setPosition(i);
        	String name = items[position].name;
          
        	// Adjust quality
        	switch (name) {
            	case "Aged Brie":
            		increaseByItemQuality(1);
            		break;
            	case "Sulfuras":
            		setItemQuality(80);
            		break;
            	case "Backstage passes":
            		updateQualityBackstagePasses();
            		break;
            	case "Conjured":
            		decreaseByItemQuality(2);
            		break;
            	default: 
            		decreaseItemQuality();
        	}
        	
        	// Adjust sellIn
            if (name.equals("Sulfuras")) {
            	setItemSellIn(0);
            } else {
            	decreaseItemSellIn();
            }
        }
    }

    /**
     * Function that updates a Backstage Passes item.
     */	
    private void updateQualityBackstagePasses() {
    	if (items[position].sellIn > 0) {
    		if (items[position].sellIn <= 5) {
    			increaseByItemQuality(3);
        	} else if (items[position].sellIn <= 10) {
        		increaseByItemQuality(2);
        	}
      	} else {
        	setItemQuality(0);
      	}

      	decreaseItemSellIn();
    }

    /**
     * Function that decreases the quality of an item by one except
     * when expired when it will be by two.
     */	    
    private void decreaseItemQuality() {
    	// 
    	if (items[position].sellIn <= 0) {
    		decreaseByItemQuality(2);    		
    	} else {
    		decreaseByItemQuality(1);
    	}
    }  

    /**
     * Function that decreases the quality of an item based on a value
     * but without becoming negative.
     * @param value
     */
    private void decreaseByItemQuality(int value) {
    	if ((items[position].quality - value) >= 0) {
    		items[position].quality = items[position].quality - value;
    	}
    }

    /**
     * Function that increases the quality of an item based on a value
     * up to MAXQUALITY.
     * @param value
     */
    private void increaseByItemQuality(int value) {
    	if ((items[position].quality + value) <= MAXQUALITY) {
            items[position].quality = items[position].quality + value;
        }
    }  

    /**
     * Function that decreases the expiration of an item by one.
     */
    private void decreaseItemSellIn() {
    	items[position].sellIn--;
    } 

}