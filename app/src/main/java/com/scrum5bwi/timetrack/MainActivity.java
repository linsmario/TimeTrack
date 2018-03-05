package com.scrum5bwi.timetrack;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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


        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(startStopButton.getText() == "Start"){
                    startStopButton.setText("Stop");
                    Toast.makeText(context, "Give it to me im worth it!",
                            Toast.LENGTH_LONG).show();
                }

                else if(startStopButton.getText() == "Stop"){
                    startStopButton.setText("Start");
                    Toast.makeText(context, "Give it to me im worth it!2",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
