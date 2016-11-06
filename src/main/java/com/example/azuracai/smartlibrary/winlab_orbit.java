package com.example.azuracai.smartlibrary;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.Scanner;
import java.io.File;

public class winlab_orbit extends AppCompatActivity {

    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winlab_orbit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView)findViewById(R.id.seat);

        Scanner s = new Scanner(this.getResources().openRawResource(R.raw.a));

        if (Integer.parseInt(s.next()) == 1){
            textView.setBackgroundColor(Color.RED);
        }

        s.close();

    }

}
