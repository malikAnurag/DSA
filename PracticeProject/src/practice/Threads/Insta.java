package practice.Threads;

import java.util.ArrayList;

public class Insta {

    // Main class should be named 'Solution' and should not be public.
    /****** MAIN PROGRAM EXCERPT ************/
    public void main(String[] args) {

        //...create pool of threads
        ArrayList<WorkerThread> workers = new ArrayList<>();
//        for (...) {
            WorkerThread w = new WorkerThread();
//            workers.addElement(w);
            w.start();
//        }
        boolean hasWork = true;
        while(hasWork) {
            // get more work to do or null if time to exit
//            Work w = getWork();
//            if (w == null) {
                hasWork = false;
//                for (int i=0; i < workers.size(); i++)
//                    ((WorkerThread) workers.elementAt(i)).setDone();
//            }
//            else {
                // give to some worker
//                int poorWorkerBee = ...
//                ((WorkerThread) workers.elementAt(poorWorkerBee)).addWork(w);
//            }
        }
    }

    /******* WorkerThread.java class **************/
    public static class WorkerThread extends Thread {

        private boolean done_;
        private int workIndex_;
        private Work[] pendingWork_;

        public WorkerThread() {
            done_ = false;
            workIndex_ = -1;
            pendingWork_ = new Work[16];
        }
        public void run() {
            while (! isDone()) {
                if (hasWork())
                    doWork();
//                else
//                    sleep(1000);
            }
        } // execute

        public boolean isDone() { return done_; }
        public void setDone() { done_ = true; }
        public boolean hasWork() {
            return workIndex_ > -1;
        }
        public synchronized void addWork(Work w) {
            pendingWork_[++workIndex_] = w;
        }
        public synchronized void doWork() {
            // do some stuff
            pendingWork_[workIndex_].haveBreakfast();
            // do some more stuff
            pendingWork_[workIndex_].haveLunch();
            // do final stuff
            pendingWork_[workIndex_].haveDinner();
            workIndex_--;
        }
    }
} // WorkerThread

