package com.example.nytimes.master;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.domain.model.Articale;
import com.example.domain.useCase.ArticlesUseCase;
import com.example.nytimes.common.EspressoIdlingResource;
import com.example.nytimes.mapper.ArticleUIMapper;
import com.example.nytimes.models.ArticaleUIModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.nytimes.di.SchedulersModule.IO_SCHEDULER;
import static com.example.nytimes.di.SchedulersModule.MAIN_THREAD_SCHEDULER;

public class ArticalesViewModel extends ViewModel {

    private ArticlesUseCase useCase;
    private ArticleUIMapper uiMapper;
    private Scheduler main_thread;
    private Scheduler io_thread;

    public MutableLiveData<List<ArticaleUIModel>> getArticles() {
        return articles;
    }

    private MutableLiveData<List<ArticaleUIModel>> articles = new MutableLiveData<>();

    @Inject
    public ArticalesViewModel(ArticlesUseCase useCase, ArticleUIMapper mapper,@Named(value = IO_SCHEDULER) Scheduler subscribeOn, @Named(value = MAIN_THREAD_SCHEDULER) Scheduler observeOn) {
        this.useCase = useCase;
        this.uiMapper = mapper;
        this.io_thread = subscribeOn;
        this.main_thread = observeOn;
    }

    public void loadArticales(String apiKey){
        EspressoIdlingResource.increment();
        useCase.getArticles(apiKey).
                subscribeOn(io_thread)
                .observeOn(main_thread)
                .subscribe(new SingleObserver<List<Articale>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onSuccess(List<Articale> articales) {
                EspressoIdlingResource.decrement();
                articles.postValue(uiMapper.mapUIListArticles(articales));
            }

            @Override
            public void onError(Throwable e) {
                EspressoIdlingResource.decrement();
                Log.d("error", e.getMessage());
            }
        });
    }
}
