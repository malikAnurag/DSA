package edu.coursera.concurrent.week3;

import edu.rice.pcdp.Actor;

import java.util.ArrayList;
import java.util.List;

import static edu.rice.pcdp.PCDP.finish;

/**
 * An actor-based implementation of the Sieve of Eratosthenes.
 *
 * TODO Fill in the empty SieveActorActor actor class below and use it from
 * countPrimes to determine the number of primes <= limit.
 */
public final class SieveActor extends Sieve {
    /**
     * {@inheritDoc}
     *
     * TODO Use the SieveActorActor class to calculate the number of primes <=
     * limit in parallel. You might consider how you can model the Sieve of
     * Eratosthenes as a pipeline of actors, each corresponding to a single
     * prime number.
     */
    @Override
    public int countPrimes(final int limit) {

        SieveActorActor actor = new SieveActorActor(2);
        finish(() -> {
            for(int i = 3 ; i <= limit ; i+= 2) {
                actor.send(i);
            }
        });

        int numPrimes = 0 ;
        SieveActorActor loopActor = actor;
        while (loopActor != null) {
            numPrimes += loopActor.localPrimes.size();
            loopActor = loopActor.nextActor;
        }
        return numPrimes;
    }


    /**
     * An actor class that helps implement the Sieve of Eratosthenes in
     * parallel.
     */
    public static final class SieveActorActor extends Actor {
        /**
         * Process a single message sent to this actor.
         *
         * TODO complete this method.
         *
         * @param msg Received message
         */

        final List<Integer> localPrimes = new ArrayList<Integer>();

        private static final int MAX_LOCAL_PRIMES = 1_000;

        private SieveActorActor nextActor;

        public SieveActorActor(int x) {
            localPrimes.add(x);
        }

        @Override
        public void process(final Object msg) {

            final int candidate = (Integer) msg;

            if(checkPrime(candidate)) {
                if(localPrimes.size() < MAX_LOCAL_PRIMES) {
                    localPrimes.add(candidate);
                }
                else if(nextActor == null) {
                    nextActor = new SieveActorActor(candidate);
                }
                else {
                    nextActor.send(candidate);
                }
            }
        }

        private boolean checkPrime(final int candidate) {
            boolean isPrime = true;
            final int s = localPrimes.size();
            for (int i = 0; i < s; ++i) {
                final Integer loopPrime = localPrimes.get(i);
                if (candidate % loopPrime.intValue() == 0) {
                    isPrime = false;
                    break;
                }
            }
            return isPrime;
        }
    }
}
