package uk.co.gavd.android.multigotchi.pets.dragon;

import uk.co.gavd.android.multigotchi.pets.AttributeNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Behaviour;
import uk.co.gavd.android.multigotchi.pets.Pet;

/**
 * Behaviour for a dragon that feeds it a little but costs flame
 * and energy
 * 
 * @author Gavin Davies
 */
public class BehaviourHunt extends Behaviour {

	/**
	 * Create a behaviour with a reference to a pet
	 * 
	 * @param pet Reference to the pet that this behaviour is for
	 */
	public BehaviourHunt(Pet pet) {
		super(pet);
	}
	
	@Override
	public void execute() throws AttributeNotFoundException {
		this.pet.getAttribute("Food").increment(5);
		this.pet.getAttribute("Fire").decrement(10);
		this.pet.getAttribute("Energy").decrement(10);
	}

	@Override
	public String getName() {
		return "Hunt";
	}
}
