package com.example.anselmo_pc.practicacuatro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    private int i=0;
    private TextView tv;
    private Animation escala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv1=(TextView)findViewById(R.id.texto1);
        tv1.setText("Usando la iterfaz animation");

        tv=(TextView)findViewById(R.id.texto);
        tv.setText("Contador"+i);

        Animation aparicion=new AlphaAnimation(0,1);
        aparicion.setDuration(1000);
        aparicion.setFillAfter(true);
        aparicion.setRepeatMode(Animation.RESTART);
        aparicion.setRepeatCount(10);
        aparicion.setAnimationListener(this);

        int rs= ScaleAnimation.RELATIVE_TO_SELF;
        escala=new ScaleAnimation(1,2,1,5,rs,0.5f,rs,0.5f);
        escala.setDuration(3000);
        escala.setFillAfter(true);
        tv.startAnimation(aparicion);

        Button boton=(Button)findViewById(R.id.buttonUno);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {
        tv.setText("Final");
        tv.startAnimation(escala);
    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        i++;
        tv.setText("Contador: "+i);
    }
}
