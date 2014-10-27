package action.scheduler;

import action.Action;

public class FairScheduler extends Scheduler{
	
	public FairScheduler(int nb) {
		super(nb);
	}

	
	@Override
	public void doStep() {
		while (!currentAction().is_finished()){
			while (this.it.hasNext()){
				doStep();
				nextAction();
			}
		}
		
	}

	@Override
	public void addAction(Action action) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected Action createAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
