package com.example.anselmo_pc.praticatres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        TextView tv1=(TextView)findViewById(R.id.textView4);
        TextView tv=(TextView)findViewById(R.id.textView5);

        AnimationSet animacion=new AnimationSet(true);

        AlphaAnimation aparicion=new AlphaAnimation(0,1);
        aparicion.setDuration(3000);

        int rs= ScaleAnimation.RELATIVE_TO_SELF;
        ScaleAnimation escala=new ScaleAnimation(1,2,1,5,rs,0.5f,rs,0.5f);
        escala.setDuration(3000);
        escala.setStartOffset(3000);

        rs= RotateAnimation.RELATIVE_TO_SELF;
        RotateAnimation rotacion=new RotateAnimation(0,45,rs,0.5f,rs,0.5f);
        rotacion.setDuration(3000);
        rotacion.setStartOffset(6000);

        int rp= TranslateAnimation.RELATIVE_TO_PARENT;
        TranslateAnimation translateAnimation=new TranslateAnimation(rp,0f,rp,0f,rp,0f,rp,0.25f);
        translateAnimation.setDuration(3000);
        translateAnimation.setStartOffset(9000);

        animacion.addAnimation(aparicion);
        animacion.addAnimation(escala);
        animacion.addAnimation(rotacion);
        animacion.addAnimation(translateAnimation);

        animacion.setFillAfter(true);
        animacion.setRepeatMode(Animation.RESTART);
        animacion.setRepeatCount(20);
        tv.startAnimation(animacion);
    }
}
