package com.example.agriprovisionelite.Attendance;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;

import java.util.Calendar;

public class MarkAttendance extends AppCompatActivity {
    Button mark,check;
    CheckBox ch;
    EditText id;
    TextView name,mobile;
    String id1;
    String name12;

    DataBase db;
    DatePickerDialog.OnDateSetListener dateSetListener;

    String dateString;
    Button date;
    TextView setDate;
    String st;
    String mobile1;
boolean Status=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendance);
        mark=findViewById(R.id.markButton);
        ch=findViewById(R.id.checkboxid);
        id=findViewById(R.id.editId);
        name=findViewById(R.id.editName);
        check=findViewById(R.id.checkButton);
        date=findViewById(R.id.date_button);
        setDate=findViewById(R.id.selected_date);
       mobile=findViewById(R.id.editName1);


        db=new DataBase(this);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(MarkAttendance.this,dateSetListener,year,month,day);
                dialog.show();

            }
        });


        dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG, "onDateSet: "+day+"/"+month +"/"+year);
                dateString=day+"/" +month +"/" +year;
                setDate.setText(dateString);
            }
        };


















        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id1=id.getText().toString();


                Cursor cursor=db.getLaborDetailsUsingId(id1);
                if(cursor.getCount()==0) {
                    Toast.makeText(getApplicationContext(), "No Entries here", Toast.LENGTH_SHORT).show();

                }



                else {

                    while (cursor.moveToNext()) {
                         name12 = cursor.getString(1) + " \t" + cursor.getString(2);
                         mobile1=cursor.getString(3);
                      String c=   name12.toUpperCase();
                         name.setText(c);
                         mobile.setText(mobile1);

                    }
                }

            }
        });



        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if the CheckBox is checked
                if (ch.isChecked()) {
                    // CheckBox is checked
                    Toast.makeText(getApplicationContext(), "CheckBox is checked", Toast.LENGTH_SHORT).show();
                    Status= true;
                    st="Present";


                } else {
                    // CheckBox is not checked
                    Toast.makeText(getApplicationContext(), "CheckBox is not checked", Toast.LENGTH_SHORT).show();
                    Status =false;
                    st="Absent";
                }
            }
        });


        mark.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View view) {

                boolean res =db.insertLaborAttendaceData(id1,dateString, Status);
                if(res){
                    Toast.makeText(MarkAttendance.this, "You Mark Attendance  successfully", Toast.LENGTH_LONG).show();


                }

                else {
                    Toast.makeText(MarkAttendance.this, "Something went wrong", Toast.LENGTH_LONG).show();

                }

            }
        });













    }
}