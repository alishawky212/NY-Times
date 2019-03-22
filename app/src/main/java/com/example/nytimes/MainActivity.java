package com.example.nytimes;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nytimes.master.ArticlesFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    ArticlesFragment articlesFragment;

//    @Inject
//    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    void initView() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, articlesFragment, "TAG")
                .commit();

    }


    public void replaceCurrentFragment(Bundle data, Fragment fragment) {
        fragment.setArguments(data);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, "second_fragement")
                .addToBackStack(articlesFragment.getClass().getName())
                .commit();
    }
}
