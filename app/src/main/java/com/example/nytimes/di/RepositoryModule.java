package com.example.nytimes.di;

import com.example.data.repository.ArticalesRepositoryImp;
import com.example.domain.repository.ArticalesRepository;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoryModule {
    @Binds
    abstract ArticalesRepository provideRepository(ArticalesRepositoryImp articalesRepository);
}
