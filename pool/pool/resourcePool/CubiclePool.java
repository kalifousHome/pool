package pool.resourcePool;

import pool.Resource;

public class CubiclePool<Basket> extends ResourcePool<Resource>{
	
	public CubiclePool(int numberOfResource){
		super(numberOfResource);
	}
	@Override
	public Resource createResource() {
		return new pool.Cubicle();
	}
	

}
