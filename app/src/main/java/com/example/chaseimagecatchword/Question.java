package com.example.chaseimagecatchword;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Question extends AppCompatActivity {

    int numberOfQuestion = 0;
    listQuestion questions = new listQuestion();
    ArrayList<itemQuestion> list = questions.listQuestion;
    int count;
    int score = 0;
    int sttBtn;
    String img, anwser;
    Button[] buttons;
    int m;

    Button[] buttonsSuggest;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        showLevelScore();
        showImage();

        showAnwserKey();

        showAnwserSuggest();

        Button btnPlayAgain = findViewById(R.id.btnPlayAgain);
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnwserKey();
                showImage();
                showAnwserSuggest();
            }
        });
    }

    public void showLevelScore() {

        TextView txtLevel, txtScore;

        txtLevel = findViewById(R.id.txtLevel);
        txtLevel.setText("Level: " + String.valueOf(numberOfQuestion + 1));

        txtScore = findViewById(R.id.txtScore);
        txtScore.setText("Score: " + String.valueOf(score));
    }


    public void showImage() {
        img = list.get(numberOfQuestion).getImg();
        ImageView imgView = findViewById(R.id.img);
        int imageResource = getResources().getIdentifier(img, null, getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        imgView.setImageDrawable(res);
    }

    public void showAnwserKey() {
        anwser = list.get(numberOfQuestion).getAnwser();

        String[] arrAnwser = anwser.split(" ");

        buttons = new Button[anwser.replaceAll("\\s+", "").length() + 1];

        sttBtn = 0;


        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutAnwser);
        linearLayout.removeAllViews();
        for (int i = 0; i < arrAnwser.length; i++) {

            for (int j = 0; j < arrAnwser[i].length(); j++) {
                final int temp = sttBtn;
                buttons[temp] = new Button(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(80, 70);
                buttons[temp].setLayoutParams(params);
                buttons[temp].setTextColor(Color.parseColor("#ffffff"));
                buttons[temp].setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_anwser));

                buttons[temp].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("Ly", buttons[temp].getText().toString());
                        if (!buttons[temp].getText().toString().equals("")) {
                            buttons[temp].setText("");
                            Log.i("TagNe", buttons[temp].getTag().toString());
                            int btnTag = Integer.parseInt(buttons[temp].getTag().toString());
                            buttonsSuggest[btnTag].setVisibility(View.VISIBLE);
                        }
                    }
                });
                linearLayout.addView(buttons[sttBtn]);
                sttBtn++;
            }

            Button btnSpace = new Button(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50, 50);
            btnSpace.setVisibility(View.INVISIBLE);
            btnSpace.setLayoutParams(params);
            linearLayout.addView(btnSpace);
        }
    }

    public void showAnwserSuggest() {
        count = 0;
        char[] chars1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder sb1 = new StringBuilder();
        Random random1 = new Random();
        for (int i = 0; i < 1; i++) {
            char c1 = chars1[random1.nextInt(chars1.length)];
            sb1.append(c1);
        }
        anwser = anwser.replaceAll("\\s+", "");
        String anwserSuggest = anwser + sb1;
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < anwserSuggest.length(); i++) {
            chars.add(anwserSuggest.charAt(i));
        }

        Collections.shuffle(chars);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layoutAnwserSuggest);
        linearLayout.removeAllViews();

        buttonsSuggest = new Button[chars.size()];

        Log.i("Char size", String.valueOf(chars.size()));

        for (int j = 0; j < chars.size(); j++) {

            final int m = j;
            buttonsSuggest[j] = new Button(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(80, 70);
            buttonsSuggest[j].setLayoutParams(params);
            buttonsSuggest[j].setText(String.valueOf(chars.get(j)));
            buttonsSuggest[j].setTextColor(Color.parseColor("#ffffff"));
            buttonsSuggest[j].setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_suggest));

            buttonsSuggest[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttons[count].setText(buttonsSuggest[m].getText().toString());
                    buttons[count].setTag(String.valueOf(m));
                    buttonsSuggest[m].setVisibility(View.INVISIBLE);
                    checkPass();
                    count++;
                }
            });

            linearLayout.addView(buttonsSuggest[m]);
        }
    }


    public void checkPass() {
        String result = "";
        for (int i = 0; i < anwser.length(); i++) {
            result += buttons[i].getText();
        }
        String anwserCat = anwser.replaceAll("\\s+", "");
        if (result.equals(anwserCat)) {
            new AlertDialog.Builder(this)
                    .setTitle("Notification")
                    .setMessage("Correct")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            numberOfQuestion++;
                            score += 10;
                            showLevelScore();
                            showImage();
                            showAnwserKey();
                            showAnwserSuggest();
                        }
                    }).show();
        }
    }


}
