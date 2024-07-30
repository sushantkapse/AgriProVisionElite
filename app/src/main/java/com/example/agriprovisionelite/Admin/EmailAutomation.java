package com.example.agriprovisionelite.Admin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;

import java.util.ArrayList;
import java.util.List;


public class EmailAutomation extends Fragment {

  EditText subject,body;
  Button send;
    private DataBase dbHelper;
    private List<String> emailList = new  ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DataBase(requireContext());
        fetchEmails();
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_email_automation, container, false);
       subject= view.findViewById(R.id.subjectId);
       body=view.findViewById(R.id.bodyId);
       send=view.findViewById(R.id.sendId);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmails();
            }
        });
       return view;
    }



    private void fetchEmails() {
        Cursor cursor = dbHelper.getAllEmails();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex("fEmail"));
                emailList.add(email);
            } while (cursor.moveToNext());
            cursor.close();
        }
    }

    private void sendEmails() {
        String ab = subject.getText().toString();
        String subject1=ab.toUpperCase();
        String body1 = body.getText().toString();
        StringBuilder emailsBuilder = new StringBuilder();
        for (String email : emailList) {
            emailsBuilder.append(email).append(",");
        }
        String emailsString = emailsBuilder.toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailsString});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject1);
        intent.putExtra(Intent.EXTRA_TEXT, body1);

        startActivity(Intent.createChooser(intent, "Send Email"));
    }
}