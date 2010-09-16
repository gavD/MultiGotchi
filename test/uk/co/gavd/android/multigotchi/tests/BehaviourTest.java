package uk.co.gavd.android.multigotchi.tests;

import junit.framework.TestCase;
import uk.co.gavd.android.multigotchi.collections.ItemNotFoundException;
import uk.co.gavd.android.multigotchi.pets.*;

public class BehaviourTest extends TestCase {
	private Pet model;
	
	public void setUp() throws Exception {
		super.setUp();
    	this.model = PetFactory.getDragon();		
	}
	
	public void testBehaviour() throws ItemNotFoundException {
    	assertEquals(50, model.getAttribute("Food").getLevel());
    	assertFalse(model.isDead());
    	model.operation("Feed");
    	assertFalse(model.isDead());
    	assertEquals(60, model.getAttribute("Food").getLevel());
    	
    	model.tick();
    	assertEquals(58, model.getAttribute("Food").getLevel());
    	model.tick();
    	assertEquals(56, model.getAttribute("Food").getLevel());
    	
    	assertEquals("Pillage", model.getBehaviour(4).getName());
    	assertFalse(model.isDead());
	}
	
	public void testCannotExceedMaxLevelForAttributes() throws ItemNotFoundException, ItemNotFoundException {	
		// spam all the buttons
		for (int i = 1; i <= 4; i++) {
			for(int j = 0; j < 10; j++) {
				model.getBehaviour(i).execute();
			}
		}
		
		// now check the attributes haven't exceeded max
		for (int i = 1; i <= 4; i++) {
			int currentLevel= model.getAttribute(i).getLevel();
			assertFalse(currentLevel > Attribute.MAX_VALUE);
		}
	}
	
	public void testCannotDropBelowMinLevelForAttributes() throws ItemNotFoundException, ItemNotFoundException {	
		assertFalse(model.isDead());
		
		// spam all the buttons
		for (int i = 0; i <= Attribute.MAX_VALUE; i++) {
			model.tick();
		}
		
		// now check the attributes haven't exceeded max
		for (int i = 1; i <= 4; i++) {
			int currentLevel= model.getAttribute(i).getLevel();
			assertFalse(currentLevel < Attribute.MIN_VALUE);
		}
		assertTrue(model.isDead());
	}
	
	public void testAllBehavioursWorkWithoutMissingAttributeExceptions() throws ItemNotFoundException {
		model.operation(1);
		model.operation(2);
		model.operation(3);
		model.operation(4);
	}
	
	public void testPetNumericAndStringAttributeAccessorsAreEquivalent() throws ItemNotFoundException {
    	assertSame(model.getAttribute("Food"), model.getAttribute(1));
	}
	
	public void testPetNumericAndStringBehaviourAccessorsAreEquivalent() throws ItemNotFoundException {
    	assertSame(model.getBehaviour("Feed"), model.getBehaviour(1));
	}
}
