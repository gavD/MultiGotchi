package uk.co.gavd.android.multigotchi.pets;

public class Attribute {
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 100;
	protected int level = 50;
	protected String name = "";
	
	public Attribute(String name) {
		this.name = name;
	}
	
	public void increment(int amt) {
		this.level += amt;
	}
	public void decrement(int amt) {
		this.level -= amt;
	}
	
	public String getName() {
		return this.name;
	}
	
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
