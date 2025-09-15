package practice.DSA.Backtracking;

/**
 * You are given an integer array jobs, where jobs[i] is the amount of time it takes to complete the ith job.
 * <p>
 * There are k workers that you can assign jobs to. Each job should be assigned to exactly one worker.
 * The working time of a worker is the sum of the time it takes to complete all jobs assigned to them.
 * <p>
 * Your goal is to devise an optimal assignment such that the maximum working time of any worker is minimized.
 * Return the minimum possible maximum working time of any assignment.
 * <p>
 * Example 1:
 * Input: jobs = [3,2,3], k = 3
 * Output: 3
 * Explanation: By assigning each person one job, the maximum time is 3.
 * <p>
 * Example 2:
 * Input: jobs = [1,2,4,7,8], k = 2
 * Output: 11
 * Explanation: Assign the jobs the following way:
 * Worker 1: 1, 2, 8 (working time = 1 + 2 + 8 = 11)
 * Worker 2: 4, 7 (working time = 4 + 7 = 11)
 * The maximum working time is 11.
 * <p>
 * Constraints:
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 107
 */
public class MinimumTimeToFinishAllJobs {

    int result = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        int[] workers = new int[k];
        backtrack(jobs, 0, workers, 0);
        return result;
    }

    private void backtrack(int[] jobs, int idx, int[] workers, int currMax) {

        if (idx == jobs.length) {
            result = Math.min(result, currMax);
            return;
        }

        int job = jobs[idx];

        for (int i = 0; i < workers.length; i++) {

            if (job + workers[i] >= result)
                continue;

            workers[i] += job;
            backtrack(jobs, idx + 1, workers, Math.max(currMax, workers[i]));
            workers[i] -= job;

            if (workers[i] == 0)
                break;
        }
    }
}
