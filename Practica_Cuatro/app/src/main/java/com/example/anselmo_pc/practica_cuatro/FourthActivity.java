package com.example.anselmo_pc.practica_cuatro;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class FourthActivity extends AppCompatActivity {
    TextView _textView, _textView0, _textView1;
    int _time=0;
    int _rate=100;
    Timer _timer, _timer0,_timer1;

    Handler _handler= new Handler() {
        @Override
        public void publish(LogRecord record) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        _textView=(TextView)findViewById(R.id.texto);
        _textView0=(TextView)findViewById(R.id.texto0);
        _textView1=(TextView)findViewById(R.id.texto1);

        int factor1=1;
        int factor2=2;
        int factor3=3;

        _timer=new Timer("Temportizador");
        Tarea tarea=new Tarea(_textView,factor1);
        _timer.scheduleAtFixedRate(tarea,0,_rate);

        _timer0=new Timer("Temportizador0");
        Tarea0 tarea0=new Tarea0(_textView0,factor2);
        _timer0.scheduleAtFixedRate(tarea0,0,_rate);

        _timer1=new Timer("Temportizador1");
        Tarea1 tarea1=new Tarea1(_textView1,factor3);
        _timer1.scheduleAtFixedRate(tarea1,0,_rate);
    }

    @Override
    protected void onPause() {
        super.onPause();
        _timer.cancel();
        _timer0.cancel();
        _timer1.cancel();
    }

    class Tarea extends TimerTask
    {
        int _factor;
        TextView _textTarea;
        public Tarea(TextView textView, int factor)
        {
            this._factor=factor;
            this._textTarea=textView;
        }
        @Override
        public void run() {
            Runnable cambiaTexto=new CambiaTetxo(_textTarea,_factor);
            _textView.post(cambiaTexto);
        }
    }

    class Tarea0 extends TimerTask
    {
        int _factor;
        TextView _textTarea;
        public Tarea0(TextView textView, int factor)
        {
            this._factor=factor;
            this._textTarea=textView;
        }
        @Override
        public void run() {
            Runnable cambiaTexto=new CambiaTetxo(_textTarea,_factor);
            _textView.post(cambiaTexto);
        }
    }

    class Tarea1 extends TimerTask
    {
        int _factor;
        TextView _textTarea;
        public Tarea1(TextView textView, int factor)
        {
            this._factor=factor;
            this._textTarea=textView;
        }
        @Override
        public void run() {
            Runnable cambiaTexto=new CambiaTetxo(_textTarea,_factor);
            _textView.post(cambiaTexto);
        }
    }

    class CambiaTetxo implements Runnable {
        int red,green,blue,_factor;
        TextView _textCambia;

        public CambiaTetxo(TextView textCambia, int factor)
        {
            this._textCambia=textCambia;
            this._factor=factor;
        }
        @Override
        public void run() {
            _time=_time+_rate;

            red=(_time/_factor)%255;
            green=(int)((0.75*_time/_factor)%225);
            blue=(int)((0.60*_time/_factor)%225);

            String texto = "Temporizador \n rate= "+_rate+"\n t= "+_time;
            _textCambia.setText(texto);
            _textCambia.setTypeface(null,Typeface.BOLD);
            _textCambia.setTextSize(30);
            _textCambia.setTextColor(Color.rgb(red,green,blue));
        }
    }
}
