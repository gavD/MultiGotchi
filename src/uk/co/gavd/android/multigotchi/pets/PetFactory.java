package uk.co.gavd.android.multigotchi.pets;

import uk.co.gavd.android.multigotchi.pets.dragon.BehaviourFeed;
import uk.co.gavd.android.multigotchi.pets.dragon.BehaviourHunt;
import uk.co.gavd.android.multigotchi.pets.dragon.BehaviourPillage;
import uk.co.gavd.android.multigotchi.pets.dragon.BehaviourSleep;
import uk.co.gavd.android.multigotchi.pets.dragon.Dragon;

public class PetFactory {
	public static Pet getDragon() {
    	Pet model = new Dragon();
    	
    	// attributes
    	model.setAttributes(
    		new Attribute("Food"),
    		new Attribute("Fire"),
    		new Attribute("Gold"),
    		new Attribute("Energy")
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
