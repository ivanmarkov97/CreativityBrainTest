package com.example.creativitybraintest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


      /*  ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setBackgroundResource(R.drawable.animation);

        final AnimationDrawable mAnimationDrawble = (AnimationDrawable) imageView.getBackground();*/

        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                   // mAnimationDrawble.start();
                    sleep(5000);

                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally {
                   // mAnimationDrawble.stop();
                    Intent intent = new Intent(SplashActivity.this, InputActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }

}
