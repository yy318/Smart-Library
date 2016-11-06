package com.example.azuracai.smartlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class second_activity extends AppCompatActivity {
    private static Button WINLAB_sbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnClickButtonListener();
    }

    public void OnClickButtonListener(){
        WINLAB_sbm = (Button)findViewById(R.id.WINLAB);
        WINLAB_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("com.example.azuracai.smartlibrary.Winlab_Layout");
                        startActivity(intent);
                    }
                }
        );

    }

}
