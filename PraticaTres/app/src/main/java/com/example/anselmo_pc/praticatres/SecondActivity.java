package com.example.anselmo_pc.praticatres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv1=(TextView)findViewById(R.id.textouno);
        TextView tv=(TextView)findViewById(R.id.textView2);
        Animation td= AnimationUtils.loadAnimation(this,R.anim.aparicion);

        td.setRepeatMode(Animation.RESTART);
        td.setRepeatCount(20);
        tv.startAnimation(td);

        Button boton=(Button)findViewById(R.id.botondos);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
