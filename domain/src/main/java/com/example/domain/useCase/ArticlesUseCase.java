package com.example.domain.useCase;

import com.example.domain.model.Articale;
import com.example.domain.repository.ArticalesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class ArticlesUseCase {

    private ArticalesRepository repository;

    @Inject
    public ArticlesUseCase(ArticalesRepository repository) {
        this.repository = repository;
    }

    public Single<List<Articale>> getArticles(String apiKey){
        return repository.getArticles(apiKey);
    }
}
