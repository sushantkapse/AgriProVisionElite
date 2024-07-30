package com.example.agriprovisionelite.Crop;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;

import java.util.Calendar;


public class Add_Expenses extends AppCompatActivity {
    Spinner spinner;
    EditText editTextCropName,editTextSowingDate,editTextCropArea,spinnertext,amount,pick_date_button,c_id;
    String c_id1;
    TextView date_label;
    Button btn_add_expenses;
    Button a;
    String[] activities = {"Sowing","cutting","Harvesting","Irrigation","weeding","storage","manuaring","Other"};
    DataBase dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenses);




        editTextCropArea = findViewById(R.id.editTextCropArea);
        editTextCropName = findViewById(R.id.editTextCropName);
        editTextSowingDate = findViewById(R.id.editTextSowingDate);
        c_id = findViewById(R.id.c_id);
        spinnertext = findViewById(R.id.spinnertext);
        amount = findViewById(R.id.amount);
        date_label = findViewById(R.id.date_label);
        pick_date_button = findViewById(R.id.pick_date_button);

       btn_add_expenses = findViewById(R.id.btn_add_expenses);
//       view_expenses = findViewById(R.id.view_expenses);

        spinner = findViewById(R.id.spinnerExpenseType);
        dbHelper = new DataBase(this);


        Intent intent = getIntent();
        if (intent != null) {
            String cropName = intent.getStringExtra("c_name");
            String sowingDate = intent.getStringExtra("c_sowing_date");
            String area = intent.getStringExtra("c_area");
            String C_ID = intent.getStringExtra("crop_id");


            // Set the retrieved data to EditText fields
            if (cropName != null) {
                editTextCropName.setText(cropName);
            }
            if (sowingDate != null) {
                editTextSowingDate.setText(sowingDate);
            }
            if (area != null) {
                editTextCropArea.setText(area);
            } if (C_ID != null) {
                c_id.setText(C_ID);
            }
        }






        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(Add_Expenses.this, android.R.layout.simple_spinner_item,activities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Retrieve the selected item
                String value = parentView.getItemAtPosition(position).toString();
//                Toast.makeText(Add_Expenses.this,value,Toast.LENGTH_SHORT).show();
            spinnertext.setText(value);



            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(Add_Expenses.this,"you have to select service type",Toast.LENGTH_SHORT).show();
            }
        });


        pick_date_button.setOnClickListener(view -> {
//            code ...
//            Toast.makeText(this, "selecting date", Toast.LENGTH_SHORT).show();
//            show the date picker

//            ye hamne year month aur date ko nikala hai
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view1, selectedYear, selectedMonth, selectedDay) -> {
//                        ye call hoga kab jab ham date ko pick kar lenge
                pick_date_button.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
                Toast.makeText(this, "year: " + selectedYear + " month: " + selectedMonth + " day : " + selectedDay, Toast.LENGTH_SHORT).show();

            }, year, month, day);

            datePickerDialog.show();
        });

        btn_add_expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expensesToDatabase();
//                startActivity(new Intent(Add_Expenses.this, view_expenses.class));
            }
        });

        a = findViewById(R.id.btn_a);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Add_Expenses.this, view_expenses.class);
                intent1.putExtra("c_name", editTextCropName.getText().toString());
                intent1.putExtra("c_sowing_date", editTextSowingDate.getText().toString());
                intent1.putExtra("c_id", c_id.getText().toString());
                startActivity(intent1);
            }
        });













    }

    private void expensesToDatabase() {

        String crop_id=c_id.getText().toString();
        String activity=spinnertext.getText().toString();
        String activity_amount=amount.getText().toString();
        String e_date=pick_date_button.getText().toString();

        if(crop_id.isEmpty() || activity.isEmpty() || activity_amount.isEmpty() || e_date.isEmpty()  ){

            Toast.makeText(Add_Expenses.this, "please fill all details ", Toast.LENGTH_LONG).show();




        }
        else {

            boolean res = dbHelper.addExpense(crop_id,activity,activity_amount,e_date);
            if(res){
                Toast.makeText(Add_Expenses.this, " Expenses add successfully", Toast.LENGTH_LONG).show();
            }


            else {
                Toast.makeText(Add_Expenses.this, "details are not stored", Toast.LENGTH_LONG).show();

            }

        }




    }
}