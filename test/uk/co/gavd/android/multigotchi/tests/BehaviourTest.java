package uk.co.gavd.android.multigotchi.tests;

import junit.framework.TestCase;
import uk.co.gavd.android.multigotchi.pets.*;

public class BehaviourTest extends TestCase {
	private Pet model;
	
	public void setUp() throws Exception {
		super.setUp();
    	this.model = PetFactory.getDragon();		
	}
	
	public void testBehaviour() throws AttributeNotFoundException, BehaviourNotFoundException {
    	assertEquals(50, model.getAttribute("Food").getLevel());
    	
    	model.operation("Feed");
    	assertEquals(60, model.getAttribute("Food").getLevel());
    	
    	model.tick();
    	assertEquals(58, model.getAttribute("Food").getLevel());
    	model.tick();
    	assertEquals(56, model.getAttribute("Food").getLevel());
    	
    	assertEquals("Pillage", model.getBehaviour(4).getName());
	}
	
	public void testAllBehavioursWorkWithoutMissingAttributeExceptions() throws AttributeNotFoundException, BehaviourNotFoundException {
		model.operation(1);
		model.operation(2);
		model.operation(3);
		model.operation(4);
	}
	
	public void testPetNumericAndStringAttributeAccessorsAreEquivalent() throws AttributeNotFoundException {
    	assertSame(model.getAttribute("Food"), model.getAttribute(1));
	}
	
	public void testPetNumericAndStringBehaviourAccessorsAreEquivalent() throws AttributeNotFoundException, BehaviourNotFoundException {
    	assertSame(model.getBehaviour("Feed"), model.getBehaviour(1));
	}
}
