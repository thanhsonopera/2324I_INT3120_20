// IRemoteService.aidl
package com.example.aidl;


interface IRemoteService {

     int getPid();

    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
}