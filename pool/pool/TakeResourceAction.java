package pool;

import pool.resourcePool.ResourcePool;

public class TakeResourceAction<R extends Resource> extends ResourcePoolAction<Resource>  {
	
	public TakeResourceAction( ResourcePool<Resource> resourcePool ,ResourcefulUser<Resource> user){
			
			super(resourcePool,user);
			if(this.pool.hasAvailableResource())
					this.addResource(this.pool.provideResource());
	}
	
	public void addResource(Resource resource){
		this.doStep();
		this.user.setResource(resource);
		
	}
	@Override
	public void doStep() {
		
	}
	
}
