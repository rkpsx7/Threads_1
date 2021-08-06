package com.example.threads_1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button task1, task2;
    private WorkerThread workerThread;
    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        task1 = findViewById(R.id.btn_one);
        task2 = findViewById(R.id.btn_two);
        workerThread = new WorkerThread();
        workerThread.start();
        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToQue(taskOne);
            }
        });

        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToQue(taskTwo);
            }
        });
    }


    private Runnable taskOne = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"Task 1 "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable taskTwo = new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"Task 2 "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}