package assignment3_Greedy;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


								/*UNKNOWN TESTCASE GETTING FAILED*/
public class FractionalKnapsack {
    private static double getOptimalValue(double capacity, int[] values, int[] weights) {
        Double value = 0d;
        ItemValue[] items = new ItemValue[weights.length];
        
        for(int i=0; i<weights.length; i++) {
        		items[i] = new ItemValue(weights[i], values[i]);
        }
        
        Arrays.sort(items, new Comparator<ItemValue>() {
        	@Override	
        	public int compare(ItemValue d1, ItemValue d2) {
        		return d2.cost.compareTo(d1.cost);
        		}
        });
        
        for(ItemValue item : items) {
        		
        	int curWt = (int)item.wt;
        	int curVal = (int)item.value;
        		if(capacity - curWt >=0) {
        			capacity -= curWt;
        			value += curVal;
        		}
        		else {
        			double fraction = (double) capacity / (double) curWt;
        			capacity -= (double)curWt * fraction;
        			value += curVal * fraction;
        			if(capacity<=0)
        				break;
        		}
        	  }	
        DecimalFormat dec = new DecimalFormat("#0.0000");
        dec.setRoundingMode(RoundingMode.CEILING);
        return Double.valueOf(dec.format(value));
    }

    
    static class ItemValue {
    	
    		Double cost;
    		double wt, value;
    		
    		public ItemValue(int wt,int value) {
    			this.wt = wt;
    			this.value = value;
    			this.cost = new Double(value/wt);
    		}
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
