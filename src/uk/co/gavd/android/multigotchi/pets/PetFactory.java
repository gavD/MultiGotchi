package uk.co.gavd.android.multigotchi.pets;

import uk.co.gavd.android.multigotchi.pets.dragon.BehaviourFeed;
import uk.co.gavd.android.multigotchi.pets.dragon.BehaviourHunt;
import uk.co.gavd.android.multigotchi.pets.dragon.BehaviourPillage;
import uk.co.gavd.android.multigotchi.pets.dragon.BehaviourSleep;
import uk.co.gavd.android.multigotchi.pets.dragon.Dragon;

/**
 * Factory for creating various types of Pet. All configuration and
 * assignment of attributes are done here, rather than in the Pet
 * subclasses themselves so that different varieties of pets can
 * be created.
 * 
 * @author Gavin Davies
 */
public class PetFactory {
	
	/**
	 * Create a Dragon pet
	 * @return new Dragon set up with attributes including food, fire,
	 * gold and energy and behaviours including feeding, hunting, sleeping
	 * and pillaging
	 */
	public static Pet getDragon() {
    	Pet model = new Dragon();
    	
    	// attributes
    	model.setAttributes(
    		new Attribute("Food", model),
    		new Attribute("Fire", model),
    		new Attribute("Gold", model),
    		new Attribute("Energy", model)
    	);
    	
    	model.setBehaviours(
    		new BehaviourFeed(model),
    		new BehaviourHunt(model),
    		new BehaviourSleep(model),
    		new BehaviourPillage(model)
    	);
    	
    	return model;
	}
}
