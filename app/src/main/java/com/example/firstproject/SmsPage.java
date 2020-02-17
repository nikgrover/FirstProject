package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Bundle;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firstproject.view.MainActivity;


public class SmsPage extends AppCompatActivity {

    EditText phone;
    EditText sms;
    String Phoneno;
    String text;
    Button sendSms;

    Intent smsIntent = new Intent(Intent.ACTION_VIEW);

    private static final int MY_PERMISSION_REQ_SMS =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_page);

        sendSms = findViewById(R.id.send);
        phone = findViewById(R.id.Phone);
        sms = findViewById(R.id.SMS);

        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
             SendSms();
            }
        });
    }

    protected void SendSms() {
        Phoneno = phone.getText().toString();
        text = sms.getText().toString();
        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", new String("1234567890"));
        smsIntent.putExtra("sms_body", "Test Sms to MAD315");

      /*  if(ContextCompat.checkSelfPermission(this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS))
            {}
            else
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},MY_PERMISSION_REQ_SMS);
            }
        }
    }

    public void onRequestPermissionResult(int reqCode,String perm[],int[] grantResult)
    {
        switch (reqCode)
        {
            case MY_PERMISSION_REQ_SMS:
            {
                if(grantResult.length>0 && grantResult[0] == PackageManager.PERMISSION_GRANTED)
                {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(Phoneno,null,text,null,null);
                    Toast.makeText(getApplicationContext(),"SMS send",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"SMS FAILED PLEASE TRY AGAIN.",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
*/
    }

}
