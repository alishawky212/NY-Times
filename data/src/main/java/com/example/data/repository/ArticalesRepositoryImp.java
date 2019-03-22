package com.example.data.repository;

import com.example.data.mapper.ArticalesMapper;
import com.example.data.model.ArticalesRemote;
import com.example.data.remote.RemoteApis;
import com.example.domain.model.Articale;
import com.example.domain.repository.ArticalesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ArticalesRepositoryImp implements ArticalesRepository {

    private ArticalesMapper mapper;
    private RemoteApis apis;

    @Inject
    public ArticalesRepositoryImp(ArticalesMapper mapper, RemoteApis apis) {
        this.mapper = mapper;
        this.apis = apis;
    }

    @Override
    public Single<List<Articale>> getArticles(String apiKey) {
        return getRemoteArticles(apiKey).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ArticalesRemote, List<Articale>>() {
                    @Override
                    public List<Articale> apply(ArticalesRemote articalesRemote) throws Exception {
                        return mapper.mapToListDomainAreticle(articalesRemote.getResults());
                    }
                });
    }

    private Single<ArticalesRemote> getRemoteArticles(String apiKey){
       return apis.getArticles(apiKey);
    }
}
