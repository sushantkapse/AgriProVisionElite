package com.example.agriprovisionelite.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.agriprovisionelite.Attendance.AttendaceHome;
import com.example.agriprovisionelite.Crop.AddCrop;
import com.example.agriprovisionelite.MainActivity;
import com.example.agriprovisionelite.R;
import com.example.agriprovisionelite.comman.News2;
import com.example.agriprovisionelite.comman.PlantDisease;
import com.example.agriprovisionelite.comman.Wheather;
import com.example.agriprovisionelite.comman.feedback;
import com.example.agriprovisionelite.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView clothingName,elecName,homeName,beautyName,pharmName,grocName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
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
                    Intent i = new Intent(requireActivity(), AddCrop.class);
                    startActivity(i);
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













        // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
