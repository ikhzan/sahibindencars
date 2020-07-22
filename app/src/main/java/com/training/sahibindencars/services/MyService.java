package com.training.sahibindencars.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "MyService";
    
    public MyService() {
        Log.d(TAG, "MyService: constructor");
    }

    @Override
    public IBinder onBind(Intent intent) {
       Log.d(TAG, "onBind: ");
       return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: " + intent.getStringExtra("hello"));
        return START_STICKY;
    }
}
