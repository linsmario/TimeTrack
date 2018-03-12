package com.scrum5bwi.timetrack;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button startStopButton;
        startStopButton = (Button) findViewById(R.id.buttonRight);
        startStopButton.setText("Start");
        final Context context = getApplicationContext();


        final TextView timeView;
        timeView = (TextView) findViewById(R.id.Time);
        timeView.setText("00:00:00");


        final StopWatch stopWatch = new StopWatch();


        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(startStopButton.getText() == "Start"){
                    startStopButton.setText("Pause");
                    if(stopWatch.isStarted()) {
                        stopWatch.resumeTime();
                    } else {
                        stopWatch.startTime();
                    }
                    //Toast.makeText(context, "Give it to me im worth it!",
                    //        Toast.LENGTH_LONG).show();
                }

                else if(startStopButton.getText() == "Pause"){
                    startStopButton.setText("Start");
                    //Toast.makeText(context, "Give it to me im worth it!2",
                    //        Toast.LENGTH_LONG).show();
                    stopWatch.pauseTime();
                }

            }
        });


        /*final Button stopButton;
        stopButton = (Button) findViewById(R.id.buttonLeft);
        stopButton.setText("Stop");

        rundeLoeschenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //safe time and reset timer
            }
        });*/


        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(10);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if(stopWatch.isStarted()) {
                                    timeView.setText(stopWatch.getCurrentTime());
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();
    }

}
