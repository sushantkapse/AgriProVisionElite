package com.example.agriprovisionelite.Farmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.agriprovisionelite.DataBase;
import com.example.agriprovisionelite.R;

public class LoginActivity extends AppCompatActivity {


    Button requestButton ,feedButton;
    TextView alreadySignup;
    TextView tv;
    private static final String CHANNEL_ID = "MyNotificationChannel";
    private static final int NOTIFICATION_ID = 1;
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
DataBase db=new DataBase(this);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        requestButton = findViewById(R.id.loginbtn);
        alreadySignup = findViewById(R.id.already_signup);
        //tv = findViewById(R.id.abc);

        EditText email = findViewById(R.id.email);
        EditText pass = findViewById(R.id.password);

        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.emailerror);




        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString();
                String pass1 = pass.getText().toString();

                if (awesomeValidation.validate()) {
                    Cursor c = db.get_Farmer_Details();
                    boolean found = false;

                    while (c.moveToNext()) {
                        String em = c.getString(2);
                        String pa = c.getString(3);

                        if (email1.equals(em) && pass1.equals(pa)) {
                            found = true;
                            break;
                        }
                    }

                    if (found) {


                        Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
                        Intent i=new Intent(LoginActivity.this,Farmer_DashBoard.class);
                        //showNotification();
                        startActivity(i);


                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
                        //tv.setText(email1 + " " + pass1);
                    }
                }
            }
        });


        alreadySignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this, UserRegister.class);
                startActivity(i);
            }
        });











      //  createNotificationChannel();

    }




    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Congratulations!";
            String description = " You've successfully logged in.\n  Enjoy your experience!";
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
                .setContentText("YYou've successfully logged in.\n  Enjoy your experience!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }











}