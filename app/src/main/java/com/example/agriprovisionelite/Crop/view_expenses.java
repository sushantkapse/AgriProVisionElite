package com.example.agriprovisionelite.Crop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;

import java.util.ArrayList;

public class view_expenses extends AppCompatActivity {

    DataBase dbHelper;

    RecyclerView recyclerView;
    Expenses_Adapter expensesAdapter;
    ArrayList<String> expense_id,activity,amount,date;
    int id;
    String inputText;
    EditText editTextCropID,editTextCropName,editTextSowingDate;
    Button btn_add_more_expense;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_expenses);


        dbHelper = new DataBase(this);
        expense_id = new ArrayList<>();
        activity = new ArrayList<>();
        amount = new ArrayList<>();
        date = new ArrayList<>();

        editTextCropID = findViewById(R.id.editTextCropID);
        editTextCropName = findViewById(R.id.editTextCropName);
        editTextSowingDate = findViewById(R.id.editTextSowingDate);


        Intent intent = getIntent();
        if (intent != null) {
            String cropName = intent.getStringExtra("c_name");
            String sowingDate = intent.getStringExtra("c_sowing_date");
            String id = intent.getStringExtra("c_id");

            // Set the retrieved data to EditText fields
            if (cropName != null) {
                editTextCropName.setText(cropName);
            }
            if (sowingDate != null) {
                editTextSowingDate.setText(sowingDate);
            }
            if (id != null) {
                editTextCropID.setText(id);
            }
        }

        inputText = editTextCropID.getText().toString();

        recyclerView = findViewById(R.id.rv_expense);
        expensesAdapter = new Expenses_Adapter(this,expense_id,activity,amount,date);
        recyclerView.setAdapter(expensesAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false
        ));
//        display();
            display_id();

    }

    private void display() {


        Cursor cursor = dbHelper.getExpenses();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No Entries here", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                expense_id.add(cursor.getString(0));
                activity.add(cursor.getString(2));
                amount.add(cursor.getString(3));
                date.add(cursor.getString(4));





            }
        }

        cursor.close();





    }

    private void display_id() {


        Cursor cursor = dbHelper.getExpenses_crop(inputText);
        if (cursor.getCount()==0){
            Toast.makeText(this, "No Entries here", Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()){
                expense_id.add(cursor.getString(0));
                activity.add(cursor.getString(2));
                amount.add(cursor.getString(3));
                date.add(cursor.getString(4));





            }
        }

        cursor.close();





    }
}