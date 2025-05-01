package behaviouralDesignPatterns.observerPattern.main;

import behaviouralDesignPatterns.observerPattern.observers.AverageScoreDisplay;
import behaviouralDesignPatterns.observerPattern.observers.CurrentScoreDisplay;
import behaviouralDesignPatterns.observerPattern.subject.CricketData;

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
