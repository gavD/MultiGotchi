package uk.co.gavd.android.multigotchi.pets.dragon;

import uk.co.gavd.android.multigotchi.pets.AttributeNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Behaviour;
import uk.co.gavd.android.multigotchi.pets.Pet;

/**
 * Behaviour for a dragon that uses fire and energy to gather gold
 * 
 * @author Gavin Davies
 */
public class BehaviourPillage extends Behaviour {

	/**
	 * Create a behaviour with a reference to a pet
	 * 
	 * @param pet Reference to the pet that this behaviour is for
	 */
	public BehaviourPillage(Pet pet) {
		super(pet);
	}

	@Override
	public void execute() throws AttributeNotFoundException {
		this.pet.getAttribute("Fire").decrement(10);
		this.pet.getAttribute("Gold").increment(10);
		this.pet.getAttribute("Energy").decrement(10);
	}

	@Override
	public String getName() {
		return "Pillage";
	}
}
