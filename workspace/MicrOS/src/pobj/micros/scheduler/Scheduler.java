package pobj.micros.scheduler;

import java.util.*;

import pobj.micros.errors.OSError;

public class Scheduler implements IScheduler{

	
	private IStrategy strategy;
	private List<ITask> tasks;

	public Scheduler(IStrategy strategy) {
		this.strategy=strategy;
		tasks = new ArrayList<>();
	}
	@Override
	public void setStrategy(IStrategy strategy) {
		// TODO Auto-generated method stub
		this.strategy=strategy;
	}

	@Override
	public void postTask(ITask task) {
		// TODO Auto-generated method stub
		tasks.add(task);
	}

	@Override
	public boolean execNext() throws OSError {
		// TODO Auto-generated method stub
		if(tasks.size()==0)
			return false;
		strategy.selectTask(tasks).exec(this);		
		return true;
	}

}
