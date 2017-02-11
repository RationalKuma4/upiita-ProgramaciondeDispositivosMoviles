package com.example.anselmo_pc.praticatres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView tv1=(TextView)findViewById(R.id.textotres);
        TextView tv=(TextView)findViewById(R.id.textoCuatro);
        Animation td= AnimationUtils.loadAnimation(this, R.anim.serie);
        td.setFillAfter(true);
        tv.startAnimation(td);
        Button boton=(Button)findViewById(R.id.botonTres);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });
    }
}
