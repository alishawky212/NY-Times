package com.example.nytimes.master;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.domain.model.Articale;
import com.example.domain.useCase.ArticalesUseCase;
import com.example.nytimes.mapper.ArticlaleUIMapper;
import com.example.nytimes.models.ArticaleUIModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class ArticalesViewModel extends ViewModel {

    private ArticalesUseCase useCase;
    private ArticlaleUIMapper uiMapper;

    public MutableLiveData<List<ArticaleUIModel>> getArticles() {
        return articles;
    }

    private MutableLiveData<List<ArticaleUIModel>> articles = new MutableLiveData<>();

    @Inject
    public ArticalesViewModel(ArticalesUseCase useCase,ArticlaleUIMapper mapper) {
        this.useCase = useCase;
        this.uiMapper = mapper;
    }

    public void loadArticales(String apiKey){
        useCase.getArticales(apiKey).subscribe(new SingleObserver<List<Articale>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onSuccess(List<Articale> articales) {
                articles.postValue(uiMapper.mapUIListArticales(articales));
            }

            @Override
            public void onError(Throwable e) {
                Log.d("error", e.getMessage());
            }
        });
    }
}
