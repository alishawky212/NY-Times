package com.example.nytimes;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;


@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    private Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelMap;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelMap) {
        this.viewModelMap = viewModelMap;
    }

    @SuppressWarnings({"SuspiciousMethodCalls", "unchecked"})
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<ViewModel> provider = viewModelMap.get(modelClass);
        final Set<Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>>> entries = viewModelMap.entrySet();
        for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : entries) {
            if (entry.getKey().isAssignableFrom(modelClass)) {
                return (T) provider.get();
            }
        }
        throw new IllegalArgumentException("unknown model class " + modelClass);
    }
}
