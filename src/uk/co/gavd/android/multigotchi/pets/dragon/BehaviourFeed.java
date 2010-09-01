package uk.co.gavd.android.multigotchi.pets.dragon;

import uk.co.gavd.android.multigotchi.pets.AttributeNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Behaviour;
import uk.co.gavd.android.multigotchi.pets.Pet;

public class BehaviourFeed extends Behaviour {

	public BehaviourFeed(Pet pet) {
		super(pet);
	}
	
	@Override
	public void execute() throws AttributeNotFoundException {
		this.pet.getAttribute("Food").increment(10);
		this.pet.getAttribute("Fire").decrement(1);
		this.pet.getAttribute("Gold").decrement(5);
		this.pet.getAttribute("Energy").increment(1);
	}

	@Override
	public String getName() {
		return "Feed";
	}

}
