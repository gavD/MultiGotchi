package uk.co.gavd.android.multigotchi.pets.dragon;

import uk.co.gavd.android.multigotchi.collections.IMultiKeyCollectable;
import uk.co.gavd.android.multigotchi.collections.ItemNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Behaviour;
import uk.co.gavd.android.multigotchi.pets.Pet;

/**
 * Rest behaviour for a dragon, makes it hungry but stokes
 * its fires and gives it energy
 * 
 * @author Gavin Davies
 */
public class BehaviourSleep extends Behaviour implements IMultiKeyCollectable {

	/**
	 * Create a behaviour with a reference to a pet
	 * 
	 * @param pet Reference to the pet that this behaviour is for
	 */
	public BehaviourSleep(Pet pet) {
		super(pet);
	}

	@Override
	public void execute() throws ItemNotFoundException {
		this.pet.getAttribute(Dragon.ATTRIBUTE_FOOD).decrement(7);
		this.pet.getAttribute(Dragon.ATTRIBUTE_FIRE).increment(10);
		this.pet.getAttribute(Dragon.ATTRIBUTE_ENERGY).increment(20);
	}

	public String getName() {
		return "Sleep";
	}
}
