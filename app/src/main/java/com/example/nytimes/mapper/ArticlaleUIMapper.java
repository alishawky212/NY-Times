package com.example.nytimes.mapper;

import com.example.domain.model.Articale;
import com.example.nytimes.models.ArticaleUIModel;

import java.util.ArrayList;
import java.util.List;

public class ArticlaleUIMapper {

    public List<ArticaleUIModel> mapUIListArticales(List<Articale> articales){

        List<ArticaleUIModel> articaleUIModels = new ArrayList<>();

        for (Articale articale :articales){
            articaleUIModels.add(mapToArticleUI(articale));
        }

        return articaleUIModels;
    }


    private ArticaleUIModel mapToArticleUI(Articale articale){
        return new ArticaleUIModel(articale.getTitle(),articale.getByline(),articale.getSource(),
                articale.getPublishedDate(),articale.getMedia().get(0).getMediaMetadata().get(2).getUrl());
    }
}
