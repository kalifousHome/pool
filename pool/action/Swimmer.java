package action;

import pool.Basket;
import pool.Cubicle;
import pool.ForeseeableAction;
import pool.FreeResourceAction;
import pool.ResourcefulUser;
import pool.TakeResourceAction;
import pool.resourcePool.BasketPool;
import pool.resourcePool.CubiclePool;
import action.Action;
import action.scheduler.SequentialScheduler;

public class Swimmer extends Action{
	
	protected final SequentialScheduler process;
	protected final ResourcefulUser<Basket> basketUser;
	protected final ResourcefulUser<Cubicle> cubicleUser;
	
	public Swimmer(String name, BasketPool<Basket> bp, CubiclePool<Cubicle> cbl, int timeToUndress,
			int timeToSwim, int timeToDress){
	
		basketUser = new ResourcefulUser<Basket>();
		cubicleUser = new ResourcefulUser<Cubicle>();
		process = new SequentialScheduler(0);
		
		Process.addAction ( new TakeResourceAction(bp,basketUser) );
		Process.addAction ( new TakeResourceAction( cbl,cubicleUser) );
		Process.addAction ( new ForeseeableAction(timeToUndress) );
		Process.addAction ( new ForeseeableAction(timeToSwim) );
		Process.addAction ( new ForeseeableAction(timeToDress) );
		Process.addAction ( new FreeResourceAction(bp,basketUser) );
		Process.addAction ( new FreeResourceAction(cbl,cubicleUser) );
	
	}
	@Override
	public boolean is_ready() {
			return process.is_ready();
	}

	@Override
	public boolean is_finished() {
		return process.is_finished();
	}

	@Override
	public void really_doStep() {
		process.really_doStep();		
	}

	@Override
	protected Action createAction() {
		return null;
	}

}
