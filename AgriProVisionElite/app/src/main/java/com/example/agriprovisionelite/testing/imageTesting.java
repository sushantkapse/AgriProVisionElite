package com.example.agriprovisionelite.testing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.ModalClass;
import com.example.agriprovisionelite.R;
import  android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.MediaStore;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class imageTesting extends AppCompatActivity {


    ImageView profileImage;
    Button b;
    public static final int PICK_IMAGE_REQUEST=99;
    private Uri imagepath;
    private  Bitmap imageToStore;
    String currentDate;
    EditText title,Description,Eligibility,Documents;

    DataBase db;
Button publish;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_testing);


        profileImage=findViewById(R.id.Profile_image);
        title=findViewById(R.id.title12);
        Description=findViewById(R.id.Description);
        Eligibility=findViewById(R.id.Eligibility);
        Documents=findViewById(R.id.Documents);
        publish=findViewById(R.id.publish);
         currentDate = getCurrentDate();

db=new DataBase(this);





        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });



        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
storeImage();
            }
        });







    }












    public  void chooseImage(){
        try {

            Intent i=new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(i,PICK_IMAGE_REQUEST);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        try {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data == null && data.getData()==null){
                  imagepath=data.getData();
                imageToStore=MediaStore.Images.Media.getBitmap(getContentResolver(),imagepath);
profileImage.setImageBitmap(imageToStore);

            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }










    private String getCurrentDate() {
        // Using Calendar class
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(calendar.getTime());


    }



    private  void storeImage(){
     boolean res = db.storeData(new ModalClass(title.getText().toString(),Description.getText().toString(),Eligibility.getText().toString(),Documents.getText().toString(),imageToStore),currentDate);
        if(res){
            Toast.makeText(getApplicationContext(), "register details save successfully", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(getApplicationContext(), "not register something went wrong ", Toast.LENGTH_LONG).show();

        }


    }









}