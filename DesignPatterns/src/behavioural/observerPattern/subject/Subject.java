package behavioural.observerPattern.subject;

import behavioural.observerPattern.observers.Observer;


/*
* Allows one object (the subject) to notify other objects (the observers) whenever there is a change in it's state
* Different parts of the application can stay updated in real-time
* Observers watch for some action/subject
*
* Keep components updated
*
* Decoupling
* Scalability
* Maintainability
* Weather apps
* Stock market alerts, youtube notifications
* Messaging systems
* Any real-time notification system
*
*
* */

public interface Subject {

	void registerObserver(Observer o);

	void unregisterObserver(Observer o);

	void notifyObservers();
}
