package assignment6_DynamicProgramming;

import java.util.Scanner;

public class Knapsack {
	static int optimalWeight(int W, int[] wt) {

		int[][] value = new int[W + 1][wt.length + 1];

		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= wt.length; j++) {
				value[i][j] = value[i][j - 1];
				if (wt[j - 1] <= i) {
					int temp = value[i - wt[j - 1]][j - 1] + wt[j - 1];
					if (temp > value[i][j])
						value[i][j] = temp;
				}
			}
		}
		return value[W][wt.length];
	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

