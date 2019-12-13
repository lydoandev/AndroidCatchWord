package com.example.chaseimagecatchword;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class Win extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        MediaPlayer mediaWin = MediaPlayer.create(Win.this, R.raw.clab);
        mediaWin.start();
        TextView txtScore = findViewById(R.id.txtScore);
        String score = getIntent().getStringExtra("Score");
        txtScore.setText("SCORE: " + score);
    }
}
