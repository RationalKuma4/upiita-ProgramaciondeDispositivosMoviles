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

public class ThirdActivity extends AppCompatActivity {
    TextView _textView;
    int _time=0;
    int _rate=100;
    Timer _timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        _textView=(TextView)findViewById(R.id.cronometro3);
        _timer=new Timer("Temportizador");
        Tarea tarea=new Tarea();
        _timer.scheduleAtFixedRate(tarea,0,_rate);

        Button sig=(Button)findViewById(R.id.boton3);
        sig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(ThirdActivity.this, FourthActivity.class);
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
            String texto = "Temporizador cambiando texto con handler \n rate= "+_rate+"\n t= "+_time;
            _textView.setText(texto);
            _textView.setTypeface(null, Typeface.BOLD);
            _textView.setTextSize(30);
        }
    }
}
