package assignment5_DynamicProgramming_5_5;

import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int V) {
    	
    		int[] coins = new int[] {1,3,4};
    		
        int[] table = new int[V+1];
        
        table[0] = 0;
        
        for(int i=1;i<=V;i++)
        		table[i] = Integer.MAX_VALUE;
        
        for(int i=1;i<=V;i++) {
        		for(int j=0;j<coins.length;j++) {
        			if(coins[j]<=i) {
        				int result = table[i-coins[j]];
        				if(result!=Integer.MAX_VALUE && result+1<table[i])
        					table[i] = result+1;
        			}
        		}
        }
        return table[V];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

