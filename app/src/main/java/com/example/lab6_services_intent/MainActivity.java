package com.example.lab6_services_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lab6_services_intent.DemoService;
import com.example.lab6_services_intent.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartClicked(View view) {
        DemoService.startActionDemo(this, "Goodbye, I am done running!");
    }

    public void onStopClicked(View view){
        //Intent intent = new Intent(MainActivity.this, DemoService.class);
        //stopService(intent);
    }


}