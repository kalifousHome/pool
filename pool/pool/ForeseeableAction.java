package pool;

import action.Action;


public class ForeseeableAction extends Action{
	
	private final int totalTme;
	private int remainTime;
	
	public ForeseeableAction(int tot) throws Exception {
		
		if(tot <=0)
			throw new IllegalArgumentException();
		
		this.totalTme=tot;
		this.remainTime=tot;
		
	}
	//??
	public ForeseeableAction(){
		this.totalTme=10;
		this.remainTime=10;
	}
	
	public boolean is_ready(){
		return totalTme==remainTime;
	}
	
	public boolean is_finished(){
		return remainTime==0;
	}
	
	public void really_doStep(){
		this.remainTime--;
		
	}
	//??
	public Action createAction()  {
				
			return new ForeseeableAction();

	}

	
}
