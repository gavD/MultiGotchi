package uk.co.gavd.android.multigotchi.pets.dragon;

import uk.co.gavd.android.multigotchi.pets.AttributeNotFoundException;
import uk.co.gavd.android.multigotchi.pets.Pet;

/**
 * A type of Pet
 * 
 * @author Gavin Davies
 */
public class Dragon extends Pet {
	@Override
	public String getType() {
		return "Dragon";
	}

	@Override
	public void tick() throws AttributeNotFoundException {
		this.getAttribute("Food").decrement(2);
		this.getAttribute("Fire").decrement(1);
		this.getAttribute("Energy").decrement(2);
	}
}
