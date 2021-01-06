package com.example.derstimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ankushgrover.hourglass.Hourglass;

public class molaActivity extends AppCompatActivity {

    TextView txt;
    ImageButton playBt,pauseBt,exitBt;
    boolean isPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mola);



        txt=findViewById(R.id.textView);
        playBt = findViewById(R.id.playBt);
        pauseBt = findViewById(R.id.pauseBt);
        exitBt = findViewById(R.id.exitBt);


        final Hourglass hourglass = new Hourglass(900000, 1000) {

            @Override
            public void onTimerTick(long timeRemaining) {
                long Hours = timeRemaining / (60 * 60 * 1000) % 24;
                long Minutes = timeRemaining / (60 * 1000) % 60;
                long Seconds = timeRemaining / 1000 % 60;
                txt.setText(Hours + ":" + Minutes + ":"+Seconds);
                //here you can have your logic to set text to edittext
            }

            @Override
            public void onTimerFinish() {
                startActivity(new Intent(molaActivity.this,MainActivity.class));
                finish();
            }

        };
        hourglass.startTimer();

        playBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPause==true) {
                    hourglass.resumeTimer();
                    isPause=false;
                }
            }
        });


        pauseBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hourglass.pauseTimer();
                isPause=true;
            }
        });


        exitBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(molaActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}