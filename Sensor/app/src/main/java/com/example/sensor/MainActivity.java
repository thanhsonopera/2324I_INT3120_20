package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    SensorManager sm = null;
    TextView textView1 = null, textView2 = null;
    List list;
    Handler handler = new Handler();
    private static final float ALPHA = 0.8f;//?
    private float[] gravity = new float[3];
    private float[] linearAcceleration = new float[3];
    SensorEventListener sel = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            Log.d("TAG", "onAccuracyChanged: " + accuracy);

        }

        public void onSensorChanged(SensorEvent event) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    float[] values = event.values;
                    gravity[0] = ALPHA * gravity[0] + (1 - ALPHA) * event.values[0];
                    gravity[1] = ALPHA * gravity[1] + (1 - ALPHA) * event.values[1];
                    gravity[2] = ALPHA * gravity[2] + (1 - ALPHA) * event.values[2];

                    // Tính toán gia tốc không gian tự do
                    linearAcceleration[0] = event.values[0] - gravity[0];
                    linearAcceleration[1] = event.values[1] - gravity[1];
                    linearAcceleration[2] = event.values[2] - gravity[2];
                    textView1.setText("x: " + values[0] + "\ny: " + values[1] + "\nz: " + values[2]);
                    textView2.setText("x: " + linearAcceleration[0] + "\ny: "  + linearAcceleration[1] + "\nz: " + linearAcceleration[2]);
                }
            });

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        // Định dạng loại cảm biến cho sensor
        list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER); //sensor.getType()
        if(list.size()>0){
            sm.registerListener(sel, (Sensor) list.get(0), SensorManager.SENSOR_DELAY_NORMAL);
            Log.d("TAG", "onCreate: " + list.size());
        }
        else{
            Toast.makeText(getBaseContext(), "Error: No Accelerometer.", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onStop() {
        if(list.size()>0){
            sm.unregisterListener(sel);
        }
        super.onStop();
    }
}