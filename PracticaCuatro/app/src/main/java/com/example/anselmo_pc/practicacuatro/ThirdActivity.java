package com.example.anselmo_pc.practicacuatro;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        int rp= TranslateAnimation.RELATIVE_TO_PARENT;
        TranslateAnimation traslacion=new TranslateAnimation(rp,1f,rp,0f,rp,0f,rp,0f);
        traslacion.setDuration(3000);

        LayoutAnimationController la=new LayoutAnimationController(traslacion);
        la.setDelay(1);
        la.setOrder(LayoutAnimationController.ORDER_NORMAL);

        RelativeLayout ll = (RelativeLayout)findViewById(R.id.activity_third);
        ll.setLayoutAnimation(la);
        ll.setLayoutAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        int rs= RotateAnimation.RELATIVE_TO_SELF;
        RotateAnimation rotacion =new RotateAnimation(0,360,rs,0.5f,rs,0.5f);
        rotacion.setDuration(3000);
        TextView tv=(TextView)findViewById(R.id.texto);
        tv.setText("Eso no es todo");
        tv.startAnimation(rotacion);
    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
