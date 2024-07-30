package com.example.agriprovisionelite.ui.slideshow;


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
public class GovAdapter  extends  RecyclerView.Adapter<GovAdapter.MyViewHolder> {

private final Context context;
        ArrayList tileId,description_id,documents,date;
        ArrayList<Bitmap> blogImages;

public GovAdapter(Context context, ArrayList tileId, ArrayList description_id, ArrayList documents, ArrayList<Bitmap> blogImages,ArrayList date) {
        this.context = context;
        this.tileId = tileId;
        this.description_id = description_id;
        this.documents = documents;
        this.blogImages = blogImages;
    this.date = date;


}

@NonNull
@Override
public GovAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.govdetails_entries,parent,false);
        return  new MyViewHolder(v);



        }

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tileId.setText(String.valueOf(tileId.get(position)));
        holder.description_id.setText(String.valueOf(description_id.get(position)));
        holder.documents.setText(String.valueOf(documents.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));
        holder.blogimageid.setImageBitmap(blogImages.get(position));

        }

@Override
public int getItemCount() {
        return tileId.size();
        }

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView blogimageid;
    TextView tileId,description_id,documents,date;
    //  ImageView blogimageid;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);


        tileId=itemView.findViewById(R.id.tile_id);
        description_id=itemView.findViewById(R.id.description_id);
        documents=itemView.findViewById(R.id.rd);
        blogimageid=itemView.findViewById(R.id.imageviewId);
        date=itemView.findViewById(R.id.dateid);
    }




}
}
