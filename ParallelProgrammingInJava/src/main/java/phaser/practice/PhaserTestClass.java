package phaser.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserTestClass {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        /*
        * When creating Phaser instance from the main thread, we're passing 1 as an argument. This is equivalent to calling the
        * register() method from the current thread. We're doing this because, when we're creating three worker threads,
        * the main thread is a coordinator, and therefore the Phaser needs to have four threads registered to it:
        * */

        Phaser ph = new Phaser(1);

// Phase 0
/********************************************************************/
        service.submit(new LongRunningAction("Thread-1", ph));
        service.submit(new LongRunningAction("Thread-2", ph));
        service.submit(new LongRunningAction("Thread-3", ph));
/********************************************************************/

        ph.arriveAndAwaitAdvance(); // This completes Phase 0, now after this the task moves to phase 1


//Phase 1
/********************************************************************/
        service.submit(new LongRunningAction("Thread-4", ph));
        service.submit(new LongRunningAction("Thread-5", ph));
/********************************************************************/

        ph.arriveAndAwaitAdvance(); // This completes Phase 1, now after this the task moves to phase 2

//Phase 2
/********************************************************************/
        service.submit(new LongRunningAction("Thread-6", ph));
        service.submit(new LongRunningAction("Thread-7", ph));
/********************************************************************/

        ph.arriveAndAwaitAdvance();

        ph.arriveAndDeregister();
    }
}
