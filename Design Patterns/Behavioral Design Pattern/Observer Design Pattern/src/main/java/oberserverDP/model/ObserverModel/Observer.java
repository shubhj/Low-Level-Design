package main.java.oberserverDP.model.ObserverModel;

import main.java.oberserverDP.model.Subject.Subject;

public interface Observer {
	
	void update(Subject subject, String message);

}
