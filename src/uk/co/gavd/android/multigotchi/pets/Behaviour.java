package uk.co.gavd.android.multigotchi.pets;

public abstract class Behaviour {
	protected Pet pet;
	protected String name;
	
	public Behaviour(Pet pet) {
		this.pet = pet;
	}
	
	public abstract String getName();
	
	public abstract void execute() throws AttributeNotFoundException;
}
