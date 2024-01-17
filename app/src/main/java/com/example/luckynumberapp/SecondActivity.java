package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
TextView luckyView;
Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        luckyView=findViewById(R.id.textView3);
        shareBtn=findViewById(R.id.sharebtn);

        Intent i = getIntent();
        String userName= i.getStringExtra("name");
        int randomNum=generaterandomNumbers();
        luckyView.setText(""+randomNum);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName,randomNum);

            }
        });
    }

    public int generaterandomNumbers(){
        Random random = new Random();
        int limit=500;
        return random.nextInt(limit);
    }

    public void shareData(String name,int luckyNumber){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        //Additional info for mail setting subject and body text
        i.putExtra(Intent.EXTRA_SUBJECT,name+" got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"His/Her lucky number is "+luckyNumber);
        startActivity(Intent.createChooser(i, "Choose the sharing medium"));
    }
}