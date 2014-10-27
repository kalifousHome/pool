package action;

import pool.Basket;
import pool.Cubicle;
import pool.ForeseeableAction;
import pool.FreeResourceAction;
import pool.Resource;
import pool.ResourcefulUser;
import pool.TakeResourceAction;
import pool.resourcePool.BasketPool;
import pool.resourcePool.CubiclePool;
import action.Action;
import action.scheduler.SequentialScheduler;

public class Swimmer extends Action{
	
	private final SequentialScheduler process;
	private final ResourcefulUser<Resource> basketUser;
	private final ResourcefulUser<Resource> cubicleUser;
	private String name;
	
	
	public Swimmer(String name, BasketPool<Basket> bp, CubiclePool<Cubicle> cbl, int timeToUndress,
			int timeToSwim, int timeToDress) throws Exception{
				
		this.name=name;
	
		basketUser = new ResourcefulUser<Resource>();
		cubicleUser = new ResourcefulUser<Resource>();
		/*Pourquoi faire?? */
		process = new SequentialScheduler(0);
		
		process.addAction ( new TakeResourceAction<Basket>(bp,basketUser) );
		process.addAction ( new TakeResourceAction<Cubicle>( cbl,cubicleUser) );
		process.addAction ( new ForeseeableAction(timeToUndress) );
		process.addAction ( new ForeseeableAction(timeToSwim) );
		process.addAction ( new ForeseeableAction(timeToDress) );
		process.addAction ( new FreeResourceAction<Basket>(bp,basketUser) );
		process.addAction ( new FreeResourceAction<Cubicle>(cbl,cubicleUser) );
	
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
