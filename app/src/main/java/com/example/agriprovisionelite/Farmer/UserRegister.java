package com.example.agriprovisionelite.Farmer;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.ModalClass;
import com.example.agriprovisionelite.R;
import com.example.agriprovisionelite.farmerRegisterModel;

public class UserRegister extends AppCompatActivity {
    String state,dist,tal;
    Spinner genderSpinner;
    Spinner district;
    Spinner taluka;

    Button register;

    private AwesomeValidation awesomeValidation;
    private static final String CHANNEL_ID = "MyNotificationChannel";
    private static final int NOTIFICATION_ID = 1;



    private farmerRegisterModel model;

    EditText fname,femail,fpass,Frepass,fmob,Fadhar;
TextView already_signinbtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

         fname=findViewById(R.id.Fname);
         femail=findViewById(R.id.FEmail);
         fpass=findViewById(R.id.FPassword);
         Frepass=findViewById(R.id.FRepassword);
         fmob=findViewById(R.id.Fmobile);
         Fadhar=findViewById(R.id.FAdhar);
        register= findViewById(R.id.registerBtn);

        already_signinbtn1=findViewById(R.id.already_signinbtn1);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        DataBase db=new DataBase(this);


//        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
   //String adharRegex="[0-9]{4}-[0-9]{4}-[0-9]{4}";
//        awesomeValidation.addValidation(this, R.id.Fname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
//        awesomeValidation.addValidation(this, R.id.FEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
//        awesomeValidation.addValidation(this, R.id.Fmobile, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
//        awesomeValidation.addValidation(this, R.id.FPassword, regexPassword, R.string.passworderror);
    //awesomeValidation.addValidation(this, R.id.FAdhar, adharRegex, Integer.parseInt("Enter a valid Aadhaar number"));


        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.Fname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.FEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.Fmobile, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.FPassword, regexPassword, R.string.passworderror);








        //----------------------------------------validation done----------------------




        //--------------  state----------------
        genderSpinner = findViewById(R.id.genderSpinner);

        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.state_array,
                android.R.layout.simple_spinner_item);

        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genderSpinner.setAdapter(genderAdapter);


        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Retrieve the selected item
                state = parentView.getItemAtPosition(position).toString();
                Toast.makeText(UserRegister.this,state,Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(UserRegister.this,"you have to select state",Toast.LENGTH_SHORT).show();
            }
        });




        //-------------- district--------



        district = findViewById(R.id.dist);
        ArrayAdapter<CharSequence> DistAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.dist_array,
                android.R.layout.simple_spinner_item);

        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        district.setAdapter(DistAdapter);


        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Retrieve the selected item
                dist = parentView.getItemAtPosition(position).toString();

                // Toast.makeText(UserRegister.this,dist,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(UserRegister.this, "you have to select district", Toast.LENGTH_SHORT).show();
            }
        });





        //--------------- taluka----------


        taluka = findViewById(R.id.tal);
        ArrayAdapter<CharSequence> talAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.taluka_array,
                android.R.layout.simple_spinner_item);

        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        taluka.setAdapter(talAdapter);


        taluka.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Retrieve the selected item
                tal = parentView.getItemAtPosition(position).toString();

                // Toast.makeText(UserRegister.this,dist,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(UserRegister.this, "you have to select taluka", Toast.LENGTH_SHORT).show();
            }
        });












  //      -----------------------------------------------regiister button-----------------------------





        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (awesomeValidation.validate()) {

                    String repassword=Frepass.getText().toString();
                    String password=fpass.getText().toString();
                    String mobile1=fmob.getText().toString();
                    String email1=femail.getText().toString();
                    String username1=fname.getText().toString();
                    String adhar=Fadhar.getText().toString();

                    if(repassword.equals(password) ){
                         model=new farmerRegisterModel(username1,email1,password,mobile1,adhar,state,dist,tal);


                        //boolean res =db.insertFarmerData(username1,email1,password,mobile1,adhar,state,dist,tal);
                        boolean res1=db.insertFarmerData1(model);

                        if(res1)
                        {
                            Toast.makeText(getApplicationContext(), "register details save successfully", Toast.LENGTH_LONG).show();
                            showNotification();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "not register something went wrong ", Toast.LENGTH_LONG).show();

                        }



                    }



                }

                else {
                    Toast.makeText(getApplicationContext(),"password does not match",Toast.LENGTH_LONG).show();
                }
            }
        });



        createNotificationChannel();



        already_signinbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(UserRegister.this, LoginActivity.class);
                startActivity(i);
            }
        });


    }







    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Congratulations!";
            String description = " You've successfully Register in.\n  Enjoy your experience!";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                channel = new NotificationChannel(CHANNEL_ID, name, importance);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                channel.setDescription(description);
            }

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo12)
                .setContentTitle("Congratulations!")
                .setContentText("YYou've successfully register in.\n  Enjoy your experience!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }











}