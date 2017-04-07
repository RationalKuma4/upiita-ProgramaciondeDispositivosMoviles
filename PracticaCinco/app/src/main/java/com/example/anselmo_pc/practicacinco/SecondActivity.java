package com.example.anselmo_pc.practicacinco;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv=(TextView)findViewById(R.id.stextView);

        SensorManager sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> allSensors=sensorManager.getSensorList(Sensor.TYPE_ALL);

        int size=allSensors.size();
        tv.setText("\n Numero de sensores"+size);
        for (int i=0;i<size;i++){
            Sensor sensor=allSensors.get(i);
            int tipo=sensor.getType();
            tv.append("\nTipo: "+tipo);
            String nombre=sensor.getName();
            tv.append("\n"+nombre);
            String vendedor=sensor.getVendor();
            tv.append("\nVendedor: "+vendedor);
            float power=sensor.getPower();
            tv.append("\nPower: "+power);
            float resolucion=sensor.getResolution();
            tv.append("\nResolucion: "+resolucion);
            float rango=sensor.getMaximumRange();
            tv.append("\nSensor: "+rango);
        }

        Button boton = (Button)findViewById(R.id.boton2);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
