package com.example.administrator.demo_learning;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ManHinh2 extends AppCompatActivity {
    Button btnBack1, btnPlay,btnPause,btnStop;
    Button btnGetString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Back
        btnBack1=(Button) findViewById(R.id.btnBack);
        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh1=new Intent(ManHinh2.this,MainActivity.class);
                startActivity(mh1);
            }
        });

        //Nhận dữ liệu
        btnGetString=(Button) findViewById(R.id.btnGetData);
        btnGetString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Bundle bd = getIntent().getExtras();
                    Toast.makeText(ManHinh2.this,
                            bd.getString("bientruyen"),
                            Toast.LENGTH_LONG).show();
                }catch (Exception exc){
                    Toast.makeText(
                            ManHinh2.this,
                            "Không có dữ liệu!",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
        final MediaPlayer song = MediaPlayer.create(ManHinh2.this, R.raw.nhactest);
        //Phát nhạc
        btnPlay=(Button) findViewById(R.id.btnPlayMusic);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.start();
            }
        });
        //Pause nhạc
        btnPause=(Button) findViewById(R.id.btnPauseMusic);
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.pause();
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
