package com.example.administrator.demo_learning;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txt1;
    Button btn1;
    Button btnRd;
   RelativeLayout menu;
    Button btnCTm;
    Button btnChuyenMH,btnChuyenMH3;
    int i;
    public void HienThiToast(String s){
        Toast.makeText(
                MainActivity.this,
                s,
                Toast.LENGTH_SHORT
        ).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        HienThiToast("helloWorld");
        txt1 = (TextView) findViewById(R.id.txt1);
        btn1= (Button) findViewById(R.id.btn1);
        btnRd= (Button) findViewById(R.id.btnRanDom);
        txt1.setText("Nhập từ");
        //Nút hiển thị
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setText("Click rồi nhóe <3 ághdkjashdsakdhsadhsajkdhsjkdhsajkdh");
            }
        });

        //Nút random số
        btnRd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rd = new Random();
                int n = rd.nextInt(100);
                txt1.setText(String.valueOf(n));
            }
        });

        //Messagebox
        HienThiToast("Đờ mờ Hòa em ê");
        HienThiToast("Em có thấy gì không em ê");
        HienThiToast("Vi diệu vd không em ê");

        //Background
        menu=(RelativeLayout) findViewById(R.id.MainScreen);
        menu.setBackgroundResource(R.drawable.wpp3);

        //Countdown Timer
        btnCTm = (Button) findViewById(R.id.btnCT);
        txt1.setText("");

        btnCTm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new CountDownTimer(11000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                        String s= String.valueOf(i);
                        i=i+1;
                        txt1.setText(s.toString());
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(MainActivity.this,
                                "Hết giờ",
                                Toast.LENGTH_SHORT
                                ).show();
                    }
                }.start();
            }
        });

        //Chuyển màn hình
        btnChuyenMH = (Button) findViewById(R.id.btnScr2);
        btnChuyenMH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh2= new Intent(MainActivity.this, ManHinh2.class);

                //Truyền tham số
                mh2.putExtra("bientruyen","Đây là chuỗi truyền");
                startActivity(mh2);
            }
        });

        btnChuyenMH3=(Button) findViewById(R.id.btnMh3);
        btnChuyenMH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh3 = new Intent(MainActivity.this, ManHinh3.class);
                startActivity(mh3);
            }
        });
//        Toast t = Toast.makeText(
//                MainActivity.this,
//                "Vi diệu không em êi",
//                Toast.LENGTH_LONG
//        );
//        t.show();
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
