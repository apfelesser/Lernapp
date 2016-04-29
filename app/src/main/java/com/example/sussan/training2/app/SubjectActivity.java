package com.example.sussan.training2.app;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// TODO any settings?
public class SubjectActivity  extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

       Toolbar subjectToolbar = (Toolbar) findViewById(R.id.subject_actionbar);
       setSupportActionBar(subjectToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Handle action abr item clicks here. The action bar will
        // Automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml

        int id = item.getItemId();

        if(id == R.id.action_addSubject){
            einToast();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void einToast() {
        Toast toast = Toast.makeText(this, "Ich bin nur ein kleiner Toast... :)", Toast.LENGTH_SHORT);
        toast.show();
    }
}
