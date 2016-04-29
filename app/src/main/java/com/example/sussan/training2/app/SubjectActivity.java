package com.example.sussan.training2.app;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

// TODO any settings?
public class SubjectActivity  extends AppCompatActivity {
    MenuHierachyModel menuHierachyModel;

   @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

       Toolbar subjectToolbar = (Toolbar) findViewById(R.id.subject_actionbar);
       setSupportActionBar(subjectToolbar);


       menuHierachyModel = MenuHierachyModel.getMenuHierachyModel();
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
            showDialogAddSubject();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showDialogAddSubject() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialogfragment_subject, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);

        dialogBuilder.setTitle("Custom dialog");
        dialogBuilder.setMessage("Enter text below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                menuHierachyModel.addSubject(edt.getText().toString());
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }


    public void einToast() {
        Toast toast = Toast.makeText(this, "Ich bin nur ein kleiner Toast... :)", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void addSubject(String newSubject)
    {

    }
}
