package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.example.firstproject.view.MainActivity;


public class LoginPage extends AppCompatActivity {

        EditText username = findViewById(R.id.login);
        EditText password = findViewById(R.id.Password);
        TextView tx1 = findViewById(R.id.attemptsColor);
        Button Connect = findViewById(R.id.Login);
        int counter =3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        tx1.setVisibility(View.GONE);
    }

    public void login(View view)
    {
        if(username.getText().toString().equals("admin")&&password.getText().toString().equals("admin"))
        {
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
            Intent mainInt = new Intent(this, MainActivity.class);
            startActivity(mainInt);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Wrong credentials",Toast.LENGTH_SHORT).show();
            tx1.setVisibility(View.VISIBLE);
            tx1.setBackgroundColor(Color.RED);
            counter--;
            tx1.setText(Integer.toString(counter));
            if (counter==0)
            {
                Connect.setEnabled(false);
            }
        }
    }
}
