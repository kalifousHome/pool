package pool.resourcePool;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import pool.Resource;

public abstract class ResourcePool<R extends Resource>{

	protected ArrayList<R> available;
	protected ArrayList<R> inUse;
	
		
	public ResourcePool(int numberOfResources) {
		
		this.available= new ArrayList<R>(numberOfResources);
		this.inUse= new ArrayList<R>(numberOfResources);
		
		for(int i=0; i<numberOfResources;i++)
			available.add(createResource());
	}
	
	public R provideResource(){
		
			if(!hasAvailableResource())
				throw new NoSuchElementException();
			
			R resource = available.get(0);
			inUse.add(resource);
			available.remove(0);
			
			return resource;	
	}	
	public void freeResource(R resource){
		
		int index=inUse.indexOf(resource);
		
		if(index ==-1)
			throw new IllegalArgumentException("Resource"+resource+"was not part of this pool");
	
		inUse.get(index);
		available.add(resource);
		
	}
	public boolean hasAvailableResource() {
		return !available.isEmpty();
	}
	public abstract R createResource();	
	
	public static ResourcePool<Resource> createPool(int i){
		return null;
		
	}
	
}
