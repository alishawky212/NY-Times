package com.example.domain.repository;

import com.example.domain.model.Articale;

import java.util.List;

import io.reactivex.Single;

public interface ArticalesRepository {
    Single<List<Articale>> getArticles(String apiKey);
}
