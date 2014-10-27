package pool;

import pool.resourcePool.ResourcePool;

public abstract class TakeResourceAction<R extends Resource> extends ResourcePoolAction<Resource>  {
	
	public ResourcefulUser<Resource> handler;

	public TakeResourceAction( ResourcePool<Resource> resourcePool ,ResourcefulUser<Resource> user){
				super(resourcePool,user);
	}
	
	public void addResource(Resource R){
		this.doStep();
		handler.setResource(R);
		
	}

	private void doStep() {
		
	}
	
}
