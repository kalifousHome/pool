package action;

import pool.ForeseeableAction;
import junit.framework.TestCase;

public class ActionFinishedExceptionTest extends TestCase {

	
	public void status() {
		
		Action action= (new ForeseeableAction()).createAction();
		assertTrue(action.is_ready());
		assertFalse(action.is_in_progress());
		assertFalse(action.is_finished());
		
		while(!action.is_finished()){

			try{
				action.doStep();	 
				assertFalse(action.is_ready());
				assertTrue(action.is_in_progress() != action.is_finished());
				
			}
			catch(ActionFinishedException e){
				fail("action was not supposed to be finished");
				
			}
			
			
		}

	}
}
