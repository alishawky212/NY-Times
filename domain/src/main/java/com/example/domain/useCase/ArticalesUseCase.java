package com.example.domain.useCase;

import com.example.domain.model.Articale;
import com.example.domain.repository.ArticalesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class ArticalesUseCase {

    private ArticalesRepository repository;

    @Inject
    public ArticalesUseCase(ArticalesRepository repository) {
        this.repository = repository;
    }

    public Single<List<Articale>> getArticales(String apiKey){
        return repository.getArticles(apiKey)
                .map(new Function<List<Articale>, List<Articale>>() {
                    @Override
                    public List<Articale> apply(List<Articale> articales) throws Exception {
                        return null;
                    }
                });
    }
}
