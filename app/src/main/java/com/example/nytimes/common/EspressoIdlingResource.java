package com.example.nytimes.common;

import android.support.test.espresso.IdlingResource;

public class EspressoIdlingResource {
    public static SimpleCountingIdlingResource countingIdlingResource = new SimpleCountingIdlingResource();

    public static void increment() {
        if (countingIdlingResource != null)
            countingIdlingResource.increment();
    }

    public static void decrement() {
        if (countingIdlingResource != null)
            countingIdlingResource.decrement();
    }

    public static IdlingResource getIdlingResource() {
        return countingIdlingResource;
    }


}
