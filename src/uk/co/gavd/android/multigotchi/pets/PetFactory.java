package uk.co.gavd.android.multigotchi.pets;

import uk.co.gavd.android.multigotchi.collections.MultiKeyedCollection;
import uk.co.gavd.android.multigotchi.pets.dragon.*;
import uk.co.gavd.android.multigotchi.pets.carey.*;

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
	 * Create a Carey pet
	 * @return new Carey set up with attributes including smoking,
	 * booze, caffeine and bacon
	 */
	public static Pet getCarey() {
    	
		Pet model = new Carey();
		
    	MultiKeyedCollection<Attribute> attributes = new MultiKeyedCollection<Attribute>();
    	
    	attributes.setCollection(
    	    new Attribute(Carey.ATTRIBUTE_BACON, model),
    		new Attribute(Carey.ATTRIBUTE_BOOZE, model),
    		new Attribute(Carey.ATTRIBUTE_NICOTINE, model),
    	    new Attribute(Carey.ATTRIBUTE_CALM, model)
    	);

    	MultiKeyedCollection<Behaviour> behaviours = new MultiKeyedCollection<Behaviour>();
	   	behaviours.setCollection(
    		new BehaviourEatBacon(model),
    		new BehaviourDrinkBooze(model),
    		new BehaviourSmoke(model),
    		new BehaviourAttendMeeting(model)

	   	);
	   	
	   	model.init(attributes, behaviours);
    	
    	return model;
	}
	/**
	 * Create a Dragon pet
	 * @return new Dragon set up with attributes including food, fire,
	 * gold and energy and behaviours including feeding, hunting, sleeping
	 * and pillaging
	 */
	public static Pet getDragon() {
    	
		Pet model = new Dragon();
		
    	MultiKeyedCollection<Attribute> attributes = new MultiKeyedCollection<Attribute>();
    	
    	attributes.setCollection(
    	    new Attribute(Dragon.ATTRIBUTE_FOOD, model),
    		new Attribute(Dragon.ATTRIBUTE_FIRE, model),
    		new Attribute(Dragon.ATTRIBUTE_GOLD, model),
    		new Attribute(Dragon.ATTRIBUTE_ENERGY, model)
    	);

    	MultiKeyedCollection<Behaviour> behaviours = new MultiKeyedCollection<Behaviour>();
	   	behaviours.setCollection(
    		new BehaviourFeed(model),
    		new BehaviourHunt(model),
    		new BehaviourSleep(model),
    		new BehaviourPillage(model)

	   	);
	   	
	   	model.init(attributes, behaviours);
    	
    	return model;
	}
}
