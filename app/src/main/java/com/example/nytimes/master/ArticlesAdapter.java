package com.example.nytimes.master;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nytimes.R;
import com.example.nytimes.models.ArticaleUIModel;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>{



    List<ArticaleUIModel> articles = new ArrayList<>();
    itemClickListener itemClickListener;

    @Inject
    public ArticlesAdapter() {

    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticlesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.article_recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder holder, int position) {
        ArticaleUIModel article = articles.get(position);
        holder.tvTitle.setText(article.getTitle());
        holder.tvCreatedBy.setText(article.getmByline());
        holder.tvSource.setText(article.getmSource());
        holder.tvDate.setText(article.getmPublichDate());
        holder.image.setImageURI(article.getImage_url());
    }

    public void setArticles(List<ArticaleUIModel> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    public void setItemClickListenr(itemClickListener itemClickListenr) {
        this.itemClickListener = itemClickListenr;
    }

    public interface itemClickListener {
        void onItemClicked(ArticaleUIModel articaleUIModel);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ArticlesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView tvTitle;
        @BindView(R.id.image)
        SimpleDraweeView image;

        @BindView(R.id.created_by)
        TextView tvCreatedBy;
        @BindView(R.id.source)
        TextView tvSource;

        @BindView(R.id.date)
        TextView tvDate;

        public ArticlesViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view ->
                    itemClickListener.onItemClicked(articles.get(getAdapterPosition())
                    )
            );

        }
    }
}
