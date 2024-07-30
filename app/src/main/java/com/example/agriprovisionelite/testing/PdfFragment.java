package com.example.agriprovisionelite.testing;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;
import java.io.IOException;

public class PdfFragment extends Fragment {

    private DataBase dbHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DataBase(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pdf, container, false);

        view.findViewById(R.id.downloadPdfButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generatePdf();
            }
        });

        return view;
    }

    private void generatePdf() {
        Cursor cursor = dbHelper.get_Farmer_Details();
        StringBuilder builder = new StringBuilder();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("fName"));
                @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex("fEmail"));
                @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex("fMobile"));
                builder.append("Name: ").append(name).append("\n");
                builder.append("Email: ").append(email).append("\n");
                builder.append("Phone: ").append(phone).append("\n\n");
            } while (cursor.moveToNext());
            cursor.close();
        }

        // Generate PDF with farmer details
        try {
            PdfGenerator.generatePdf(requireContext(), "farmer_details.pdf", builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}