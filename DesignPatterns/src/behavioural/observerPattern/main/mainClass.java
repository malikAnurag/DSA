package behavioural.observerPattern.main;

import behavioural.observerPattern.observers.AverageScoreDisplay;
import behavioural.observerPattern.observers.CurrentScoreDisplay;
import behavioural.observerPattern.subject.CricketData;

public class mainClass {

    public static void main(String[] args) {

        // Observers
        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

        // Subject
        CricketData cricketData = new CricketData();

        cricketData.registerObserver(averageScoreDisplay);
        cricketData.registerObserver(currentScoreDisplay);

        // Updates
        cricketData.dataChanged();

        cricketData.unregisterObserver(averageScoreDisplay);
        cricketData.dataChanged();
    }
}
