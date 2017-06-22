package com.example.chint.smsread;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chint on 6/8/2017.
 */

public class smsRead extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){

            Bundle b = intent.getExtras();
            Object[] pdusObj = (Object[]) b.get("pdus");

            for (int i = 0; i < pdusObj.length; i++) {

                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                //String senderNum = phoneNumber;
                String message = currentMessage.getDisplayMessageBody();
                if(phoneNumber.equals("+18102885071")) {

                    Pattern p = Pattern.compile("\\d{6}");
                   // Pattern p = Pattern.compile("\\d");
                    Matcher m = p.matcher(message);
                    String pin = "";

                    if (m.find())
                        pin = m.group(0);
                    else pin = "";
                    //Toast.makeText(context, "message" + pin, Toast.LENGTH_LONG).show();
                    String[] pinarray = pin.trim().split("");


                    //Toast.makeText(context, "messag" + pinarray[0]+"e", Toast.LENGTH_LONG).show();
                    MainActivity.pinnum1.setText(pinarray[1]);
                    MainActivity.pinnum2.setText(pinarray[2]);
                    MainActivity.pinnum3.setText(pinarray[3]);
                    MainActivity.pinnum4.setText(pinarray[4]);
                    MainActivity.pinnum5.setText(pinarray[5]);
                    MainActivity.pinnum6.setText(pinarray[6]);

                }
                //Toast.makeText(context, "message: " + message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
