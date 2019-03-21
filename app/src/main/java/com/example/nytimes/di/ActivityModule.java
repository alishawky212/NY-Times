package com.example.nytimes.di;



import com.example.nytimes.mapper.ArticlaleUIMapper;
import com.example.nytimes.master.ArticlesFragment;

import dagger.Module;
import dagger.Provides;

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
