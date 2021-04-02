package observerPattern.Subject;

import observerPattern.Observers.Observer;

public interface Subject {

	void registerObserver(Observer o);

	void unregisterObserver(Observer o);

	void notifyObservers();
}
