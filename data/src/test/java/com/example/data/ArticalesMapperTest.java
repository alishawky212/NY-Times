package com.example.data;

import com.example.data.mapper.ArticalesMapper;
import com.example.data.model.ArticaleDataModel;
import com.example.data.model.MediaMetadatumDataModel;
import com.example.data.model.MediumDataModel;
import com.example.domain.model.Articale;
import com.example.domain.model.MediaMetadatum;
import com.example.domain.model.Medium;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ArticalesMapperTest {
    private ArticalesMapper mapper;
    private String title;
    private String mByline;
    private String mSource;
    private String mPublichDate;
    private String image_url;
    private String mAbstract;

    @Before
    public void setUp(){
        initFields();
        mapper = new ArticalesMapper();

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
    public void mapToLisDomain() {
        List<ArticaleDataModel> articleDomain = createDummayListArticale();
        List<Articale> articleUI = mapper.mapToListDomainAreticle(articleDomain);
        for (Articale uiModel : articleUI){
            assertEquals(uiModel.getTitle(), title);
            assertEquals(uiModel.getMedia().get(0).getMediaMetadata().get(0).getUrl(),image_url);
            assertEquals(uiModel.getAbstract(),mAbstract);
            assertEquals(uiModel.getByline(),mByline);
            assertEquals(uiModel.getPublishedDate(),mPublichDate);
            assertEquals(uiModel.getSource(),mSource);
        }
    }

    private List<ArticaleDataModel> createDummayListArticale(){
        List<ArticaleDataModel> articales = new ArrayList<>();

        for (int i = 0;i<10;i++){
            articales.add(createDummyArticale());
        }

        return articales;
    }

    private ArticaleDataModel createDummyArticale(){
        ArticaleDataModel articale = new ArticaleDataModel();
        List<MediaMetadatumDataModel> metadata = new ArrayList<>();
        metadata.add(new MediaMetadatumDataModel("",0L,image_url,0L));
        List<MediumDataModel> media = new ArrayList<>();
        media.add(new MediumDataModel(0L,"","",metadata,"",""));
        articale.setTitle(title);
        articale.setByline(mByline);
        articale.setSource(mSource);
        articale.setPublishedDate(mPublichDate);
        articale.setMedia(media);
        articale.setAbstract(mAbstract);
        return articale;
    }
}