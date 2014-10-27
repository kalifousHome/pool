package pool.resourcePool;

import java.util.NoSuchElementException;
import org.junit.Test;
import junit.framework.TestCase;
import pool.Resource;

public class ResourceTest extends TestCase{

	@Test(expected = NoSuchElementException.class)
	
	public void cannotTakeResourceFromEmptyPool(){
		
		ResourcePool<Resource> pool = ResourcePool.createPool(1);
		pool.provideResource();
		
	}
	
	@Test(expected=NoSuchElementException.class)
	
	public void cannotTakeResourceFromPoolWithNoFreeResource(){
		
		ResourcePool<Resource> pool = ResourcePool.createPool(1);		
			
		try{
			pool.provideResource();
		}
		catch(NoSuchElementException e){
			fail("there should be at least one free resource");
		}
		pool.provideResource();	
	}
	
	@Test(expected = IllegalArgumentException.class)
	
	public void cannotFreeNonExistingResource(){
		
		ResourcePool<Resource> pool = ResourcePool.createPool(1);
		ResourcePool<Resource> pool2 = ResourcePool.createPool(1);
		pool.freeResource(pool2.provideResource() );
		
		
	}
}
