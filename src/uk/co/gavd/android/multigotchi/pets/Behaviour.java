package uk.co.gavd.android.multigotchi.pets;

import uk.co.gavd.android.multigotchi.collections.IMultiKeyCollectable;
import uk.co.gavd.android.multigotchi.collections.ItemNotFoundException;

/**
 * A "Behaviour" is something you can do to a pet. It has an execute
 * method that operates upon the pet.
 * 
 * @author Gavin Davies
 */
public abstract class Behaviour implements IMultiKeyCollectable {
	protected Pet pet;
	protected String name;
	
	/**
	 * Create a behaviour with a reference to a pet
	 * 
	 * @param pet Reference to the pet that this behaviour is for
	 */
	public Behaviour(Pet pet) {
		this.pet = pet;
	}
	
	/**
	 * Execute this behaviour against the linked pet.
	 * 
	 * Look up some attributes on the Pet this Behaviour is linked to, and
	 * increment or decrement them
	 * 
	 * @throws AttributeNotFoundException If this behaviour refers to an
	 * attribute that the Pet this Behaviour is linked to, this exception
	 * is thrown
	 */
	public abstract void execute() throws ItemNotFoundException;
}
