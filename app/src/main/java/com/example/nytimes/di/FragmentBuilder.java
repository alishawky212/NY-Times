package com.example.nytimes.di;


import com.example.nytimes.master.ArticlesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
@Module
public interface FragmentBuilder {

    @ContributesAndroidInjector
    ArticlesFragment getArticlesFragment();
}
