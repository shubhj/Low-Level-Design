package main.java.oberserverDP.model.Subject;

import java.util.ArrayList;
import java.util.List;

import main.java.oberserverDP.model.ObserverModel.Observer;


public class Weather implements Subject {
	
	private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    
    public Weather() {
        observers = new ArrayList<>();
    }
    
    public void update(float temperature, float humidity, float pressure) {
    	this.temperature=temperature;
    	this.humidity=humidity;
    	this.pressure=pressure;
    	notifyObservers();
    }

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		String message = "Current Temperature : " + this.temperature  +", humidity : "+this.humidity +", Pressure : "+this.pressure;
		for(Observer observer : observers)
			observer.update(this, message);
		

	}

}
