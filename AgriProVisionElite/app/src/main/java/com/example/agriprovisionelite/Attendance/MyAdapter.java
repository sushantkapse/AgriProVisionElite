package com.example.agriprovisionelite.Attendance;

import static android.media.CamcorderProfile.get;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriprovisionelite.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Context context;
    ArrayList labor_id,fname_id,mobile_id,salary_id,JoiningDate_id;

    public MyAdapter(Context context, ArrayList labor_id, ArrayList fname_id, ArrayList mobile_id, ArrayList salary_id, ArrayList joiningDate_id) {
        this.context = context;
        this.labor_id = labor_id;
        this.fname_id = fname_id;
        this.mobile_id = mobile_id;
        this.salary_id = salary_id;
        this.JoiningDate_id = joiningDate_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return  new MyViewHolder(v);



       // return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.labor_id.setText(String.valueOf(labor_id.get(position)));
        holder.fname_id.setText(String.valueOf(fname_id.get(position)));
        holder.mobile_id.setText(String.valueOf(mobile_id.get(position)));
        holder.salary_id.setText(String.valueOf(salary_id.get(position)));
        holder.JoiningDate_id.setText(String.valueOf(JoiningDate_id.get(position)));


    }

    @Override
    public int getItemCount() {
        return labor_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

TextView  labor_id,fname_id,mobile_id,salary_id,JoiningDate_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            labor_id=itemView.findViewById(R.id.labor_id);
            fname_id=itemView.findViewById(R.id.Ufname_id);
            mobile_id=itemView.findViewById(R.id.Umobile_id);
            salary_id=itemView.findViewById(R.id.Usalary_id);
            JoiningDate_id=itemView.findViewById(R.id.Udate_id);





        }




    }
}
