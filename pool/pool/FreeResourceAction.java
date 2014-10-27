package pool;

import pool.resourcePool.ResourcePool;

public class FreeResourceAction<R extends Resource> extends ResourcePoolAction<Resource>{

	
	public FreeResourceAction(ResourcePool<Resource> pool,ResourcefulUser<Resource> user) {
		super(pool, user);
		this.freeResource(user.getResource());
	}
	public void freeResource(Resource resource){
		this.doStep();
		this.pool.freeResource(resource);			
		this.user.resetResource();
		
	}
	@Override
	public void doStep() {
		this.really_doStep();
	}
}
