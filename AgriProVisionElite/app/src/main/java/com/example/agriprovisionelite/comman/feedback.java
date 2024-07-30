package com.example.agriprovisionelite.comman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agriprovisionelite.R;

public class feedback extends AppCompatActivity {

    TextView tvFeedback;
    EditText name,feed;
    Button b1;
    RatingBar rbStars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        tvFeedback = findViewById(R.id.tvFeedback);
        rbStars = findViewById(R.id.rbStars);
        name=findViewById(R.id.name);
        feed=findViewById(R.id.feed);
        b1=findViewById(R.id.btnSend);



        StringBuffer bf=new StringBuffer();


        //UserDatabase db=new UserDatabase(this);

        rbStars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            // String rating=String.valueOf(rbStars.getRating());
            @Override

            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating==0)
                {
                    tvFeedback.setText("Very Dissatisfied");
                    bf.append("Very Dissatisfied");
                }
                else if(rating==1)
                {
                    tvFeedback.setText("Dissatisfied");
                    bf.append("Dissatisfied");
                }
                else if(rating==2 || rating==3)
                {
                    tvFeedback.setText("OK");
                    bf.append("OK");
                }
                else if(rating==4)
                {
                    tvFeedback.setText("Satisfied");
                    bf.append("Satisfied");
                }
                else if(rating==5)
                {
                    tvFeedback.setText("Very Satisfied");
                    bf.append("Very Satisfied");

                }
                else
                {


                }
            }









        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1=name.getText().toString();
                String suggetion=feed.getText().toString();
//                boolean res= db.insertFeedbackData(name1,bf.toString(),suggetion);
//
//                if(res==true){
//                    Toast.makeText(getApplicationContext(), " details save successfully", Toast.LENGTH_LONG).show();
//
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), " something went wrong ", Toast.LENGTH_LONG).show();
//
//                }
                   Toast.makeText(getApplicationContext(), " details save successfully", Toast.LENGTH_LONG).show();

            }
        });


    }
}