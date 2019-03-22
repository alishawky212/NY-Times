package com.example.nytimes.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nytimes.MainActivity;
import com.example.nytimes.R;
import com.example.nytimes.common.Constant;
import com.example.nytimes.models.ArticaleUIModel;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    @BindView(R.id.image)
    public SimpleDraweeView image;
    @BindView(R.id.title)
    public TextView title;
    @BindView(R.id.description)
    public TextView description;
    @BindView(R.id.created_by)
    public TextView createdBy;
    @BindView(R.id.source)
    public TextView source;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    private ArticaleUIModel article;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        article = getArguments().getParcelable(Constant.ARTICLE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);
        setupToolbar();
        setViewsData();
        return view;
    }


    private void setupToolbar() {
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    private void setViewsData() {
        image.setImageURI(article.getImage_url());
        title.setText(article.getTitle());
        description.setText(article.getmAbstract());
        createdBy.setText(article.getmByline());
        source.setText(article.getmSource());
    }

}
