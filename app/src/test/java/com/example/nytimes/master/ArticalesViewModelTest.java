package com.example.nytimes.master;

import android.arch.core.executor.testing.InstantTaskExecutorRule;


import com.example.domain.model.Articale;
import com.example.domain.model.MediaMetadatum;
import com.example.domain.model.Medium;
import com.example.domain.useCase.ArticlesUseCase;
import com.example.nytimes.common.Constant;
import com.example.nytimes.common.LiveDataTestUtil;
import com.example.nytimes.mapper.ArticleUIMapper;
import com.example.nytimes.models.ArticaleUIModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import static org.mockito.MockitoAnnotations.*;


@RunWith(JUnit4.class)
public class ArticalesViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Mock
    ArticlesUseCase articlesUseCase;


    ArticleUIMapper articleUIMapper;

    private ArticalesViewModel articalesViewModel;

    private List<ArticaleUIModel> articales;


    private String title;
    private String mByline;
    private String mSource;
    private String mPublichDate;
    private String image_url;
    private String mAbstract;

    @Before
    public void setUp() {
        initFields();
        initMocks(this);
        articleUIMapper = new ArticleUIMapper();
        articalesViewModel = new ArticalesViewModel(articlesUseCase,articleUIMapper,Schedulers.trampoline(), Schedulers.trampoline());
    }


    private  List<ArticaleUIModel> createDummayListArticaleUIModel(){
        List<ArticaleUIModel> articales = new ArrayList<>();

        for (int i = 0;i<10;i++){
            articales.add(new ArticaleUIModel(title,mByline,mSource,mPublichDate,image_url,mAbstract));
        }

        return articales;
    }


    private void initFields(){
        title = "Jacinda Adern Consoles";
        mByline = "14-03-2019";
        mSource = "Test Test Test TestTest TestTest TestTest Test ";
        mPublichDate = "22-3-2019";
        image_url = "www.google.com";
        mAbstract = "MAbstract";

    }


    private List<Articale> createDummayListArticale(){
        List<Articale> articales = new ArrayList<>();

        for (int i = 0;i<10;i++){
            articales.add(createDummyArticale());
        }

        return articales;
    }

    private Articale createDummyArticale(){
        Articale articale = new Articale();
        List<MediaMetadatum> metadata = new ArrayList<>();
        metadata.add(new MediaMetadatum("",0L,image_url,0L));
        List<Medium> media = new ArrayList<>();
        media.add(new Medium(0L,"","",metadata,"",""));
        articale.setTitle(title);
        articale.setByline(mByline);
        articale.setSource(mSource);
        articale.setPublishedDate(mPublichDate);
        articale.setMedia(media);
        articale.setAbstract(mAbstract);
        return articale;
    }

    @Test
    public void loadArticles() throws InterruptedException {
        doReturn(Single.just(createDummayListArticale()))
                .when(articlesUseCase)
                .getArticles(Constant.API_KEY);
        articalesViewModel.loadArticales(Constant.API_KEY);
        articales = createDummayListArticaleUIModel();
        assertEquals(articales,LiveDataTestUtil.getValue(articalesViewModel.getArticles()));
    }
}