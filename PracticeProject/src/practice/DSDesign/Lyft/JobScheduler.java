package practice.DSDesign.Lyft;


import java.util.*;

public class JobScheduler {

    public static class Job {
        String jobId;
        int startTime;
        int duration;

        public Job(String jobId, int startTime, int duration) {
            this.jobId = jobId;
            this.startTime = startTime;
            this.duration = duration;
        }
    }

    public static class Result {
        int minWorkers;
        Map<String, Integer> assignments;

        public Result(int minWorkers, Map<String, Integer> assignments) {
            this.minWorkers = minWorkers;
            this.assignments = assignments;
        }
    }

    /*
 Your task is to allocate workers such that:
    1. The total number of workers created is minimized.
    2. When multiple workers are free, assign the worker with the smallest numeric ID.
    3. Workers receive IDs 0, 1, 2, ... as they are created.
    4. A worker becomes available when its previous job's end time is less than or equal to the next job's start time.
    5. Return the worker ID assigned to each job, along with the total workers created.
    * */
    public Result schedule(List<Job> jobs) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(); // [endTime, workerId]
        PriorityQueue<Integer> workers = new PriorityQueue<>(); // [workerId]
        Map<String, Integer> assignments = new HashMap<>();

        Collections.sort(jobs, (a, b) -> a.startTime - b.startTime);

        for(Job job : jobs) {

            int startTime = job.startTime;
            int duration = job.duration;

            while(!pq.isEmpty() && pq.peek()[0] <= startTime) {
                int workerId = pq.poll()[1];
                workers.add(workerId);
            }
            int assignedWorkerId = workers.isEmpty() ? pq.size() : workers.poll();
            pq.add(new int[]{startTime + duration, assignedWorkerId});
            assignments.put(job.jobId, assignedWorkerId);
        }
        return new Result(pq.size(), assignments);
    }
}
