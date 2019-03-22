package com.example.nytimes.master;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.nytimes.MainActivity;
import com.example.nytimes.R;
import com.example.nytimes.common.Constant;
import com.example.nytimes.detail.DetailsFragment;
import com.example.nytimes.models.ArticaleUIModel;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerFragment;


public class ArticlesFragment extends DaggerFragment implements ArticlesAdapter.itemClickListener{


    @BindView(R.id.articles_recycler)
    RecyclerView articlesRecyclerView;
    @Inject
    ArticlesAdapter adapter;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    ArticalesViewModel mViewModel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity(), viewModelFactory).get(ArticalesViewModel.class);
    }

    void initViews() {
        adapter.setItemClickListenr(this);
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

        mViewModel.loadArticales(Constant.API_KEY);

        mViewModel.getArticles().observe(this, articaleUIModels -> adapter.setArticles(articaleUIModels));
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

    @Override
    public void onItemClicked(ArticaleUIModel articaleUIModel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.ARTICLE, articaleUIModel);
        ((MainActivity) getActivity()).replaceCurrentFragment(bundle , new DetailsFragment());
    }
}
