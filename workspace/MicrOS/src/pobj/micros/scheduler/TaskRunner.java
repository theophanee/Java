package pobj.micros.scheduler;

import pobj.micros.errors.OSError;

public class TaskRunner {

	
	public static void run(IScheduler scheduler) {
		try {
			while(scheduler.execNext()) {
				scheduler.execNext();
			}
		} catch (OSError e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
}
