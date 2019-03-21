package com.example.nytimes;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import com.example.domain.useCase.ArticalesUseCase;
import com.example.nytimes.mapper.ArticlaleUIMapper;
import com.example.nytimes.master.ArticalesViewModel;
import javax.inject.Inject;


public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private  ArticalesUseCase useCase;
    private  ArticlaleUIMapper uiMapper;

    @Inject
    public ViewModelFactory(ArticalesUseCase useCase, ArticlaleUIMapper uiMapper) {
        this.useCase = useCase;
        this.uiMapper = uiMapper;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ArticalesViewModel.class)) {
            return (T) new ArticalesViewModel(useCase,uiMapper);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
