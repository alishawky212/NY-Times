package com.example.nytimes.di;


import com.example.nytimes.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilder {
    @PerActivity
    @ContributesAndroidInjector(modules = {ActivityModule.class,FragmentBuilder.class})
    MainActivity getMainActivity();
}



