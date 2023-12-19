package com.aayush.luckynumberapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    Button button;
    TextView luckyNumber, number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.bttn);
        luckyNumber = findViewById(R.id.textView);
        number = findViewById(R.id.number);

        Intent i = getIntent();

        String userName = i.getStringExtra("name");


        int randomNum = generateRandom();
        number.setText("" + randomNum);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName , randomNum);
            }
        });
    }

    public int generateRandom()
    {
        Random random = new Random();
        int upperLimit = 1000;

        return random.nextInt(upperLimit);
    }

    public void shareData(String userName, int random) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky today");
        i.putExtra(Intent.EXTRA_TEXT, "His Lucky Number is " + random);

        startActivity(Intent.createChooser(i, "Choose a platform"));
    }
}