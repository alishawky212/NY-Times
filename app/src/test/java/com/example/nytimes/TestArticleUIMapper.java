package com.example.nytimes;

import com.example.domain.model.Articale;
import com.example.domain.model.MediaMetadatum;
import com.example.domain.model.Medium;
import com.example.nytimes.mapper.ArticleUIMapper;
import com.example.nytimes.models.ArticaleUIModel;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestArticleUIMapper {

    private ArticleUIMapper uiMapper;
    private String title;
    private String mByline;
    private String mSource;
    private String mPublichDate;
    private String image_url;
    private String mAbstract;

    @Before
    public void setUp(){
        initFields();
        uiMapper = new ArticleUIMapper();

    }

    private void initFields(){
        title = "Jacinda Adern Consoles";
        mByline = "14-03-2019";
        mSource = "Test Test Test TestTest TestTest TestTest Test ";
        mPublichDate = "22-3-2019";
        image_url = "www.google.com";
        mAbstract = "MAbstract";

    }

    @Test
    public void mapToUI() {
        Articale articleDomain = createDummyArticale();
        ArticaleUIModel articleUI = uiMapper.mapToArticleUI(articleDomain);
        assertEquals(articleUI.getTitle(), title);
        assertEquals(articleUI.getImage_url(),image_url);
        assertEquals(articleUI.getmAbstract(),mAbstract);
        assertEquals(articleUI.getmByline(),mByline);
        assertEquals(articleUI.getmPublichDate(),mPublichDate);
        assertEquals(articleUI.getmSource(),mSource);
    }

    @Test
    public void mapToLisUI() {
        List<Articale> articleDomain = createDummayListArticale();
       List<ArticaleUIModel> articleUI = uiMapper.mapUIListArticles(articleDomain);
       for (ArticaleUIModel uiModel : articleUI){
           assertEquals(uiModel.getTitle(), title);
           assertEquals(uiModel.getImage_url(),image_url);
           assertEquals(uiModel.getmAbstract(),mAbstract);
           assertEquals(uiModel.getmByline(),mByline);
           assertEquals(uiModel.getmPublichDate(),mPublichDate);
           assertEquals(uiModel.getmSource(),mSource);
       }
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
}