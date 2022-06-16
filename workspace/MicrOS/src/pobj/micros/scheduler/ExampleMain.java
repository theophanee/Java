package pobj.micros.scheduler;

import pobj.micros.errors.OSError;

public class ExampleMain {

	public static void main(String[] args) {
		Scheduler s = new Scheduler(new FIFOStrategy());
		ExampleTask e = new ExampleTask(3);
		try {
			e.exec(s);
		} catch (OSError e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}
	}
}
