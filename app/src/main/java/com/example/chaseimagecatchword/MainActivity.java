package com.example.chaseimagecatchword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlayNow = findViewById(R.id.btnPlayNow);
        btnPlayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent question = new Intent(MainActivity.this, Question.class);
                question.putExtra("index", 0);
                startActivity(question);
            }
        });
    }
}
