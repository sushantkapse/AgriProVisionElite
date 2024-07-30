package com.example.agriprovisionelite.Admin;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;

import java.util.ArrayList;

public class KrishiDetails extends Fragment {


    RecyclerView recyclerView;
    ArrayList<String> farmer_id,farmer_name,farmer_mobile,farmer_email,farmer_adhar,farmer_address;
    MyAdapterKrishiDetails myAdapter;
    DataBase db;
    ImageView delete;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_krishi_details, container, false);




        db=new DataBase(getContext());
        farmer_id=new ArrayList<>();
        farmer_name=new ArrayList<>();
        farmer_mobile=new ArrayList<>();
        farmer_email=new ArrayList<>();
        farmer_adhar=new ArrayList<>();
        farmer_address=new ArrayList<>();


        recyclerView=view.findViewById(R.id.Krishi_datails_recyclerview_id);
        myAdapter=new MyAdapterKrishiDetails(getContext(),farmer_id,farmer_name,farmer_email,farmer_mobile,farmer_adhar,farmer_address);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        displayKrishiOfficer();
        myAdapter.setOnItemClickListener(new MyAdapterKrishiDetails.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                farmer_id.remove(position);
                farmer_name.remove(position);
                farmer_mobile.remove(position);
                farmer_email.remove(position);
                farmer_adhar.remove(position);
                farmer_address.remove(position);
                myAdapter.notifyItemRemoved(position);
            }
        });







        return   view;

    }

    private void displayKrishiOfficer() {

        Cursor cursor=db.get_KrishiOfficer_Details();
        if(cursor.getCount()==0) {
            Toast.makeText(getContext(), "No Entries here", Toast.LENGTH_SHORT).show();
        }
        else {

            while (cursor.moveToNext()){
                farmer_id.add(cursor.getString(0));
                farmer_name.add(cursor.getString(1));
                farmer_email.add(cursor.getString(2));

                farmer_mobile.add(cursor.getString(4));
                farmer_adhar.add(cursor.getString(5));
                farmer_address.add(cursor.getString(6)+"  "+cursor.getString(7)+"  "+cursor.getString(8));
            }
        }
    }

}