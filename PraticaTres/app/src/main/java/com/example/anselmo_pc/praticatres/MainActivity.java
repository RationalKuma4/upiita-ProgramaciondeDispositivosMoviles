package com.example.anselmo_pc.praticatres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1 = (TextView) findViewById(R.id.texto1);
        tv1.setText("Animaciones diltaciones y contracciones");

        TextView tv = (TextView) findViewById(R.id.texto);
        tv.setText("Dilatando");

        Animation td = AnimationUtils.loadAnimation(this, R.anim.dilatacion);
        td.setRepeatMode(Animation.RESTART);
        td.setRepeatCount(20);
        tv.startAnimation(td);

        Button boton=(Button)findViewById(R.id.button1);
        boton.setText("Siguiente");
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
