package pool;

import action.ActionFinishedException;
import pool.resourcePool.ResourcePool;

public class FreeResourceAction<R extends Resource> extends ResourcePoolAction<Resource>{

	

	public ResourcefulUser<Resource> handler;
	
	public FreeResourceAction(ResourcePool<Resource> pool,ResourcefulUser<Resource> user) {
		super(pool, user);
	}
	public void addResouce(Resource R){
		try {
			this.doStep();
		} catch (ActionFinishedException e) {
			e.printStackTrace();
		}
		handler.resetResource();
		
	}

}
