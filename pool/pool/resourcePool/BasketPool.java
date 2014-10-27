package pool.resourcePool;

import pool.Resource;

public class BasketPool<Basket> extends ResourcePool<Resource>{
	
	public BasketPool(int numberOfResource){
		super(numberOfResource);
	}
	@Override
	public Resource createResource() {
		return new pool.Basket();
	}
	

}
