package com.example.agriprovisionelite.ui.gallery;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriprovisionelite.Attendance.MyAdapter;
import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;
import com.example.agriprovisionelite.databinding.FragmentGalleryBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GalleryFragment extends Fragment {
    RecyclerView recyclerView;
    DataBase db;
    BlogAdapter myAdapter;
    Bitmap bitmap;

    private FragmentGalleryBinding binding;

    ArrayList<String> tileIds = new ArrayList<>();
    ArrayList<String> descriptionIds = new ArrayList<>();
    ArrayList<String> authorIds = new ArrayList<>();
    ArrayList<Bitmap> blogImages = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.Blog_recycler_view);
        db = new DataBase(getContext());
        myAdapter = new BlogAdapter(getContext(), tileIds, descriptionIds, authorIds,blogImages);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        displayBlog();

        return root;
    }

    private void displayBlog() {
        Cursor cursor = db.getBlogDetails();
        if (cursor.moveToFirst()) {
            do {
                tileIds.add(cursor.getString(2));
                authorIds.add(cursor.getString(3));
                descriptionIds.add(cursor.getString(4));

                byte[] imageByte = cursor.getBlob(5);
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














