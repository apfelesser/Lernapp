package com.example.sussan.training2.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

// TODO any settings?
public class ChapterActivity  extends AppCompatActivity {

    MenuHierachyModel menuHierachyModel;
    // Der ArrayAdapter ist jetzt eine Membervariable der Klasse SubjectFragment
    ArrayAdapter<String> mChapterlisteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        Toolbar subjectToolbar = (Toolbar) findViewById(R.id.subject_actionbar);
        setSupportActionBar(subjectToolbar);


        menuHierachyModel = MenuHierachyModel.getMenuHierachyModel();

        // TODO
        ArrayList<String> chapterList = menuHierachyModel.getSubjectList();

        mChapterlisteAdapter = new ArrayAdapter<>(
                this, // Die aktuelle Umgebung (diese Activity)
                R.layout.list_item_subject, // ID der XML-Layout Datei
                R.id.list_item_aktienliste_textview, // ID des TextViews
                chapterList); // Beispieldaten in einer ArrayList

        GridView chapterlisteListView = (GridView) findViewById(R.id.gridview_chapterliste);
        chapterlisteListView.setAdapter(mChapterlisteAdapter);

        /*chapterlisteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                einToast(item);
                //startActivity(new Intent(ChapterActivity.this, ChapterActivity.class));
            }

        });*/

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
            einToast("Subject adden");
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

        dialogBuilder.setMessage("Gebe den Namen des Faches ein");
        dialogBuilder.setPositiveButton("Fach erstellen", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                menuHierachyModel.setSubject(edt.getText().toString());
            }
        });
        dialogBuilder.setNegativeButton("zurück", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }


    public void einToast(String text) {
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
    }

}
