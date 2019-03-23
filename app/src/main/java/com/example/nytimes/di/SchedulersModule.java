package com.example.nytimes.di;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class SchedulersModule {

    public static final String IO_SCHEDULER = "IO_SCHEDULER";
    public static final String MAIN_THREAD_SCHEDULER = "MAIN_THREAD_SCHEDULER";

    @Provides
    @Named(value = IO_SCHEDULER)
    Scheduler bindIoScheduler(){
        return Schedulers.io();
    }

    @Provides
    @Named(value = MAIN_THREAD_SCHEDULER)
    Scheduler bindMainThreadScheduler(){
        return AndroidSchedulers.mainThread();
    }

}
