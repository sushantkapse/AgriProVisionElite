package com.example.agriprovisionelite.Crop;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;

import java.util.Calendar;

public class AddCrop extends AppCompatActivity {

    private EditText editTextCropName, editTextCropId, editTextSowingDate, editTextArea, editTextDuration;
    NumberPicker numberPickerArea;
//    private CropDBHelper dbHelper;
    DataBase dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_crop);




        editTextCropName = findViewById(R.id.editTextCropName);
        editTextSowingDate = findViewById(R.id.editTextSowingDate);
        editTextArea = findViewById(R.id.editTextArea);
        editTextDuration = findViewById(R.id.editTextDuration);
        dbHelper = new DataBase(this);



        Button buttonAddCrop = findViewById(R.id.buttonAddCrop);
        buttonAddCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddCrop.this, "okk", Toast.LENGTH_SHORT).show();
                addCropToDatabase();

            }
        });

        Button buttonViewCrops = findViewById(R.id.buttonViewCrops);

        buttonViewCrops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddCrop.this, view_crop.class));
            }
        });

        editTextSowingDate.setOnClickListener(view -> {
//

//
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view1, selectedYear, selectedMonth, selectedDay) -> {
//                        ye call hoga kab jab ham date ko pick kar lenge
                editTextSowingDate.setText(selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear);
//                Toast.makeText(this, "year: " + selectedYear + " month: " + selectedMonth + " day : " + selectedDay, Toast.LENGTH_SHORT).show();

            }, year, month, day);

            datePickerDialog.show();
        });


    }

    private void addCropToDatabase() {

        String crop_name=editTextCropName.getText().toString();
        String crop_sowing_date=editTextSowingDate.getText().toString();
        String crop_area=editTextArea.getText().toString();
        String crop_duration=editTextDuration.getText().toString();

        if(crop_name.isEmpty() || crop_sowing_date.isEmpty() || crop_area.isEmpty() || crop_duration.isEmpty()  ){

            Toast.makeText(AddCrop.this, "please fill all details ", Toast.LENGTH_LONG).show();




        }
        else {

            boolean res = dbHelper.addcrop(crop_name,crop_sowing_date,crop_area,crop_duration);
            if(res){
                Toast.makeText(AddCrop.this, "You register Crop "+ crop_name +"  "+ " successfully", Toast.LENGTH_LONG).show();
            }


            else {
                Toast.makeText(AddCrop.this, "details are not stored", Toast.LENGTH_LONG).show();

            }

        }







    }

    private void clearFields() {
        editTextCropName.setText("");
        editTextCropId.setText("");
        editTextSowingDate.setText("");
        editTextArea.setText("");
        editTextDuration.setText("");
    }
}