
package com.example.firstproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import  android.net.Uri;


import com.example.firstproject.LoginPage;
import com.example.firstproject.Page;
import com.example.firstproject.R;
import com.example.firstproject.SmsPage;
import com.example.firstproject.model.Formula;

import java.util.logging.Filter;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    Button button_cal ;
    Button button_sms;
    EditText qty;
    TextView pr, tx, ttl;
    double taxes, price;
    int quantity;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         onstart();
        button_cal = findViewById(R.id.buttonCalculate);
        button_sms = findViewById(R.id.buttonSms);
        pr = findViewById(R.id.textViewPrice);
        qty = findViewById(R.id.editQty);
        tx = findViewById(R.id.textViewTax);
        ttl = findViewById(R.id.textViewTtl);
        RadioGroup rg = findViewById(R.id.RadioGroup);




        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                RadioButton radio = findViewById(checkedID);
                String radioText = radio.getText().toString();
                if (radioText.equalsIgnoreCase("Car")){
                    Toast.makeText(MainActivity.this,radioText,Toast.LENGTH_SHORT).show();
                    pr.setText("25000");
                    pr.getText();
                }else if (radioText.equalsIgnoreCase("Plane")) {
                    Toast.makeText(MainActivity.this, radioText, Toast.LENGTH_SHORT).show();
                    pr.setText("9500000");
                    pr.getText();
                }else
                    {
                    if (radioText.equalsIgnoreCase("Boat"))
                        {
                            Toast.makeText(MainActivity.this,radioText,Toast.LENGTH_SHORT).show();
                            pr.setText("145500");
                            pr.getText();
                        }
                    }
                    if (radioText.equalsIgnoreCase("bike")) {
                        Toast.makeText(MainActivity.this, radioText, Toast.LENGTH_SHORT).show();
                        pr.setText("10000");
                        pr.getText();
                    }


            }
        });

    }

    private void onstart()
    {
        Intent login = new Intent(this, LoginPage.class);
        startActivity(login);

    }

    public void launchPage(View view)
            {

                Log.d(LOG_TAG,"MY SEND BUTTON is clicked by the user");
                Intent intent = new Intent(this , Page.class);
                startActivity(intent);
            }


    public void Calculate(View view)
    {

        int quantity = Integer.parseInt(qty.getText().toString());
        price = Double.parseDouble(pr.getText().toString());
        Log.d(LOG_TAG,"MY SEND BUTTON is clicked by the user " + quantity + " uprice" + pr.getText().toString());
        //Intent intent = new Intent(this , Page.class);
        //startActivity(intent);
        Formula formula = new Formula(price,quantity);
        double totalValue = formula.getTotal();
        double taxes = formula.getTaxes();
        tx.setText(""+taxes);
        ttl.setText(""+totalValue);




    }

    public void SMS(View view)
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this);

            Intent sendSms = new Intent(Intent.ACTION_SEND);
            sendSms.setType("text/plain");
            sendSms.putExtra(Intent.EXTRA_TEXT,"text");

            if(defaultSmsPackageName != null)
            {
                sendSms.setPackage(defaultSmsPackageName);
            }
            startActivity(sendSms);
        }
        else
        {
            Intent sendSms = new Intent(Intent.ACTION_VIEW);
            sendSms.setType("vnd.android-dir/mms-sms");
            sendSms.putExtra("address","phoneNumber");
            sendSms.putExtra("sms_body","message");
            startActivity(sendSms);
        }
    }

    public void mail(View view)
    {
        Log.i("send email","");
        String[] TO = {"",""};
        String[] CC = {"",""};
        Intent emailInt = new Intent(Intent.ACTION_SEND);

        emailInt.setData(Uri.parse("mailto:"));
        emailInt.setType("text/plain");
        emailInt.putExtra(Intent.EXTRA_EMAIL,TO);
        emailInt.putExtra(Intent.EXTRA_CC,CC);
        emailInt.putExtra(Intent.EXTRA_SUBJECT,"your subject");
        emailInt.putExtra(Intent.EXTRA_TEXT,"email message goes here");

            try
                {
                    startActivity(Intent.createChooser(emailInt,"Send mail"));
                    finish();
                    Log.i("Finished sending email","");
                }
            catch (android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(MainActivity.this,"there is no mail client installed",Toast.LENGTH_SHORT).show();
                }
    }

    public void Call(View view)
    {
        Intent callInt = new Intent(Intent.ACTION_CALL);
        callInt.setData(Uri.parse("tel:5142752285"));

        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        startActivity(callInt);
    }
}