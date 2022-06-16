package pobj.micros.scheduler;

import java.util.List;

public class MostRecentStrategy implements IStrategy{

	@Override
	public ITask selectTask(List<ITask> tasks) {
		// TODO Auto-generated method stub
		if(tasks.size()!=0)
		return tasks.remove(0);
		return null;
	}

}
