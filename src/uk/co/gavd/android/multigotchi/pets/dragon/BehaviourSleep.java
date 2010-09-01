package uk.co.gavd.android.multigotchi.pets.dragon;

import uk.co.gavd.android.multigotchi.pets.AttributeNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Behaviour;
import uk.co.gavd.android.multigotchi.pets.Pet;

public class BehaviourSleep extends Behaviour {

	public BehaviourSleep(Pet pet) {
		super(pet);
	}

	@Override
	public void execute() throws AttributeNotFoundException {
		this.pet.getAttribute("Food").decrement(5);
		this.pet.getAttribute("Fire").increment(10);
		this.pet.getAttribute("Energy").increment(20);
	}

	@Override
	public String getName() {
		return "Sleep";
	}
}
