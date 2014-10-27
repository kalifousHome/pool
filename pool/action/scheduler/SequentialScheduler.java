package action.scheduler;
import action.Action;
import action.ActionFinishedException;

public class SequentialScheduler extends Scheduler {
	
	public SequentialScheduler(int size){
			super(size);
		}

	@Override
	public void doStep()throws ActionFinishedException{
		
		if(this.is_finished())
			throw new ActionFinishedException();
		if(!(this.currentAction()).is_finished())
			this.currentAction().really_doStep();
		else  
			this.nextAction();
					
	}
	
	@Override
	protected Action createAction() {
		
		return null;
	}

	@Override
	public void addAction(Action action) {
		this.actions.add(action);		
		
	}
	
}
