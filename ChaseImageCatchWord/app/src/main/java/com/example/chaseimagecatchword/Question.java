package com.example.chaseimagecatchword;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Question extends AppCompatActivity {

    static int index;
    listQuestion questions = new listQuestion();
    ArrayList<itemQuestion> list = questions.listQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        String img, anwser;
        img = list.get(index).getImg();
        anwser = list.get(index).getAnwser();

        ImageView imgView = findViewById(R.id.img);

        Bundle bundle = getIntent().getExtras();
        index = bundle.getInt("index");

        int imageResource = getResources().getIdentifier(img, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        imgView.setImageDrawable(res);



        for (int i = 0; i < anwser.length(); i++) {
            Button btn = new Button(this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutAnwser);
//            btn.setHeight(10);
            btn.setId(i);
            linearLayout.addView(btn);
        }

        Log.i("anwser lengh", String.valueOf(anwser.length()));


    }
}
