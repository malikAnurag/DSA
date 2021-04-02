package practice.DSA.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * <p>
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */
public class TownJudge {

    public static void main(String[] args) {
        int[][] trust = {{1,8},{1,3},{2,8},{2,3},{4,8},{4,3},{5,8},{5,3},{6,8},{6,3},{7,8},{7,3},{9,8},{9,3},{11,8},{11,3}};

        System.out.println("\nTown Judge: "+ findJudge(11, trust));

        trust = new int[][]{{1, 3}, {2, 3}};
        System.out.println("\nTown Judge: "+ findJudge(3, trust));
    }


    public static int findJudge(int N, int[][] trust) {

        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        List<Integer> al;

        for (int i = 0; i < trust.length; i++) {
            if (!hm.containsKey(trust[i][0])) {
                al = new ArrayList<>();
                al.add(trust[i][1]);
                hm.put(trust[i][0], al);
            } else {
                al = hm.get(trust[i][0]);
                al.add(trust[i][1]);

                hm.put(trust[i][0], al);
            }
        }

        int townJudge = -1;
        ArrayList<Integer> townJudgelist = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            townJudgelist.add(i);
        }

        System.out.println(hm);

        for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) {
            townJudgelist.remove(entry.getKey());
        }

        if (townJudgelist.size() == 0 || townJudgelist.size() > 1)
            return townJudge;

        boolean flag = true;
        int i = townJudgelist.get(0);

        // To check if everybody trusts the judge
        for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) {
            if (!entry.getValue().contains(i)) {
                flag = false;
                break;
            }
        }
        if (flag)
            townJudge = i;

        return townJudge;
    }
}
