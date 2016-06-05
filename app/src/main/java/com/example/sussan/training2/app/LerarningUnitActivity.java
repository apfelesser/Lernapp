package com.example.sussan.training2.app;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;

import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * Created by Sussan on 03.05.2016.
 */
public class LerarningUnitActivity extends AppCompatActivity {
    SchematicModeLearning s;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learningunit_layout);

        s = new SchematicModeLearning(this);
        s.dummy();

        LinearLayout subjectlisteListView = (LinearLayout) findViewById(R.id.learningunit);
        subjectlisteListView.addView(s);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.e("onStart",  " s.getHeight()" +  s.getHeight());
        Log.e("onStart",  " s.getHeight()" +  s.getMeasuredHeight());
        Log.e("onStart",  " s.getHeight()" +  s.getX());
    }
}
