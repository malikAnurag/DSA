package behavioural.observerPattern.subject;

import behavioural.observerPattern.observers.Observer;

import java.util.ArrayList;

public class CricketData implements Subject {

    int runs;
    int wickets;
    float overs;
    ArrayList<Observer> observerList;

    public CricketData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observerList) {
            o.update(runs, wickets, overs);
        }
    }

    private int getLatestRuns() {
        return 90;
    }

    private int getLatestWickets() {
        return 2;
    }

    private float getLatestOvers() {
        return (float) 10.2;
    }

    public void dataChanged() {
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();

        notifyObservers();
    }
}
