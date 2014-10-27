package action.scheduler;

import action.Action;

public class FairScheduler extends Scheduler{
	
	public FairScheduler(int nb) {
		super(nb);
	}

	
	
	public void doStep() {
		while (!currentAction().is_finished()){
			while (this.it.hasNext()){
				doStep();
				nextAction();
			}
		}
		
	}

	
	public void addAction(Action action) {
		// TODO Auto-generated method stub
		
	}

	protected Action createAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
