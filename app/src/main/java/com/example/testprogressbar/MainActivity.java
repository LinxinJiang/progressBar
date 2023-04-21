package com.example.testprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // From user
    private int goalsCounter = 100;

    private int goalsCompletedCounter = 10;

    public ProgressBar progressBar;


   // TextView percentage = (TextView)findViewById(R.id.percentageText);



    public Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayProgressBar(goalsCounter,goalsCompletedCounter);



    }

    // Call this function when a new plan has been added or update a exist plan
    public void displayProgressBar(int goalsCounter,int goalsCompletedCounter){

        progressBar = findViewById(R.id.progressBar);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setContentView(R.layout.activity_main);
                progressBar.setIndeterminate(false);
                if(goalsCounter == 0 || goalsCounter/goalsCompletedCounter <= 0 ){
                    progressBar.setVisibility(View.INVISIBLE);
                }else{
                    progressBar.setMax(goalsCounter);
                    progressBar.setProgress(goalsCompletedCounter);
                }


            }
        });
    }
}