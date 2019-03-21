package com.example.data.mapper;

import com.example.data.model.ArticaleDataModel;
import com.example.data.model.MediaMetadatumDataModel;
import com.example.data.model.MediumDataModel;
import com.example.domain.model.Articale;
import com.example.domain.model.MediaMetadatum;
import com.example.domain.model.Medium;

import java.util.ArrayList;
import java.util.List;

public class ArticalesMapper {

    public List<Articale> mapToListDomainAreticle(List<ArticaleDataModel> articale){
        List<Articale> articales = new ArrayList<>();

        for (ArticaleDataModel remote : articale){
            articales.add(mapToDomain(remote));
        }

        return articales;
    }


    private Articale mapToDomain(ArticaleDataModel dataModel){
        return new Articale(
                dataModel.getAbstract(),
                dataModel.getAdxKeywords(),
                dataModel.getAssetId(),
                dataModel.getByline(),
                dataModel.getColumn(),
                dataModel.getCountType(),
                dataModel.getDesFacet(),
                dataModel.getEmailCount(),
                dataModel.getEtaId(),
                dataModel.getGeoFacet(),
                dataModel.getId(),
                mapToDomainListMeduim(dataModel.getMedia()),
                dataModel.getNytdsection(),
                dataModel.getOrgFacet(),
                dataModel.getPerFacet(),
                dataModel.getPublishedDate(),
                dataModel.getSection(),
                dataModel.getSource(),
                dataModel.getSubsection(),
                dataModel.getTitle(),
                dataModel.getType(),
                dataModel.getUpdated(),
                dataModel.getUri(),
                dataModel.getUrl()
        );
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
