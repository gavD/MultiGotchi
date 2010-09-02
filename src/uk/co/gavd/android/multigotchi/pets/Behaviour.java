package uk.co.gavd.android.multigotchi.pets;

/**
 * A "Behaviour" is something you can do to a pet. It has an execute
 * method that operates upon the pet.
 * 
 * @author Gavin Davies
 */
public abstract class Behaviour {
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
	 * @return The name of this behaviour. May be something like "feed"
	 * or "wash"
	 */
	public abstract String getName();
	
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
	public abstract void execute() throws AttributeNotFoundException;
}
