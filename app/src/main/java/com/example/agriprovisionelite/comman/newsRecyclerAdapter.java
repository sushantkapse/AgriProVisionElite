package com.example.agriprovisionelite.comman;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriprovisionelite.R;
import com.kwabenaberko.newsapilib.models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

public class newsRecyclerAdapter extends  RecyclerView.Adapter<newsRecyclerAdapter.newsViewHolder> {



List<Article> articleList;
    newsRecyclerAdapter(List<Article> articleList){
        this.articleList=articleList;

    }

    @NonNull
    @Override
    public newsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,parent,false);
       return  new newsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull newsViewHolder holder, int position) {
Article article=articleList.get(position);
holder.titleView.setText(article.getTitle());
holder.sourceTextsourceView.setText(article.getSource().getName());
        Picasso.get().load(article.getUrlToImage()).error(R.drawable.imagenotsupported).placeholder(R.drawable.imagenotsupported)
        .into(holder.imageView);


        holder.itemView.setOnClickListener((v->{

            Intent i=new Intent(v.getContext(),FullNewsWeb.class);
            i.putExtra("url",article.getUrl());
            v.getContext().startActivity(i);

        }));


    }


    void updateData(List<Article>data){
        articleList.clear();
        articleList.addAll(data);
    }










    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class newsViewHolder extends RecyclerView.ViewHolder{
        TextView titleView ,sourceTextsourceView;
        ImageView imageView;

        public newsViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView=itemView.findViewById(R.id.title);
            sourceTextsourceView=itemView.findViewById(R.id.source);
            imageView=itemView.findViewById(R.id.article_image_view);

        }
    }
}
