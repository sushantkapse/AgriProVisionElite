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

public class MyAdapterKrishiDetails extends  RecyclerView.Adapter<MyAdapterKrishiDetails.MyViewHolder> {
    private final Context context;
    //public  boolean insertFarmerData (String name ,String email, String password,String mobile,String adhar,String state, String dist ,String tal){

    ArrayList f_id, f_name_id, f_email, f_mobile_id, adhar_id, address_id;



    //boomrilo

    private MyAdapterKrishiDetails.OnItemClickListener listener;


    public  interface OnItemClickListener{
        void onItemClick(int position);
    }

    public  void setOnItemClickListener(MyAdapterKrishiDetails.OnItemClickListener onItemClickListener){

        listener=onItemClickListener;
    }




    public MyAdapterKrishiDetails(Context context, ArrayList f_id, ArrayList f_name_id, ArrayList f_email, ArrayList f_mobile_id, ArrayList adhar_id, ArrayList address_id) {
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
    public MyAdapterKrishiDetails.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.krishi_officer_details_entries,parent,false);
        return  new MyAdapterKrishiDetails.MyViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterKrishiDetails.MyViewHolder holder, int position) {
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
        public MyViewHolder(@NonNull View itemView, MyAdapterKrishiDetails.OnItemClickListener listener) {
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








