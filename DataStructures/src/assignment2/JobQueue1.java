package assignment2;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue1 {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    private void assignJobs() {
    	assignedWorker = new int[jobs.length];
    startTime = new long[jobs.length];
    // Build a PQ of m Workers sorted by free time
    PriorityQueue<Worker> pq = new PriorityQueue<Worker>(numWorkers,new Comparator<Worker>(){
        @Override
        public int compare (Worker w1, Worker w2) {
            return w1.nextFreeTime == w2.nextFreeTime ? w1.id - w2.id :
                (int) (w1.nextFreeTime - w2.nextFreeTime);
        }
    });
    // Push all new threads with initial free time 0
    for (int i = 0; i < numWorkers; i++)
        pq.offer(new Worker(i));
    // Process each job by the 1st free thread
    for (int i = 0; i < jobs.length; i++) {
        Worker freeThread = pq.poll();
        // Record job i's assigned worker and start_time
        assignedWorker[i] = freeThread.id;
        startTime[i] = freeThread.nextFreeTime;
        // Update next free time and offer back
        freeThread.nextFreeTime += jobs[i];
        pq.offer(freeThread);
        // This thread will be sorted again according to
        // its next free time, by next job to be processed
    }
}
    private static class Worker {
        int id;
        long nextFreeTime;
        public Worker (int id) {
            this.id = id;
            nextFreeTime = 0;
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
