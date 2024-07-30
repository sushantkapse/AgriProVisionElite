package com.example.agriprovisionelite.Attendance;

import static android.content.ContentValues.TAG;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;
import com.google.android.material.textview.MaterialTextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AddLaborFragment extends Fragment {

    private Button date,send;
    private TextView textView;
    ImageView imageView;

    EditText fname,lname,mobile,salary;
    AttendaceHome attendaceHome;
    String dateString;
    DatePicker dp;
    DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_add_labor, container, false);

        fname=view.findViewById(R.id.firstname);
        lname=view.findViewById(R.id.lastname);
        mobile=view.findViewById(R.id.phone);
        salary=view.findViewById(R.id.salary);


        textView=view.findViewById(R.id.show_selected_date);
        date=view.findViewById(R.id.pick_date_button);
        imageView=view.findViewById(R.id.backbtn);
        send=view.findViewById(R.id.send);
        attendaceHome= (AttendaceHome) getActivity();
        DataBase db=new DataBase(getContext());





        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog=new DatePickerDialog(getContext(),dateSetListener,year,month,day);
                dialog.show();

            }
        });


        dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG, "onDateSet: "+day+"/"+month +"/"+year);
                dateString=day+"/" +month +"/" +year;
                textView.setText(dateString);
            }
        };














        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                    String salary1=salary.getText().toString();
                    String mobile1=mobile.getText().toString();
                    String lname1=lname.getText().toString();
                    String fname1=fname.getText().toString();

                    if(TextUtils.isEmpty(fname1) || TextUtils.isEmpty(mobile1) || TextUtils.isEmpty(lname1) || TextUtils.isEmpty(salary1) || TextUtils.isEmpty(dateString)   ){

                        Toast.makeText(getActivity(), "please fill all details ", Toast.LENGTH_LONG).show();




                        }
                        else {

                        boolean res =db.insertLaborData(fname1,lname1,mobile1,salary1,dateString);
                        if(res){
                            Toast.makeText(getActivity(), "You register Labor "+fname1+"  "+ " successfully", Toast.LENGTH_LONG).show();
                               }

                        else {
                            Toast.makeText(getActivity(), "details are not stored", Toast.LENGTH_LONG).show();

                        }

                         }









            }
        });





















imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(getActivity(), AttendaceHome.class);
        startActivity(i);
    }
});



























        return view;
    }






}