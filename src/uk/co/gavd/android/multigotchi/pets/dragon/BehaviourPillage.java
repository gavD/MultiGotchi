package uk.co.gavd.android.multigotchi.pets.dragon;

import uk.co.gavd.android.multigotchi.pets.AttributeNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Behaviour;
import uk.co.gavd.android.multigotchi.pets.Pet;

public class BehaviourPillage extends Behaviour {

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
