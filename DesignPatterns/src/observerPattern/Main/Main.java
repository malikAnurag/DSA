package observerPattern.Main;

import observerPattern.Observers.AverageScoreDisplay;
import observerPattern.Observers.CurrentScoreDIsplay;
import observerPattern.Subject.CricketData;

public class Main {

	public static void main(String args[]) 
    { 
        AverageScoreDisplay averageScoreDisplay =  new AverageScoreDisplay(); 
        CurrentScoreDIsplay currentScoreDisplay =  new CurrentScoreDIsplay(); 
  
        CricketData cricketData = new CricketData(); 
  
        cricketData.registerObserver(averageScoreDisplay); 
        cricketData.registerObserver(currentScoreDisplay); 
  
        cricketData.dataChanged(); 
  
        cricketData.unregisterObserver(averageScoreDisplay); 
        cricketData.dataChanged(); 
    } 
}
