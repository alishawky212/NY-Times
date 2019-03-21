package com.example.nytimes.master;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nytimes.MainActivity;
import com.example.nytimes.R;
import com.example.nytimes.ViewModelFactory;
import com.example.nytimes.models.ArticaleUIModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ArticlesFragment extends Fragment {

    @BindView(R.id.articles_recycler)
    RecyclerView articlesRecyclerView;
    @Inject
    ArticlesAdapter adapter;

    @Inject
    ViewModelFactory viewModelFactory;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    ArticalesViewModel mViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity(), viewModelFactory).get(ArticalesViewModel.class);
    }

    void initViews() {
        articlesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        articlesRecyclerView.setAdapter(adapter);
    }

    private void setupToolbar() {
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    void loadData() {
        mViewModel.loadArticales("cdUar5iB34vC4CAc9AN4i1Pi1UM6hamz");

        mViewModel.getArticles().observe(this, new Observer<List<ArticaleUIModel>>() {
            @Override
            public void onChanged(@Nullable List<ArticaleUIModel> articaleUIModels) {
                adapter.setArticles(articaleUIModels);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_articales, container, false);
        ButterKnife.bind(this, view);

        initViews();
        setupToolbar();
        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }
}
