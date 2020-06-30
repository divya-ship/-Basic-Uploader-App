package com.example.progressbardialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
public ProgressDialog progress;
public TextView textView;
public Button b1;
int start=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        b1=findViewById(R.id.button);

    }
    public  void  buttony(View view)
    {
        //create a progress bar

        progress=new ProgressDialog(this);
        progress.setMessage("Downloading Tum hi ho mp3...... ");
        progress.setMax(100);
        progress.setProgress(0);
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.show();

        progress.setCancelable(true);
        final int totalprogresstime=100;
          Thread t=new Thread(new Runnable() {
              @Override
              public void run() {
                  while(start<totalprogresstime)
                  {
                      start++;
                      progress.setProgress(start);
                   try{
                       Thread.sleep(100);
                   }
                   catch (InterruptedException e)
                   {
                       e.printStackTrace();
                   }
                  }
              }
          }); t.start();


    }
}
  /* or u can use this part by using handler  */
 //public  void  buttony(View view)
  //{
      // making start as inital progress

      //start=progressBar.getProgress();
      //Thread t=new Thread(new Runnable() {
         // @Override
         // public void run()
         // {
             // while ((start<100))
              //{
                  //start++;
                  //handler.post(new Runnable() {
                     // @Override
                     // public void run() {
                         // progressBar.setProgress(start);
                         // ignore thhis line textView.setText( "Your Download is started....please wait"+"   " +start+ "/" + progressBar.getMax());
                         // if (start==100)
                          //{
                             // textView.setText("Your Download is succesfully completed");
                          //}
                    //  }
                  //});

                 // try
                //  {
                     // Thread.sleep(1000);
                 // }catch (InterruptedException e)
                  //{
                     // e.printStackTrace();
             //}

             // }

         // }
     // });t.start();
//}
//}

