package com.example.nytimes.di;



import com.example.nytimes.mapper.ArticleUIMapper;
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
    ArticleUIMapper provideMapper (){
        return new ArticleUIMapper();
    }

}
