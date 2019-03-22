package com.example.nytimes.mapper;

import com.example.domain.model.Articale;
import com.example.nytimes.models.ArticaleUIModel;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ArticleUIMapper {

    @Inject
    public ArticleUIMapper() {
    }

    public List<ArticaleUIModel> mapUIListArticles(List<Articale> articles){

        List<ArticaleUIModel> articleUIModels = new ArrayList<>();

        for (Articale articale :articles){
            articleUIModels.add(mapToArticleUI(articale));
        }

        return articleUIModels;
    }


    public ArticaleUIModel mapToArticleUI(Articale articale){
        return new ArticaleUIModel(articale.getTitle(),articale.getByline(),articale.getSource(),
                articale.getPublishedDate(),articale.getMedia().get(0).getMediaMetadata().get(0).getUrl()
                ,articale.getAbstract());
    }
}
