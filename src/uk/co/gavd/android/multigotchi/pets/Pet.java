package uk.co.gavd.android.multigotchi.pets;

import uk.co.gavd.android.multigotchi.collections.ItemNotFoundException;
import uk.co.gavd.android.multigotchi.collections.MultiKeyedCollection;

/**
 * Base class for all Pets
 * 
 * Has 4 attributes and 4 behaviours, and methods for accessing
 * those.
 * 
 * @author Gavin Davies
 */
public abstract class Pet {
	public abstract String getType();
	public abstract void tick() throws ItemNotFoundException;
	
	private MultiKeyedCollection<Attribute> attributeCollection;
	private MultiKeyedCollection<Behaviour> behaviourCollection;
	
	protected boolean dead = false;
	
	public void init(MultiKeyedCollection<Attribute> attributes,
			MultiKeyedCollection<Behaviour> behaviours)
	{
		this.attributeCollection = attributes;
		this.behaviourCollection = behaviours;
	}
	
	/**
	 * Go through the attributes this pet has and try
	 * to find one that is named [attributeName]
	 * 
	 * @param attributeName The name the attribute has
	 * @return The attribute that has name [attributeName]
	 * @throws AttributeNotFoundException If there is no
	 * attribute that has name [attributeName]
	 */
	public Attribute getAttribute(String attributeName) throws ItemNotFoundException
	{
		return (Attribute)this.attributeCollection.findByName(attributeName);
	}
	
	public Attribute getAttribute(int index) throws ItemNotFoundException {
		return (Attribute)this.attributeCollection.findByIndex(index);
	}
	
	public Behaviour getBehaviour(String name) throws ItemNotFoundException
	{
		return (Behaviour)this.behaviourCollection.findByName(name);
	}
	
	public Behaviour getBehaviour(int index) throws ItemNotFoundException
	{
		return (Behaviour)this.behaviourCollection.findByIndex(index);
	}

	/**
	 * Execute operation with name operationName
	 * @param operationName
	 * @throws ItemNotFoundException
	 * @throws AttributeNotFoundException
	 */
	public void operation(String operationName) throws ItemNotFoundException {
		getBehaviour(operationName).execute();
	}
	
	/**
	 * Run an operation at index operationIndex
	 * @param operationIndex
	 * @throws ItemNotFoundException
	 * @throws AttributeNotFoundException
	 */
	public void operation(int operationIndex) throws ItemNotFoundException {
		getBehaviour(operationIndex).execute();
	}
	
	/**
	 * Kill off this pet
	 */
	public void die() {
		this.dead = true;
	}
	
	/**
	 * @return Whether this pet has died, generally because an
	 * attribute has gone below the minimum threshold
	 */
	public boolean isDead() {
		return this.dead;
	}
	
	@Override
	public String toString() {
		return getType() + "\n"
			 + attributeCollection.toString();
	}
	
}
