package uk.co.gavd.android.multigotchi.pets.dragon;

import uk.co.gavd.android.multigotchi.pets.AttributeNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Behaviour;
import uk.co.gavd.android.multigotchi.pets.Pet;

/**
 * Rest behaviour for a dragon, makes it hungry but stokes
 * its fires and gives it energy
 * 
 * @author Gavin Davies
 */
public class BehaviourSleep extends Behaviour {

	/**
	 * Create a behaviour with a reference to a pet
	 * 
	 * @param pet Reference to the pet that this behaviour is for
	 */
	public BehaviourSleep(Pet pet) {
		super(pet);
	}

	@Override
	public void execute() throws AttributeNotFoundException {
		this.pet.getAttribute("Food").decrement(7);
		this.pet.getAttribute("Fire").increment(10);
		this.pet.getAttribute("Energy").increment(20);
	}

	@Override
	public String getName() {
		return "Sleep";
	}
}
