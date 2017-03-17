package com.example.anselmo_pc.practica_cuatro;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView _textView;
    int _time=0;
    int _rate=100;
    Timer _timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _textView=(TextView)findViewById(R.id.cronometro);

        _timer=new Timer("Temportizador");
        Tarea tarea=new Tarea();
        _timer.scheduleAtFixedRate(tarea,0,_rate);

        Button sig=(Button)findViewById(R.id.boton1);
        sig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(activityChangeIntent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        _timer.cancel();
    }

    class Tarea extends TimerTask
    {
        @Override
        public void run() {
            Runnable cambiaTexto=new CambiaTetxo();
            _textView.post(cambiaTexto);
        }
    }

    class CambiaTetxo implements Runnable {
        @Override
        public void run() {
            _time=_time+_rate;
            String texto = "Temporizador \n rate= "+_rate+"\n t= "+_time;
            _textView.setText(texto);
            _textView.setTypeface(null, Typeface.BOLD);
            _textView.setTextSize(30);
        }
    }
}



