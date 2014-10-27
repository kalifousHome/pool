package pool;

import pool.resourcePool.ResourcePool;
import action.Action;

public class ResourcePoolAction<R extends Resource> extends Action{

	
		protected  final ResourcePool<R> pool;
		protected final ResourcefulUser<R>user;
		protected boolean is_ready;
		protected boolean is_finished;
		
		public ResourcePoolAction(ResourcePool<R> pool, ResourcefulUser<R> user){
		
			this.pool= pool;
			this.user= user;
			is_ready=true;
			is_finished=false;			
	
		}
		
		@Override
		public boolean is_ready() {
			return is_ready && !is_finished;
		}
		@Override
		public boolean is_finished() {
			
			return is_finished && !is_ready;
		}
		@Override
		public void really_doStep() {
			// TODO Auto-generated method stub
			
		}
		@Override
		protected Action createAction() {
			// TODO Auto-generated method stub
			return null;
		}
		}
