package com.pennapps.xv.adoperari.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.pennapps.xv.adoperari.R;
import com.pennapps.xv.adoperari.data.Settings;
import com.pennapps.xv.adoperari.models.Time;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       if(!Settings.getInstance(getBaseContext()).isSetup()){
            Intent i = new Intent(MainActivity.this, GetStartedActivity.class);
            startActivity(i);
            finish();
        }



        /*final boolean[] days = {true,false,false,false,false,false,false};
        final TextView timeDisplay = (TextView) findViewById(R.id.test);
        final Time pennAppsDeadlne = new Time(8,0,0, days);


        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                timeDisplay.setText(pennAppsDeadlne.displayCountdown());

                            }
                        });
                    }
                } catch (InterruptedException e) {

                }
            }
        };

        t.start();*/




    }
}
