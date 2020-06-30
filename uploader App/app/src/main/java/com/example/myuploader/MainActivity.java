package com.example.myuploader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar,progressBarHorizontal;
    Button start,end,upload;
    // for tracking progress
    int progress=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        progressBarHorizontal=findViewById(R.id.progressBar2);

        start=findViewById(R.id.Start);
        upload=findViewById(R.id.upload);
       end=findViewById(R.id.buttnend);




    }
    public void Start(View view)
    {
        progressBar.setVisibility(View.VISIBLE);



    }
    public void end(View view)
    {

      progressBar.setVisibility(View.GONE);


    }
    public void upload(View view)
    {

     fakeprogress(progress);

    }

    //fakeprogress
    //we dont have uploading material
    public  void fakeprogress( final int progress)
    {
        progressBarHorizontal.setProgress(progress);
        //create a runnable thread
        Thread thread= new Thread(new Runnable()
        {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                fakeprogress(progress+10);
            }
        });
        thread.start();
    }
}
