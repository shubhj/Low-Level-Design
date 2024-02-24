package main.java.oberserverDP.model.ObserverModel;

import main.java.oberserverDP.model.Subject.Subject;

public class Display implements Observer {

	@Override
	public void update(Subject subject, String message) {
		
		System.out.println("Display : "+message);

	}

}
