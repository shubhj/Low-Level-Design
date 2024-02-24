package main.java.oberserverDP;

import main.java.oberserverDP.model.ObserverModel.Display;
import main.java.oberserverDP.model.ObserverModel.Monitor;
import main.java.oberserverDP.model.ObserverModel.Observer;
import main.java.oberserverDP.model.Subject.Weather;

public class Main {

	public static void main(String[] args) {
		
		Weather weather = new Weather();
		
		Observer obs1 = new Monitor();
		Observer obs2 = new Display();
		
		weather.update(0, 0, 0);
		System.out.println();
		weather.addObserver(obs1);
		weather.update(50, 100, 100);
		System.out.println();
		weather.addObserver(obs2);
		weather.update(80, 100, 100);
	}

}
