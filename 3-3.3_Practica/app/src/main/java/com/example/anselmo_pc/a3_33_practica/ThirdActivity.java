package com.example.anselmo_pc.a3_33_practica;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{
    AnimationDrawable _animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

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

        ImageView image=(ImageView)findViewById(R.id.imagent);
        image.setVisibility(ImageView.VISIBLE);
        image.setImageDrawable(_animation);

        Button boton1=(Button)findViewById(R.id.botont1);
        boton1.setOnClickListener(this);

        Button boton2=(Button)findViewById(R.id.botont2);
        boton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.botont1)_animation.start();
        else _animation.stop();
    }
}
