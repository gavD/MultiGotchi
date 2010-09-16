package uk.co.gavd.android.multigotchi.pets.carey;

import uk.co.gavd.android.multigotchi.collections.IMultiKeyCollectable;
import uk.co.gavd.android.multigotchi.collections.ItemNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Behaviour;
import uk.co.gavd.android.multigotchi.pets.Pet;

public class BehaviourAttendMeeting extends Behaviour implements IMultiKeyCollectable {

	/**
	 * Create a behaviour with a reference to a pet
	 * 
	 * @param pet Reference to the pet that this behaviour is for
	 */
	public BehaviourAttendMeeting(Pet pet) {
		super(pet);
	}
	
	@Override
	public void execute() throws ItemNotFoundException {
		this.pet.getAttribute(Carey.ATTRIBUTE_BACON).decrement(2);
		this.pet.getAttribute(Carey.ATTRIBUTE_BOOZE).decrement(5);
		this.pet.getAttribute(Carey.ATTRIBUTE_NICOTINE).decrement(3);
		this.pet.getAttribute(Carey.ATTRIBUTE_CALM).decrement(15);
	}

	public String getName() {
		return Carey.BEHAVIOUR_ATTENDMEETING;
	}

}
