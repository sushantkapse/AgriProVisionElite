package com.example.agriprovisionelite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.example.agriprovisionelite.Admin.A_Login;
import com.example.agriprovisionelite.Admin.AdminDashBoard;
import com.example.agriprovisionelite.Admin.FarmerDetails;
import com.example.agriprovisionelite.Attendance.AttendaceHome;
import com.example.agriprovisionelite.Farmer.Farmer_DashBoard;
import com.example.agriprovisionelite.Farmer.LoginActivity;
import com.example.agriprovisionelite.Farmer.UserRegister;
import com.example.agriprovisionelite.Farmer.Video_calling;

import com.example.agriprovisionelite.Krishi_Officer.K_Login;
import com.example.agriprovisionelite.Krishi_Officer.K_Register;
import com.example.agriprovisionelite.Krishi_Officer.Officer_DashBoard;
import com.example.agriprovisionelite.comman.News2;
import com.example.agriprovisionelite.comman.PlantDisease;
import com.example.agriprovisionelite.comman.Wheather;
import com.example.agriprovisionelite.comman.feedback;


public class MainActivity extends AppCompatActivity {
    private final String CHANNEL_ID="Notification";
    private final  int NOTIFICATION_ID=1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        Button feedbck,admin,farmerR,farmerL,KR,KL,news,wheather,ml,attendance,call,allFarmer,dash,b1;
        feedbck=findViewById(R.id.feedback);
        admin=findViewById(R.id.Admin);
        farmerR=findViewById(R.id.FarmerR);
        farmerL=findViewById(R.id.FarmerL);
        KR=findViewById(R.id.officerR);
        KL=findViewById(R.id.officerL);
        news=findViewById(R.id.ne);
        wheather=findViewById(R.id.whether);
        ml=findViewById(R.id.ml);
        attendance=findViewById(R.id.attendance);
        call=findViewById(R.id.call);
        allFarmer=findViewById(R.id.allFarmer);
        dash=findViewById(R.id.dash);





        farmerL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);

            }
        });
        farmerR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, UserRegister.class);
                startActivity(i);

            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, A_Login.class);
                startActivity(i);

            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, News2.class);
                startActivity(i);

            }
        });
        KR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, K_Register.class);
                startActivity(i);

            }
        });
        KL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, K_Login.class);
                startActivity(i);

            }
        });
        feedbck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, feedback.class);
                startActivity(i);

            }
        });


        wheather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, Wheather.class);
                startActivity(i);

            }
        });
        ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, PlantDisease.class);
                startActivity(i);

            }
        });



attendance.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i =new Intent(MainActivity.this, AttendaceHome.class);
        startActivity(i);

    }
});


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this, Video_calling.class);
                startActivity(i);

            }
        });



        allFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this, AdminDashBoard.class);
                startActivity(i);


            }
        });

        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this, adminDrawer.class);
                startActivity(i);


            }
        });





    }





}