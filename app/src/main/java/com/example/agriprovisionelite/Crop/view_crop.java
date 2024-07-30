package com.example.agriprovisionelite.Crop;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;

import java.util.ArrayList;

public class view_crop extends AppCompatActivity {

    DataBase dbHelper;

    RecyclerView recyclerView;
    Crop_Adapter cropAdapter;
    ArrayList <String> crop_id,c_name,c_sowing_date,c_area,c_duration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_crop);


        dbHelper = new DataBase(this);
        c_name = new ArrayList<>();
        crop_id = new ArrayList<>();
        c_sowing_date = new ArrayList<>();
        c_area = new ArrayList<>();
        c_duration = new ArrayList<>();




        recyclerView = findViewById(R.id.rv_crops);
        cropAdapter = new Crop_Adapter(this,crop_id,c_name,c_sowing_date,c_area,c_duration);
        recyclerView.setAdapter(cropAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false
        ));
        display();

    }

    private void display() {


       Cursor cursor = dbHelper.getCrop();
       if (cursor.getCount()==0){
           Toast.makeText(this, "No Entries here", Toast.LENGTH_SHORT).show();
       }
       else {
           while (cursor.moveToNext()){
               crop_id.add(cursor.getString(0));
               c_name.add(cursor.getString(1));
               c_sowing_date.add(cursor.getString(2));
               c_area.add(cursor.getString(3));
               c_duration.add(cursor.getString(4));




           }
       }

        cursor.close();





    }


}