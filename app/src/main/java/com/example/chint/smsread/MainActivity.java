package com.example.chint.smsread;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    smsRead b;
    static EditText pinnum1, pinnum2, pinnum3, pinnum4, pinnum5, pinnum6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = new smsRead();
        pinnum1 = (EditText)findViewById(R.id.pin1);
        pinnum2 = (EditText)findViewById(R.id.pin2);
        pinnum3 = (EditText)findViewById(R.id.pin3);
        pinnum4 = (EditText)findViewById(R.id.pin4);
        pinnum5 = (EditText)findViewById(R.id.pin5);
        pinnum6 = (EditText)findViewById(R.id.pin6);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter i = new IntentFilter();
        i.addAction("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(b,i);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(b);
    }
}
