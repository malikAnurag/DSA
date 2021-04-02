package practice.DSA.Hashing;
/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * 1. The town judge trusts nobody.
 * 2. Everybody (except for the town judge) trusts the town judge.
 *
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * <p>
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */
public class TownJudgeSingleArray {

    public static void main(String[] args) {

        int[][] trust = {{1,8},{1,3},{2,8},{2,3},{4,8},{4,3},{5,8},{5,3},{6,8},{6,3},{7,8},{7,3},{9,8},{9,3},{11,8},{11,3}};

        System.out.println("\nTown Judge: "+ getTownJudge(11, trust));

        trust = new int[][]{{1, 3}, {2, 3}};
        System.out.println("\nTown Judge: "+ getTownJudge(3, trust));
    }


    public static int getTownJudge(int N , int[][] trust) {

        if(N == 0)
            return 0;

        if(N == 1 && trust.length == 0)
            return 1;

        int[] result = new int[N+1];

        for(int[] t : trust) {
            result[t[0]]--;
            result[t[1]]++;
        }

        for(int i = 1 ; i < result.length ; i++) {
            if(result[i] == N-1)
                return i;
        }
        return -1;
    }
}
