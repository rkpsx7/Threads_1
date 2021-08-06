package com.example.threads_1;

import android.os.Handler;
import android.os.Looper;

public class WorkerThread extends Thread{
    private Handler handler;
    @Override
    public void run() {
        super.run();
        Looper.prepare();
        handler = new Handler(Looper.myLooper());
        Looper.loop();
    }
    public void addTaskToQue(Runnable task){
        if (handler!=null){
            handler.post(task);
        }
    }
}
