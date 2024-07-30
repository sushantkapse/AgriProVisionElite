package com.example.agriprovisionelite.Krishi_Officer.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.Models.BlogDBModel;
import com.example.agriprovisionelite.Models.govSchemeModel;
import com.example.agriprovisionelite.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddGov extends Fragment {


    EditText tileId,desId,docId;
    ImageView imageView;
    Button submitId,ImageId;
    public  static final int PICK_IMAGE_REQUEST=99;
    Uri imagepath;
    Bitmap imageStored;
    String date;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view= inflater.inflate(R.layout.fragment_add_gov, container, false);


        DataBase dataBase=new DataBase(getContext());


        tileId=view.findViewById(R.id.tileId);
        desId=view.findViewById(R.id.desId);
        docId=view.findViewById(R.id.docId);
        submitId=view.findViewById(R.id.submitId);
        imageView=view.findViewById(R.id.imageView5);
        ImageId=view.findViewById(R.id.ImageId);




        ImageId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();



            }
        });



        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy " );
        date  = simpleDateFormat.format(new Date());





        submitId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t1,d1,an1;
                t1=tileId.getText().toString();
                d1=desId.getText().toString();
                an1=docId.getText().toString();
                boolean res=dataBase.storedGovData(new govSchemeModel(t1,an1,d1,imageStored),date);


                if(res){
                    Toast.makeText(requireContext(), "Gov  details save successfully", Toast.LENGTH_LONG).show();



                }
                else {
                    Toast.makeText(requireContext(), " something went wrong ", Toast.LENGTH_LONG).show();

                }

            }
        });














        return  view;

    }

    void openGallery(){
        try {
            Intent intent=new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent,PICK_IMAGE_REQUEST);
        }
        catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        try {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==PICK_IMAGE_REQUEST && resultCode== RESULT_OK && data != null && data.getData()!=null){

                imagepath=data.getData();
                //imageStored= MediaStore.Images.Media.getBitmap(getContentResolver(),imagepath);
                ContentResolver contentResolver = requireContext().getContentResolver();
                imageStored = MediaStore.Images.Media.getBitmap(contentResolver, imagepath);



                imageView.setImageBitmap(imageStored);
                imageView.setVisibility(View.VISIBLE);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}


