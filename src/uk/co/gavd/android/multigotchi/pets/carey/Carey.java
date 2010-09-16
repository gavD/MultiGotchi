package uk.co.gavd.android.multigotchi.pets.carey;

import uk.co.gavd.android.multigotchi.collections.ItemNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Pet;

/**
 * A type of Pet
 * 
 * @author Gavin Davies
 */
public class Carey extends Pet {
	
	public static final String ATTRIBUTE_BACON = "Bacon";
	public static final String ATTRIBUTE_BOOZE = "Booze";
	public static final String ATTRIBUTE_NICOTINE = "Nicotine";
	public static final String ATTRIBUTE_CALM = "Calm";
	
	public static final String BEHAVIOUR_EATBACON = "Eat Bacon";
	public static final String BEHAVIOUR_DRINKBOOZE = "Drink Booze";
	public static final String BEHAVIOUR_SMOKEFAG = "Smoke Fag";
	public static final String BEHAVIOUR_ATTENDMEETING = "Attend Meeting";
	
	
	@Override
	public String getType() {
		return "Carey";
	}

	@Override
	public void tick() throws ItemNotFoundException {
		this.getAttribute(Carey.ATTRIBUTE_NICOTINE).decrement(2);
		this.getAttribute(Carey.ATTRIBUTE_BOOZE).decrement(3);
		this.getAttribute(Carey.ATTRIBUTE_BACON).decrement(2);
		this.getAttribute(Carey.ATTRIBUTE_CALM).decrement(2);
	}
}
