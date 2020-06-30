package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   public  ProgressBar progressBar;
   public Button b1;
   TextView textView;
   int start=0;
   private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        b1=findViewById(R.id.button);
        textView=findViewById(R.id.textView);

    }

    public  void  buttony(View view)
    {
        // making start as inital progress

        start=progressBar.getProgress();
        Thread t=new Thread(new Runnable() {
            @Override
            public void run()
            {
                while ((start<100))
                {
                    start++;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(start);
                            textView.setText( "Your Download is started....please wait"+"   " +start+ "/" + progressBar.getMax());
                            if (start==100)
                            {
                                textView.setText("Your Download is succesfully completed");
                            }
                        }
                    });

                 try
                 {
                     Thread.sleep(1000);
                 }catch (InterruptedException e)
                 {
                     e.printStackTrace();
                 }

                }

            }
        });t.start();



    }
}
