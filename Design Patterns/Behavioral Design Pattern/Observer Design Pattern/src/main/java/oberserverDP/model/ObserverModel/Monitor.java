package main.java.oberserverDP.model.ObserverModel;

import main.java.oberserverDP.model.Subject.Subject;

public class Monitor implements Observer {

	@Override
	public void update(Subject subject , String message) {
		System.out.println("Monitor : "+message);
	}

}
