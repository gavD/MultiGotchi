package uk.co.gavd.android.multigotchi.pets.carey;

import uk.co.gavd.android.multigotchi.collections.IMultiKeyCollectable;
import uk.co.gavd.android.multigotchi.collections.ItemNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Behaviour;
import uk.co.gavd.android.multigotchi.pets.Pet;

public class BehaviourDrinkBooze extends Behaviour implements IMultiKeyCollectable {

	/**
	 * Create a behaviour with a reference to a pet
	 * 
	 * @param pet Reference to the pet that this behaviour is for
	 */
	public BehaviourDrinkBooze(Pet pet) {
		super(pet);
	}
	
	@Override
	public void execute() throws ItemNotFoundException {
		this.pet.getAttribute(Carey.ATTRIBUTE_BACON).decrement(1);
		this.pet.getAttribute(Carey.ATTRIBUTE_BOOZE).increment(10);
		this.pet.getAttribute(Carey.ATTRIBUTE_NICOTINE).decrement(1);
		this.pet.getAttribute(Carey.ATTRIBUTE_CALM).increment(10);
	}

	public String getName() {
		return Carey.BEHAVIOUR_DRINKBOOZE;
	}

}
