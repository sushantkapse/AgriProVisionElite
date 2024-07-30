package com.example.agriprovisionelite.Crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;

import java.util.ArrayList;

public class Crop_Adapter extends RecyclerView.Adapter<Crop_Adapter.viewHolder> {

    Context context;
    DataBase dbHelper;

    ArrayList crop_id,c_name,c_sowing_date,c_area,c_duration;

    public Crop_Adapter(Context context,  ArrayList crop_id, ArrayList c_name, ArrayList c_sowing_date, ArrayList c_area, ArrayList c_duration) {
        this.context = context;

        this.crop_id = crop_id;
        this.c_name = c_name;
        this.c_sowing_date = c_sowing_date;
        this.c_area = c_area;
        this.c_duration = c_duration;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);


        View view = inflater.inflate(R.layout.row_crop,null);
        return  new viewHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.tv_id.setText(String.valueOf(crop_id.get(position)));
        holder.tv_name.setText(String.valueOf(c_name.get(position)));
        holder.tv_sowing_date.setText(String.valueOf(c_sowing_date.get(position)));
        holder.tv_area.setText(String.valueOf(c_area.get(position)));
        holder.tv_duration.setText(String.valueOf(c_area.get(position)));


        holder.menu_crop_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context,holder.menu_crop_row);
                popupMenu.inflate(R.menu.menu_crop);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();
                        int a = R.id.crop_update;
                        int b = R.id.crop_delete;
                        int c = R.id.add_expense;

                        if (id == a) {
                            Intent intent = new Intent(context, Update_Crop.class);
                            context.startActivity(intent);
                            return true;

                        } else if (id == b) {
//                            Intent intent = new Intent(context, AddCrop.class);
//                            context.startActivity(intent);
                            dbHelper = new DataBase(context);

                            dbHelper.deleteCrop(String.valueOf(crop_id.get(position)));
                            // Remove item from ArrayList
                            crop_id.remove(position);
                            c_name.remove(position);
                            c_sowing_date.remove(position);
                            c_area.remove(position);
                            c_duration.remove(position);
                            // Notify adapter about item removal
                            notifyDataSetChanged();

                            return true;
                        } else if (id == c) {
                            Intent intent = new Intent(context, Add_Expenses.class);
                            intent.putExtra("crop_id", crop_id.get(position).toString());
                            intent.putExtra("c_sowing_date", c_sowing_date.get(position).toString());
                            intent.putExtra("c_area", c_area.get(position).toString());
                            intent.putExtra("c_name", c_name.get(position).toString());



                            context.startActivity(intent);
                            return true;
                        }


                        return false;
                    }
                });

                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return crop_id.size();

    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView tv_name,tv_id,tv_duration,tv_sowing_date,tv_area;
        ImageView menu_crop_row;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.row_crop_name);
            tv_id = (TextView) itemView.findViewById(R.id.row_crop_id);
            tv_duration = (TextView) itemView.findViewById(R.id.row_crop_duration);
            tv_sowing_date = (TextView) itemView.findViewById(R.id.row_crop_sowing_date);
            tv_area = (TextView) itemView.findViewById(R.id.row_crop_area);
            menu_crop_row = (ImageView) itemView.findViewById(R.id.menu_crop_row);
        }
    }
}
