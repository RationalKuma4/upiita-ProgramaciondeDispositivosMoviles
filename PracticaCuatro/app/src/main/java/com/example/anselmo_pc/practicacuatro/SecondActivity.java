package com.example.anselmo_pc.practicacuatro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int rp= TranslateAnimation.RELATIVE_TO_PARENT;
        TranslateAnimation traslacion=new TranslateAnimation(rp,1f,rp,0f,rp,0f,rp,0f);
        traslacion.setDuration(3000);

        LayoutAnimationController la=new LayoutAnimationController(traslacion);
        la.setDelay(1);
        la.setOrder(LayoutAnimationController.ORDER_NORMAL);

        RelativeLayout ll=(RelativeLayout)findViewById(R.id.activity_second);
        ll.setLayoutAnimation(la);
        ll.setLayoutAnimationListener(this);

        Button boton = (Button)findViewById(R.id.button3);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        int rs= RotateAnimation.RELATIVE_TO_SELF;
        RotateAnimation rotacion =new RotateAnimation(0,360,rs,0.5f,rs,0.5f);
        rotacion.setDuration(3000);
        TextView tv=(TextView)findViewById(R.id.texto);
        tv.setText("Eso no es todo");
        tv.startAnimation(rotacion);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
