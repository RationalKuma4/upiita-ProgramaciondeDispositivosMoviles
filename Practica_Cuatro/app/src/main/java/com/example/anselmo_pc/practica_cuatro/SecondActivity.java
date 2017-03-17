package com.example.anselmo_pc.practica_cuatro;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SecondActivity extends AppCompatActivity {
    TextView _textView;
    int _time=0;
    int _rate=100;
    Timer _timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        _textView=(TextView)findViewById(R.id.cronometro2);
        _timer=new Timer("Temportizador");
        Tarea tarea=new Tarea();
        _timer.scheduleAtFixedRate(tarea,0,_rate);
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
            String texto = "Temporizador cambiando texto con post \n rate= "+_rate+"\n t= "+_time;
            _textView.setText(texto);
            _textView.setTypeface(null, Typeface.BOLD);
            _textView.setTextSize(30);
        }
    }
}
