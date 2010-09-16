package uk.co.gavd.android.multigotchi.pets;

import uk.co.gavd.android.multigotchi.collections.IMultiKeyCollectable;

public class Attribute implements IMultiKeyCollectable {
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 100;
	protected int level = 50;
	protected String name = "";
	private Pet pet;
	
	/**
	 * Initialise an attribute with a name and a reference back to the "owning"
	 * pet
	 * 
	 * @param name 
	 * @param pet Reference back to the pet that "has" this attribute
	 */
	public Attribute(String name, Pet pet) {
		this.name = name;
		this.pet = pet;
	}
	
	/**
	 * Increase the level of an attribute
	 * 
	 * @param amt How much to increment this attribute's level by
	 */
	public void increment(int amt) {
		this.level += amt;
		if(this.level > MAX_VALUE) {
			this.level = MAX_VALUE;
		}
	}

	/**
	 * Decrease the level of an attribute
	 * @param amt How much to decrement this attribute's level by
	 */
	public void decrement(int amt) {
		this.level -= amt;
		if(this.level < MIN_VALUE) {
			this.pet.die();
			this.level = MIN_VALUE;
		}
		
	}
	
	/**
	 * @return Text name for this attribute
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return The current level of this attribute. Must exist
	 * between MIN_LEVEL and MAX_LEVEL
	 */
	public int getLevel() {
		return this.level;
	}
	
	@Override
	public String toString() {
		return this.name
		       + ": " + level
		       + "/" + MAX_VALUE;
	}
}
