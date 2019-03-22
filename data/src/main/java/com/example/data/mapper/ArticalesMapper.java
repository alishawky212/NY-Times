package com.example.data.mapper;

import com.example.data.model.ArticaleDataModel;
import com.example.data.model.MediaMetadatumDataModel;
import com.example.data.model.MediumDataModel;
import com.example.domain.model.Articale;
import com.example.domain.model.MediaMetadatum;
import com.example.domain.model.Medium;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ArticalesMapper {

    @Inject
    public ArticalesMapper() {
    }

    public List<Articale> mapToListDomainAreticle(List<ArticaleDataModel> articale){
        List<Articale> articales = new ArrayList<>();

        for (ArticaleDataModel remote : articale){
            articales.add(mapToDomain(remote));
        }

        return articales;
    }


    private Articale mapToDomain(ArticaleDataModel dataModel){
        Articale articale = new Articale();
        articale.setAbstract(dataModel.getAbstract());
        articale.setAdxKeywords(dataModel.getAdxKeywords());
        articale.setAssetId(dataModel.getAssetId());
        articale.setByline(dataModel.getByline());
        articale.setViews(dataModel.getViews());
        articale.setColumn(dataModel.getColumn());
        articale.setDesFacet(dataModel.getDesFacet());
        articale.setId(dataModel.getId());
        articale.setDesFacet(dataModel.getDesFacet());
        articale.setGeoFacet(dataModel.getGeoFacet());
        articale.setMedia(mapToDomainListMeduim(dataModel.getMedia()));
        articale.setOrgFacet(dataModel.getOrgFacet());
        articale.setPerFacet(dataModel.getPerFacet());
        articale.setPublishedDate(dataModel.getPublishedDate());
        articale.setSection(dataModel.getSection());
        articale.setSource(dataModel.getSource());
        articale.setTitle(dataModel.getTitle());
        articale.setType(dataModel.getType());
        articale.setUrl(dataModel.getUrl());

        return articale;

    }

    private List<Medium> mapToDomainListMeduim(List<MediumDataModel> mediumDataModels){
        List<Medium> media = new ArrayList<>();

        for (MediumDataModel model : mediumDataModels){
            media.add(mapToDomainMeduim(model));
        }

        return media;
    }

    private Medium mapToDomainMeduim(MediumDataModel dataModel){
        return new Medium(dataModel.getApprovedForSyndication(),dataModel.getCaption(),dataModel.getCopyright()
                ,mapToDomainListMeduimMetadatum(dataModel.getMediaMetadata()),dataModel.getSubtype(),dataModel.getType());
    }

    private List<MediaMetadatum> mapToDomainListMeduimMetadatum(List<MediaMetadatumDataModel> metadatumDataModel){
        List<MediaMetadatum> mediaMetadata = new ArrayList<>();

        for (MediaMetadatumDataModel media : metadatumDataModel){
            mediaMetadata.add(mapToDomainMeduimMetadatum(media));
        }
        return mediaMetadata;
    }

    private MediaMetadatum mapToDomainMeduimMetadatum(MediaMetadatumDataModel model){
        return new MediaMetadatum(model.getFormat(),model.getHeight(),model.getUrl(),model.getWidth());
    }

}
