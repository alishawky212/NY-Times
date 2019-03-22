package com.example.nytimes.common;

import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicInteger;


public class SimpleCountingIdlingResource implements IdlingResource {


    private AtomicInteger counter = new AtomicInteger(0);

    // written from main thread, read from any thread.
    private IdlingResource.ResourceCallback resourceCallback = null;

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean isIdleNow() {
        return counter.get() == 0;
    }


    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.resourceCallback = callback;
    }


    /**
     * Increments the count of in-flight transactions to the resource being monitored.
     */
    public void increment() {
        counter.getAndIncrement();
    }

    /**
     * Decrements the count of in-flight transactions to the resource being monitored.
     * If this operation results in the counter falling below 0 - an exception is raised.
     *
     * @throws IllegalStateException if the counter is below 0.
     */
    public void decrement() {
        int counterVal = counter.decrementAndGet();
        if (counterVal == 0) {
            // we've gone from non-zero to zero. That means we're idle now! Tell espresso.
            if (resourceCallback != null)
                resourceCallback.onTransitionToIdle();
        } else if (counterVal < 0)
            throw new IllegalArgumentException("Counter has been corrupted!");
    }
}
