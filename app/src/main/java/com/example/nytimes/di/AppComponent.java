package com.example.nytimes.di;

import android.app.Application;

import com.example.data.remote.RemoteApis;
import com.example.nytimes.ArticaleApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules ={AndroidSupportInjectionModule.class,ArticalesViewModelModule.class,NetworkModule.class,ActivityBuilder.class,RepositoryModule.class,SchedulersModule.class})
public interface AppComponent {
    void inject(ArticaleApplication app);
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder networkModule(@Named("url") String url);


        AppComponent build();
    }
}
