package com.example.agriprovisionelite.Attendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;

import java.util.ArrayList;

public class AttendaceHome extends AppCompatActivity {

RecyclerView recyclerView;
ArrayList <String> laborid,name,mobile,salary,date;
MyAdapter myAdapter;
Button mark, checkAttendance;


DataBase db;
    ImageView add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendace_home);
        add=findViewById(R.id.add12);
        mark=findViewById(R.id.mark);
        checkAttendance=findViewById(R.id.checkAttendance);
        db=new DataBase(this);
        laborid=new ArrayList<>();
        name=new ArrayList<>();
        mobile=new ArrayList<>();
        salary=new ArrayList<>();
        date=new ArrayList<>();
        recyclerView=findViewById(R.id.recycler_view);
        myAdapter=new MyAdapter(this,laborid,name,mobile,salary,date);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayLabor();



        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(AttendaceHome.this, MarkAttendance.class);
                startActivity(i);
            }
        });

        checkAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(AttendaceHome.this, CheckAttendance.class);
                startActivity(i);
            }
        });



        AddLaborFragment addLaborFragment=new AddLaborFragment();

add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerId,addLaborFragment).commit();


    }
});


    }

//    private void displayLabor() {
//
//        Cursor cursor=db.getLaborDetails();
//        if(cursor.getCount()==0) {
//            Toast.makeText(getApplicationContext(), "No Entries here", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        else {
//
//            while (cursor.moveToNext()){
//                laborid.add(cursor.getString(0));
//                name.add(cursor.getString(1)+ ""+ cursor.getString(2));
//                mobile.add(cursor.getString(3));
//                salary.add(cursor.getString(4));
//                date.add(cursor.getString(5));
//            }
//
//        }
//    }



    private void displayLabor() {

        Cursor cursor=db.getLaborDetails();
        if(cursor.getCount()==0) {
            Toast.makeText(getApplicationContext(), "No Entries here", Toast.LENGTH_SHORT).show();

        }
        else {
            while (cursor.moveToNext()){
                laborid.add(cursor.getString(0));
                name.add(cursor.getString(1)+ ""+ cursor.getString(2));
                mobile.add(cursor.getString(3));
                salary.add(cursor.getString(4));
                date.add(cursor.getString(5));
            }

        }
    }
}