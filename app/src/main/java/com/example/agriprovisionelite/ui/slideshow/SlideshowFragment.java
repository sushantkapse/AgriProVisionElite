package com.example.agriprovisionelite.ui.slideshow;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;
import com.example.agriprovisionelite.databinding.FragmentSlideshowBinding;
import com.example.agriprovisionelite.ui.gallery.BlogAdapter;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {
    RecyclerView recyclerView;
    DataBase db;
    GovAdapter myAdapter;
    Bitmap bitmap;
    private FragmentSlideshowBinding binding;

    ArrayList<String> tileIds = new ArrayList<>();
    ArrayList<String> descriptionIds = new ArrayList<>();
    ArrayList<String> documents = new ArrayList<>();
    ArrayList<String> date = new ArrayList<>();

    ArrayList<Bitmap> blogImages = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        recyclerView = root.findViewById(R.id.Gov_recycler_view);
        db = new DataBase(getContext());
        myAdapter = new GovAdapter(getContext(), tileIds, descriptionIds, documents,blogImages,date);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        displayScheme();













        return root;
    }

    private void displayScheme() {
        Cursor cursor = db.getGovDetails();
        if (cursor.moveToFirst()) {
            do {
                tileIds.add(cursor.getString(2));
                descriptionIds.add(cursor.getString(4));

                documents.add(cursor.getString(3));
                date.add(cursor.getString(5));

                byte[] imageByte = cursor.getBlob(6);
                if (imageByte != null) {
                    bitmap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);
                    blogImages.add(bitmap);
                }
            } while (cursor.moveToNext());
        } else {
            Toast.makeText(getContext(), "No Entries here", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}