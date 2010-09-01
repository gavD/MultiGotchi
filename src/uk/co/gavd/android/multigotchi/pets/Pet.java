package uk.co.gavd.android.multigotchi.pets;


public abstract class Pet {
	public abstract String getType();
	public abstract String getGoal();

	protected Attribute attribute1;
	protected Attribute attribute2;
	protected Attribute attribute3;
	protected Attribute attribute4;
	
	protected Behaviour behaviour1;
	protected Behaviour behaviour2;
	protected Behaviour behaviour3;
	protected Behaviour behaviour4;
	
	public void setAttributes(Attribute attribute1,
			Attribute attribute2,
			Attribute attribute3,
			Attribute attribute4)
	{
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.attribute4 = attribute4;
	}
	
	public void setBehaviours(Behaviour theBehaviour1,
			Behaviour theBehaviour2,
			Behaviour theBehaviour3,
			Behaviour theBehaviour4)
	{
		this.behaviour1 = theBehaviour1;
		this.behaviour2 = theBehaviour2;
		this.behaviour3 = theBehaviour3;
		this.behaviour4 = theBehaviour4;		
	}
	
	public Attribute getAttribute(String attributeName)
	throws AttributeNotFoundException
	{
		if(attributeName.equals(attribute1.getName())) {
			return attribute1;
		}
		if(attributeName.equals(attribute2.getName())) {
			return attribute2;
		}
		if(attributeName.equals(attribute3.getName())) {
			return attribute3;
		}
		if(attributeName.equals(attribute4.getName())) {
			return attribute4;
		}
		throw new AttributeNotFoundException("Cannot find attribute " + attributeName
				+ "; available attributes " + this.listAvailableAttributes());
	}
	
	private String listAvailableAttributes() {
		return attribute1.getName() + ", " + 
			attribute2.getName() + ", " + 
			attribute3.getName() + ", " + 
			attribute4.getName();
	}
	
	public Attribute getAttribute(int index) throws AttributeNotFoundException {
		switch (index) {
		case 1: return attribute1;
		case 2: return attribute2;
		case 3: return attribute3;
		case 4: return attribute4;
		default: throw new AttributeNotFoundException("Cannot find attribute at index " + index
				+ "; available attributes " + this.listAvailableAttributes());
		}
	}
	
	public Behaviour getBehaviour(String behaviourName) throws BehaviourNotFoundException
	{
		if(behaviourName.equals(behaviour1.getName())) {
			return behaviour1;
		}
		if(behaviourName.equals(behaviour2.getName())) {
			return behaviour2;
		}
		if(behaviourName.equals(behaviour3.getName())) {
			return behaviour3;
		}
		if(behaviourName.equals(behaviour4.getName())) {
			return behaviour4;
		}
		
		throw new BehaviourNotFoundException("Cannot find behaviour " + behaviourName);
	}
	
	public Behaviour getBehaviour(int index) throws BehaviourNotFoundException {
		switch (index) {
		case 1: return behaviour1;
		case 2: return behaviour2;
		case 3: return behaviour3;
		case 4: return behaviour4;
		default: throw new BehaviourNotFoundException("Cannot find behaviour at index " + index);
		}
	}
	
	public void operation(String operationName) throws BehaviourNotFoundException, AttributeNotFoundException {
		getBehaviour(operationName).execute();
	}
	public void operation(int operationIndex) throws BehaviourNotFoundException, AttributeNotFoundException {
		getBehaviour(operationIndex).execute();
	}
	
	public abstract void tick() throws AttributeNotFoundException;

	@Override
	public String toString() {
		return attribute1.toString() + "\n"
			 + attribute2.toString() + "\n"
			 + attribute3.toString() + "\n"
			 + attribute4.toString() + "\n";
	}
}
