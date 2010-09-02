package uk.co.gavd.android.multigotchi.pets.dragon;

import uk.co.gavd.android.multigotchi.pets.AttributeNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Behaviour;
import uk.co.gavd.android.multigotchi.pets.Pet;

/**
 * Behaviour for a dragon that feeds it and stokes its flames.
 * It does, however, cost gold.
 * 
 * @author Gavin Davies
 */
public class BehaviourFeed extends Behaviour {

	/**
	 * Create a behaviour with a reference to a pet
	 * 
	 * @param pet Reference to the pet that this behaviour is for
	 */
	public BehaviourFeed(Pet pet) {
		super(pet);
	}
	
	@Override
	public void execute() throws AttributeNotFoundException {
		this.pet.getAttribute("Food").increment(10);
		this.pet.getAttribute("Fire").increment(3);
		this.pet.getAttribute("Gold").decrement(15);
		this.pet.getAttribute("Energy").increment(1);
	}

	@Override
	public String getName() {
		return "Feed";
	}

}
