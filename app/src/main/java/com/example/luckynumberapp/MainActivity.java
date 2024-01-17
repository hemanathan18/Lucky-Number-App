package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtView;
    Button wishBtn;
    EditText edittxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittxt=findViewById(R.id.editText);
        wishBtn=findViewById(R.id.wishbtn);

        wishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edittxt.getText().toString();

                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                i.putExtra("name",userName);
                startActivity(i);

            }
        });
    }
}