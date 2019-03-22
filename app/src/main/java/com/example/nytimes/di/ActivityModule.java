package com.example.nytimes.di;



import android.arch.lifecycle.ViewModel;

import com.example.nytimes.mapper.ArticlaleUIMapper;
import com.example.nytimes.master.ArticalesViewModel;
import com.example.nytimes.master.ArticlesFragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class ActivityModule {
    @Provides
    @PerActivity
    ArticlesFragment provideArticleFragment() {
        return new ArticlesFragment();
    }

    @Provides
    ArticlaleUIMapper provideMapper (){
        return new ArticlaleUIMapper();
    }

}
