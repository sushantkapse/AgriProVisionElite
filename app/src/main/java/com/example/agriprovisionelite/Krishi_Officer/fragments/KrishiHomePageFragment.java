package com.example.agriprovisionelite.Krishi_Officer.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.agriprovisionelite.Attendance.AttendaceHome;
import com.example.agriprovisionelite.MainActivity;
import com.example.agriprovisionelite.R;
import com.example.agriprovisionelite.comman.News2;
import com.example.agriprovisionelite.comman.PlantDisease;
import com.example.agriprovisionelite.comman.Wheather;
import com.example.agriprovisionelite.comman.feedback;
import com.example.agriprovisionelite.ui.gallery.GalleryFragment;


public class KrishiHomePageFragment extends Fragment {

    private TextView clothingName,elecName,homeName,beautyName,pharmName,grocName;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  root= inflater.inflate(R.layout.fragment_krishi_home_page, container, false);




        clothingName = root.findViewById(R.id.clothingName);
        elecName=root.findViewById(R.id.elecName);
        homeName=root.findViewById(R.id.homeName);
        beautyName=root.findViewById(R.id.beautyName);
        grocName=root.findViewById(R.id.grocName);
        pharmName=root.findViewById(R.id.pharmName);






        clothingName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the fragment is attached to the activity
                if (isAdded() && requireActivity() != null) {
                    GalleryFragment galleryFragment=new GalleryFragment();
                    FragmentManager fragmentManager=getFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerFragment,galleryFragment);
                    fragmentTransaction.commit();




                }
            }
        });

        elecName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the fragment is attached to the activity
                if (isAdded() && requireActivity() != null) {
                    Intent i = new Intent(requireActivity(), AttendaceHome.class);
                    startActivity(i);
                }
            }
        });


        homeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the fragment is attached to the activity
                if (isAdded() && requireActivity() != null) {
                    Intent i = new Intent(requireActivity(), News2.class);
                    startActivity(i);
                }
            }
        });
        beautyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the fragment is attached to the activity
                if (isAdded() && requireActivity() != null) {
                    Intent i = new Intent(requireActivity(), PlantDisease.class);
                    startActivity(i);
                }
            }
        });

        grocName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the fragment is attached to the activity
                if (isAdded() && requireActivity() != null) {
                    Intent i = new Intent(requireActivity(), feedback.class);
                    startActivity(i);
                }
            }
        });

        pharmName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the fragment is attached to the activity
                if (isAdded() && requireActivity() != null) {
                    Intent i = new Intent(requireActivity(), Wheather.class);
                    startActivity(i);
                }
            }
        });







        return  root;

    }
}