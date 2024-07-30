package com.example.agriprovisionelite.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriprovisionelite.R;

import java.util.ArrayList;

public class MyAdapterFarmerDetails  extends  RecyclerView.Adapter<MyAdapterFarmerDetails.MyViewHolder> {
    private final Context context;
    //public  boolean insertFarmerData (String name ,String email, String password,String mobile,String adhar,String state, String dist ,String tal){

    ArrayList f_id, f_name_id, f_email, f_mobile_id, adhar_id, address_id;



    //boomrilo

    private  OnItemClickListener listener;
    public  interface OnItemClickListener{
        void onItemClick(int position);
    }

    public  void setOnItemClickListener(OnItemClickListener onItemClickListener){

        listener=onItemClickListener;
    }




    public MyAdapterFarmerDetails(Context context, ArrayList f_id, ArrayList f_name_id, ArrayList f_email, ArrayList f_mobile_id, ArrayList adhar_id, ArrayList address_id) {
        this.context = context;
        this.f_id = f_id;
        this.f_name_id = f_name_id;
        this.f_email = f_email;
        this.f_mobile_id = f_mobile_id;
        this.adhar_id = adhar_id;
        this.address_id = address_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.farmeralldetails,parent,false);
       return  new MyAdapterFarmerDetails.MyViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.f_id.setText(String.valueOf(f_id.get(position)));
        holder.f_name_id.setText(String.valueOf(f_name_id.get(position)));
        holder.f_email.setText(String.valueOf(f_email.get(position)));
        holder.f_mobile_id.setText(String.valueOf(f_mobile_id.get(position)));
        holder.adhar_id.setText(String.valueOf(adhar_id.get(position)));
        holder.address_id.setText(String.valueOf(address_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return f_id.size();
    }


    public class MyViewHolder  extends RecyclerView.ViewHolder  {


        TextView f_id, f_name_id, f_email, f_mobile_id, adhar_id, address_id;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
                f_id=itemView.findViewById(R.id.farmer_id);
                f_name_id=itemView.findViewById(R.id.farmer_name_id);
                f_email=itemView.findViewById(R.id.farmer_email_id);
                f_mobile_id=itemView.findViewById(R.id.farmer_mobile_id);
                adhar_id=itemView.findViewById(R.id.farmer_adhar_id);
                address_id= f_id=itemView.findViewById(R.id.farmer_address_id);
                imageView=itemView.findViewById(R.id.deleteButton_id);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onItemClick(getAdapterPosition());
                    }
                });




         }


    }
}









































//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
//        return  new MyAdapterFarmerDetails.MyViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        holder.labor_id.setText(String.valueOf(labor_id.get(position)));
//        holder.fname_id.setText(String.valueOf(fname_id.get(position)));
//        holder.mobile_id.setText(String.valueOf(mobile_id.get(position)));
//        holder.salary_id.setText(String.valueOf(salary_id.get(position)));
//        holder.JoiningDate_id.setText(String.valueOf(JoiningDate_id.get(position)));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return labor_id.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//
//
//        public MyAdapterFarmerDetails(Context context, ArrayList f_id, ArrayList f_name_id, ArrayList f_email, ArrayList f_mobile_id, ArrayList adhar_id,ArrayList address_id) {
//
//            TextView labor_id,fname_id,mobile_id,salary_id,JoiningDate_id;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//
//                f_id=itemView.findViewById(R.id.labor_id);
//                f_name_id=itemView.findViewById(R.id.Ufname_id);
//                f_email=itemView.findViewById(R.id.Umobile_id);
//                f_mobile_id=itemView.findViewById(R.id.Usalary_id);
//                adhar_id=itemView.findViewById(R.id.Udate_id);
//
//                address_id=
//
//        }
//
//
//
//
//    }
//}

//
//public class MyAdapter extends RecyclerView.Adapter<com.example.agriprovisionelite.Attendance.MyAdapter.MyViewHolder> {
//
//    private final Context context;
//    ArrayList labor_id,fname_id,mobile_id,salary_id,JoiningDate_id;
//
//    public MyAdapter(Context context, ArrayList labor_id, ArrayList fname_id, ArrayList mobile_id, ArrayList salary_id, ArrayList joiningDate_id) {
//        this.context = context;
//        this.labor_id = labor_id;
//        this.fname_id = fname_id;
//        this.mobile_id = mobile_id;
//        this.salary_id = salary_id;
//        this.JoiningDate_id = joiningDate_id;
//    }
//
//    @NonNull
//    @Override
//    public com.example.agriprovisionelite.Attendance.MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
//        return  new com.example.agriprovisionelite.Attendance.MyAdapter.MyViewHolder(v);
//
//
//
//        // return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull com.example.agriprovisionelite.Attendance.MyAdapter.MyViewHolder holder, int position) {
//
//        holder.labor_id.setText(String.valueOf(labor_id.get(position)));
//        holder.fname_id.setText(String.valueOf(fname_id.get(position)));
//        holder.mobile_id.setText(String.valueOf(mobile_id.get(position)));
//        holder.salary_id.setText(String.valueOf(salary_id.get(position)));
//        holder.JoiningDate_id.setText(String.valueOf(JoiningDate_id.get(position)));
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return labor_id.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        TextView labor_id,fname_id,mobile_id,salary_id,JoiningDate_id;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//
//            labor_id=itemView.findViewById(R.id.labor_id);
//            fname_id=itemView.findViewById(R.id.Ufname_id);
//            mobile_id=itemView.findViewById(R.id.Umobile_id);
//            salary_id=itemView.findViewById(R.id.Usalary_id);
//            JoiningDate_id=itemView.findViewById(R.id.Udate_id);
//
//
//
//        }
//
//
//
//
//    }
//}
