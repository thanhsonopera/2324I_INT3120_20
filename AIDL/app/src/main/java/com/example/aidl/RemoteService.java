package com.example.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {
    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
        public int getPid() throws RemoteException{
            return Process.myPid();
        }
        public void basicTypes(int anInt, long aLong, boolean aBoolean,
                               float aFloat, double aDouble, String aString) {
            // Does nothing
        }
    };
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // Return the interface
        return mBinder;
    }

}
