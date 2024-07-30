package com.example.agriprovisionelite.ui.gallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriprovisionelite.R;

import java.util.ArrayList;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.MyViewHolder> {

    private final Context context;
    ArrayList tile_id,description_id,author_id;
    ArrayList<Bitmap> blogImages;

    public BlogAdapter(Context context, ArrayList tile_id, ArrayList description_id, ArrayList author_id, ArrayList<Bitmap> blogImages) {
        this.context = context;
        this.tile_id = tile_id;
        this.description_id = description_id;
        this.author_id = author_id;
        this.blogImages = blogImages;

    }

    @NonNull
    @Override
    public BlogAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.blogdetails_entries,parent,false);
        return  new MyViewHolder(v);



    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tile_id.setText(String.valueOf(tile_id.get(position)));
        holder.description_id.setText(String.valueOf(description_id.get(position)));
        holder.author_id.setText(String.valueOf(author_id.get(position)));
        // put code for image
        holder.blogimageid.setImageBitmap(blogImages.get(position));

    }

    @Override
    public int getItemCount() {
        return author_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView blogimageid;
        TextView tile_id,description_id,author_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tile_id=itemView.findViewById(R.id.tile_id);
            description_id=itemView.findViewById(R.id.description_id);
            author_id=itemView.findViewById(R.id.author_id);
           blogimageid=itemView.findViewById(R.id.blogimageid);

        }




    }
}
