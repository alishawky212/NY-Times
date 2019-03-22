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

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ArticalesViewModel extends ViewModel {

    private ArticlesUseCase useCase;
    private ArticleUIMapper uiMapper;

    public MutableLiveData<List<ArticaleUIModel>> getArticles() {
        return articles;
    }

    private MutableLiveData<List<ArticaleUIModel>> articles = new MutableLiveData<>();

    @Inject
    public ArticalesViewModel(ArticlesUseCase useCase, ArticleUIMapper mapper) {
        this.useCase = useCase;
        this.uiMapper = mapper;
    }

    public void loadArticales(String apiKey){
        EspressoIdlingResource.increment();
        useCase.getArticles(apiKey).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
