package main.java.oberserverDP.model.Subject;

import main.java.oberserverDP.model.ObserverModel.Observer;

public interface Subject {
	
	void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
