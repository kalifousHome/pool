package action;

public abstract class Action {

	public abstract boolean is_ready();
	
	public abstract boolean is_finished();	
	
	public boolean is_in_progress(){
		return !this.is_finished() && !this.is_finished();
	}
		

	@SuppressWarnings("unused")
	private void doStep() {
				really_doStep();
		
	}
	public abstract void really_doStep();
	
	protected abstract Action createAction();
		
}
