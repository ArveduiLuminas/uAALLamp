package com.example.isen.firsttestaal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String PREFIX = "org.universaal.nativeandroid.forcerUAAL.";
    public static final String ACTION_CALL_OFF = PREFIX + "PUT_OFF";
    public static final String ACTION_CALL_ON = PREFIX + "PUT_ON";

    TextView monTexte = null;
    TextView isPaused = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onResume() {
        super.onResume();



        isPaused = (TextView)findViewById(R.id.Pause);
        isPaused.setText("j'ai bien été en pause");
    }

    public void onButtonPutON(View v) {
        Intent intent = new Intent("org.universaal.nativeandroid.forcerUAAL.PUT_ON");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra("lamp", "mylamp1");
        intent.putExtra("brightness", "100");

        if (intent.resolveActivity(getApplicationContext().getPackageManager())== null){
            isPaused = (TextView)findViewById(R.id.Pause);
            isPaused.setText("something was wrong");
        }
        else{
            isPaused = (TextView)findViewById(R.id.Pause);
            isPaused.setText("ok");
        }


        sendBroadcast(intent);


    }

    public void onButtonPutOFF(View v) {
        Intent intent = new Intent(ACTION_CALL_OFF);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        sendBroadcast(intent);
    }
}
