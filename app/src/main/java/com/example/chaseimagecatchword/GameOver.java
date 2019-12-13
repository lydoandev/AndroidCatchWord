package com.example.chaseimagecatchword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        final MediaPlayer mediaFail = MediaPlayer.create(GameOver.this, R.raw.cry);
        mediaFail.start();
        TextView txtScore = findViewById(R.id.txtScore);
        String score = getIntent().getStringExtra("Score");
        txtScore.setText("SCORE: " + score);
        Button btnPlayAgain = findViewById(R.id.btnPlayAgain);
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaFail.stop();
                Intent intent = new Intent(GameOver.this, Question.class );
                startActivity(intent);
            }
        });
    }
}
