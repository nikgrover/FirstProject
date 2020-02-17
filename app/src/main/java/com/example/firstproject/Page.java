package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.firstproject.view.MainActivity;

public class Page extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.FirstProject.EXTRA_MESSAGE";
    private EditText mMessageEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

    }

    public void LaunchThirdActivity(View view) {
        Log.d(LOG_TAG,"my send button is clicked");
        Intent intent = new Intent(this, ThirdActivity.class);
        mMessageEditText = findViewById(R.id.editText_main);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}
