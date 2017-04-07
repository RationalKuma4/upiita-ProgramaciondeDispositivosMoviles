package com.example.anselmo_pc.practicacinco;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity  implements SensorEventListener {
    int contador=0;
    double x,y,z,a,amax=0;
    double gravedad= SensorManager.STANDARD_GRAVITY;
    TextView tvax, tvay, tvaz, tva, tvaMax,tvG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvax=(TextView)findViewById(R.id.textViewAX);
        tvay=(TextView)findViewById(R.id.textViewAY);
        tvaz=(TextView)findViewById(R.id.textViewAZ);
        tva=(TextView)findViewById(R.id.textViewA);
        tvaMax=(TextView)findViewById(R.id.textViewAmax);
        tvG=(TextView)findViewById(R.id.textViewG);

        SensorManager sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor acelerometro=sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_FASTEST);
        new MiAsyncTask().execute();

        Button boton = (Button)findViewById(R.id.boton3);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x=event.values[0];
        y=event.values[1];
        z=event.values[2];
        a=Math.sqrt(x*x+y*y+z*z);
        if (a>amax)amax=a;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    class MiAsyncTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params) {
            while (true){
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                contador++;
                publishProgress();;
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            tvax.setText(""+x);
            tvay.setText(""+y);;
            tvaz.setText(""+z);
            tva.setText(""+a);
            tvaMax.setText(""+amax);
            tvG.setText(""+gravedad);
            tvG.append("\n"+contador);
        }
    }
}
