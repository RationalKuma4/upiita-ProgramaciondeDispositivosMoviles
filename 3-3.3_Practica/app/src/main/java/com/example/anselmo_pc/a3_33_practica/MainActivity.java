package com.example.anselmo_pc.a3_33_practica;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private AnimationDrawable _animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView image=(ImageView)findViewById(R.id.imagen);
        image.setVisibility(ImageView.VISIBLE);
        image.setBackgroundResource(R.drawable.fotogramas_animados);

        _animationDrawable=(AnimationDrawable)image.getBackground();

        Button boton1=(Button)findViewById(R.id.button1);
        boton1.setOnClickListener(this);

        Button boton2=(Button)findViewById(R.id.button2);
        boton2.setOnClickListener(this);

        Button sig=(Button)findViewById(R.id.sigui);
        sig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(activityChangeIntent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button1) _animationDrawable.start();
        else _animationDrawable.stop();
    }
}
