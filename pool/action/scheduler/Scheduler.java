package action.scheduler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pool.ForeseeableAction;

import action.Action;
import action.ActionFinishedException;

public abstract class Scheduler extends Action {

	protected List<Action> actions;
	protected Iterator<Action> it;
	protected int index;
	protected boolean is_finished;
	
	public Scheduler(int nb){
		
			this.actions = new ArrayList<Action>(nb);
			
			for(int i=0;i<this.actions.size();i++){
				actions.set(i, new ForeseeableAction());
			}
			
			it =actions.listIterator(0);
			index=0;
			is_finished=false;
	}
	
	
	public void setScheduler(int index,Scheduler scheduler){
		this.actions.set(index, scheduler);
	}
	
	public int size(){
		
		return this.actions.size();
			
	}
	public void nextAction(){
		
		if(index<actions.size()){
		index++;		
		this.it = this.actions.listIterator(index);	
		}	
		else{
			is_finished =true;
		}
   }
	public void really_doStep() {
		this.currentAction().really_doStep();		
	}
	public Action currentAction(){
		return this.actions.get(index);
	}
	
	public boolean is_ready(){
		return index==0 && !is_finished;
	}	
	public boolean is_finished(){
		return is_finished;
		
	}
	public boolean is_in_progress(){
		return !is_finished && index>0;		
	}
	
	public abstract void addAction(Action action);
	public abstract void doStep() throws ActionFinishedException;
	
}
