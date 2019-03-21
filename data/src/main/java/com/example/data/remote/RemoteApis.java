package com.example.data.remote;

import com.example.data.model.ArticalesRemote;


import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RemoteApis {
    @GET("v2/mostviewed/all-sections/7.json")
    Single<ArticalesRemote> getArticles(@Query("api-key") String apiKey);
}
