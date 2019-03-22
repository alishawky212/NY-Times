package com.example.nytimes.di;

import android.arch.lifecycle.ViewModel;

import com.example.nytimes.master.ArticalesViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ArticalesViewModel.class)
   abstract ViewModel bindsArticalesVm (ArticalesViewModel newsViewModel);

}
