package uk.co.gavd.android.multigotchi.pets.dragon;

import uk.co.gavd.android.multigotchi.collections.ItemNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Pet;

/**
 * A type of Pet
 * 
 * @author Gavin Davies
 */
public class Dragon extends Pet {
	
	// it's a good idea to include all the attributes as constants
	// so they can easily be referenced/changed
	public static final String ATTRIBUTE_FOOD = "Food";
	public static final String ATTRIBUTE_FIRE = "Fire";
	public static final String ATTRIBUTE_GOLD = "Gold";
	public static final String ATTRIBUTE_ENERGY = "Energy";
	
	public static final String BEHAVIOUR_FEED = "Feed";
	public static final String BEHAVIOUR_HUNT = "Hunt";
	public static final String BEHAVIOUR_SLEEP = "Sleep";
	public static final String BEHAVIOUR_PILLAGE = "Pillage";
	
	@Override
	public String getType() {
		return "Dragon";
	}

	@Override
	public void tick() throws ItemNotFoundException {
		this.getAttribute("Food").decrement(2);
		this.getAttribute("Fire").decrement(1);
		this.getAttribute("Energy").decrement(2);
	}
}
