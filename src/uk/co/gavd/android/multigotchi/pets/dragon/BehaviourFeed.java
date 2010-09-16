package uk.co.gavd.android.multigotchi.pets.dragon;

import uk.co.gavd.android.multigotchi.collections.IMultiKeyCollectable;
import uk.co.gavd.android.multigotchi.collections.ItemNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Behaviour;
import uk.co.gavd.android.multigotchi.pets.Pet;

/**
 * Behaviour for a dragon that feeds it and stokes its flames.
 * It does, however, cost gold.
 * 
 * @author Gavin Davies
 */
public class BehaviourFeed extends Behaviour implements IMultiKeyCollectable {

	/**
	 * Create a behaviour with a reference to a pet
	 * 
	 * @param pet Reference to the pet that this behaviour is for
	 */
	public BehaviourFeed(Pet pet) {
		super(pet);
	}
	
	@Override
	public void execute() throws ItemNotFoundException {
		this.pet.getAttribute(Dragon.ATTRIBUTE_FOOD).increment(10);
		this.pet.getAttribute(Dragon.ATTRIBUTE_FIRE).increment(3);
		this.pet.getAttribute(Dragon.ATTRIBUTE_GOLD).decrement(15);
		this.pet.getAttribute(Dragon.ATTRIBUTE_ENERGY).increment(1);
	}

	public String getName() {
		return "Feed";
	}

}
