package com.example.anselmo_pc.cuatromaquina;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int _dificultad=100;
    int _columna;
    boolean[] _continuar={false,false,false};
    TextView _tv, _textDificultad;
    int[] _fotoId=
            {
                    R.drawable.tra1,
                    R.drawable.tra2,
                    R.drawable.tra3,
                    R.drawable.tra4,
                    R.drawable.tra5,
                    R.drawable.tra6,
                    R.drawable.tra7,
                    R.drawable.tra8,
                    R.drawable.tra9
            };
    int[][] _secuencia=
            {
                    {0,1,2,3,4,5,6,7,8},
                    {8,7,6,5,4,3,2,1,0},
                    {4,5,3,2,6,7,1,0,8}
            };
    ImageView[][] _imagev=new ImageView[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _tv=(TextView)findViewById(R.id.texto);
        _textDificultad=(TextView)findViewById((R.id.dificultad));

        _imagev[0][0]=(ImageView)findViewById(R.id.imageView11);
        _imagev[1][0]=(ImageView)findViewById(R.id.imageView21);
        _imagev[2][0]=(ImageView)findViewById(R.id.imageView31);
        _imagev[0][1]=(ImageView)findViewById(R.id.imageView12);
        _imagev[1][1]=(ImageView)findViewById(R.id.imageView22);
        _imagev[2][1]=(ImageView)findViewById(R.id.imageView32);
        _imagev[0][2]=(ImageView)findViewById(R.id.imageView13);
        _imagev[1][2]=(ImageView)findViewById(R.id.imageView23);
        _imagev[2][2]=(ImageView)findViewById(R.id.imageView33);

        View boton1=(Button)findViewById(R.id.button1);
        boton1.setOnClickListener(this);
        View boton2=(Button)findViewById(R.id.button2);
        boton2.setOnClickListener(this);
        View boton3=(Button)findViewById(R.id.button3);
        boton3.setOnClickListener(this);
        View boton4=(Button)findViewById(R.id.button4);
        boton4.setOnClickListener(this);
        View boton5=(Button)findViewById(R.id.button5);
        boton5.setOnClickListener(this);
        View boton6=(Button)findViewById(R.id.button6);
        boton6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button4 | v.getId()==R.id.button5 | v.getId()==R.id.button6){
            if (v.getId()==R.id.button4) _dificultad=_dificultad+10;
            if (v.getId()==R.id.button5) _dificultad=200;
            if (v.getId()==R.id.button6) _dificultad=_dificultad-10;
            _textDificultad.setText("Dificultad"+_dificultad);
        }
        else {
            if (v.getId()==R.id.button1) _columna=0;
            if (v.getId()==R.id.button2) _columna=1;
            if (v.getId()==R.id.button3) _columna=2;

            _continuar[_columna]=!_continuar[_columna];
            if (_continuar[_columna]){
                new MiAyncTask().execute(_columna);
                ((TextView)v).setText("Parar");
            }
            else ((TextView)v).setText("Continuar");
        }
    }

    class MiAyncTask extends AsyncTask<Integer,Integer,String>{
        @Override
        protected String doInBackground(Integer... params) {
            int columna=params[0];
            while (_continuar[columna]){
                int elemento1=_secuencia[columna][0];
                for (int i=0; i<8; i++)
                {
                    _secuencia[columna][i]=_secuencia[columna][i+1];
                }
                _secuencia[columna][8]=elemento1;

                try {
                    Thread.sleep(Math.abs(_dificultad));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                publishProgress(columna);
            }
            return "Stop columna"+(columna+1);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int columna=values[0];
            for (int i=0;i<3;i++){
                _imagev[i][columna].setImageResource(_fotoId[_secuencia[columna][i]]);
            }
        }

        @Override
        protected void onPostExecute(String s) {
            if (_continuar[0]==false & _continuar[1]==false & _continuar[2]==false){
                if (_secuencia[0][1]==_secuencia[1][1] & _secuencia[0][1]==_secuencia[2][1]){
                    _tv.setText("Premio");
                }
                else _tv.setText("Suerte la proxima vez");
            }
            else _tv.setText(""+s);
        }
    }

}
