package com.example.anselmo_pc.a3_33_practica;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    AnimationDrawable _animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        _animation=new AnimationDrawable();
        Resources rsources=getResources();

        Drawable imagen1=rsources.getDrawable(R.drawable.a);
        Drawable imagen2=rsources.getDrawable(R.drawable.b);
        Drawable imagen3=rsources.getDrawable(R.drawable.c);
        Drawable imagen4=rsources.getDrawable(R.drawable.d);
        Drawable imagen5=rsources.getDrawable(R.drawable.e);

        _animation.addFrame(imagen1, 3000);
        _animation.addFrame(imagen2, 3000);
        _animation.addFrame(imagen3, 3000);
        _animation.addFrame(imagen4, 3000);
        _animation.addFrame(imagen5, 3000);

        ImageView image=(ImageView)findViewById(R.id.imagens);
        image.setVisibility(ImageView.VISIBLE);
        image.setBackgroundDrawable(_animation);

        Button boton1=(Button)findViewById(R.id.button1s);
        boton1.setOnClickListener(this);

        Button boton2=(Button)findViewById(R.id.button2s);
        boton2.setOnClickListener(this);

        Button sig=(Button)findViewById(R.id.siguis);
        sig.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(activityChangeIntent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button1s)_animation.start();
        else _animation.stop();
    }
}
