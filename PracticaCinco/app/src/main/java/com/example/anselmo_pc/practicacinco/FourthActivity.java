package com.example.anselmo_pc.practicacinco;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    Sensor sensor;
    int contador=0;
    double azimut=0,vertica1=0,latera1=0;
    TextView tvAzimut,tvVertical,tvLateral,tvOrientacion,tvContador;
    String orientacion="orientacion";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        tvAzimut=(TextView)findViewById(R.id.textViewAzimut);
        tvVertical=(TextView) findViewById(R.id.textViewVertical);
        tvLateral=(TextView) findViewById(R.id.textViewLateral);
        tvOrientacion=(TextView) findViewById(R.id.textViewOrientación);
        tvContador=(TextView)findViewById(R.id.textViewContador);

        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);

        Button boton = (Button)findViewById(R.id.boton4);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FourthActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        azimut= event.values[0];
        vertica1= event.values[1];
        latera1= event.values [2];
        contador++;
        if (azimut < 22) orientacion="NORTE";
        else if(azimut < 67) orientacion="NORESTE";
        else if(azimut < 112 ) orientacion= " E S T E " ;
        else if(azimut < 112 ) orientacion="SURESTE";
        else if(azimut < 157 ) orientacion="SUR";
        else if(azimut < 202) orientacion="SUROESTE";
        else if(azimut < 247) orientacion="OESTE";
        else if( azimut < 292) orientacion="NOROESTE";
        else orientacion="NORTE";
        if (vertica1 < -50) orientacion="VERTICAL ARRIBA";
        if (vertica1 > 50) orientacion="VERTICAL ABAJO";
        if (latera1 > 50) orientacion="LATERAL IZQUIERDA";
        if (latera1 < -50) orientacion="LATERAL DERECHA";
        runOnUiThread(new CambiaTexto());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    class CambiaTexto implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            tvAzimut.setText("" + azimut);
            tvVertical.setText("" + vertica1);
            tvLateral.setText("" + latera1);
            tvOrientacion.setText("" + orientacion);
            tvContador.setText("" + contador);
        } // end CambiaTexto
    }
}
