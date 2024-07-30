package com.example.agriprovisionelite.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
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
import com.example.agriprovisionelite.MainActivity;
import com.example.agriprovisionelite.R;

public class A_Login extends AppCompatActivity {

    Button loginButton ;
    TextView alreadySignup;
    TextView tv;
    private static final String CHANNEL_ID = "MyNotificationChannel";
    private static final int NOTIFICATION_ID = 1;
    private AwesomeValidation awesomeValidation;
    EditText email,pass;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alogin);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        loginButton = findViewById(R.id.A_loginbtn);


         email = findViewById(R.id.Aemail);
         pass = findViewById(R.id.Apassword);

        awesomeValidation.addValidation(this, R.id.Aemail, Patterns.EMAIL_ADDRESS, R.string.emailerror);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString();
                String pass1 = pass.getText().toString();


                //    -----------------------database part-----------------------
                if (awesomeValidation.validate()) {
                    if(email1.equals("Admin@gmail.com") && pass1.equals("Admin@1234")){

                        Toast.makeText(getApplicationContext(), "login  done", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(A_Login.this, MainActivity.class);
                        startActivity(i);


                    showNotification();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "not done", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(A_Login.this,MainActivity.class);
                        startActivity(i);

                    }

                }
            }
        });









        createNotificationChannel();

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
