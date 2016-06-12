package com.example.sussan.training2.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

// TODO any settings?
public class SubjectActivity  extends AppCompatActivity {
    //MenuHierachyModel menuHierachyModel;
    // Der ArrayAdapter ist jetzt eine Membervariable der Klasse SubjectFragment
    ArrayAdapter<String> mSubjectlisteAdapter;

    private MenuModel menuModel;
    ArrayList<String> subjectList;

    private AccessoriesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

/***************************** init Model ************************************/

/*****************************************************************************/

        Toolbar subjectToolbar = (Toolbar) findViewById(R.id.subject_actionbar);
        setSupportActionBar(subjectToolbar);


        menuModel = MenuModel.getMenuModel();



        subjectList = menuModel.getSubjects();

/*        mSubjectlisteAdapter = new ArrayAdapter<>(
                this, // Die aktuelle Umgebung (diese Activity)
                R.layout.list_item_subject, // ID der XML-Layout Datei
                R.id.list_item_aktienliste_textview, // ID des TextViews
                subjectList); // Beispieldaten in einer ArrayList*/

        ListView subjectlisteListView = (ListView) findViewById(R.id.listview_subjectliste);
        //subjectlisteListView.setAdapter(mSubjectlisteAdapter);

        mAdapter = new AccessoriesAdapter();
        subjectlisteListView.setAdapter(mAdapter);




        subjectlisteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                einToast(item);
                Intent chapterScreen = new Intent(SubjectActivity.this, ChapterActivity.class);
                chapterScreen.putExtra("subjectName", item);
                startActivity(chapterScreen);
            }

        });

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
                menuModel.setSubject(edt.getText().toString());
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






    private static class AccessoriesViewHolder {

        public TextView content;
        public ImageButton b1;
        public Button b2;
    }

    private class AccessoriesAdapter extends BaseAdapter {

        @Override
        public int getCount() {
//            return CHEESES.length;
            return subjectList.size();
        }

        @Override
        public String getItem(int position) {
            //return CHEESES[position];
            return subjectList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            AccessoriesViewHolder holder = null;

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_subject, parent, false);

                holder = new AccessoriesViewHolder();

                holder.b1 = (ImageButton) convertView.findViewById(R.id.button_1);
                //holder.b2 = (Button) convertView.findViewById(R.id.button_2);
                holder.content = (TextView) convertView.findViewById(R.id.list_item_aktienliste_textview);

                holder.b1.setOnClickListener(mBuyButtonClickListener1);
                //holder.b2.setOnClickListener(mBuyButtonClickListener2);

                holder.b1.setLeft(10);

/*                ((Button) convertView.findViewById(R.id.button_1)).setOnClickListener(mBuyButtonClickListener1);
                ((Button) convertView.findViewById(R.id.button_2)).setOnClickListener(mBuyButtonClickListener2);*/

                convertView.setTag(holder);
            } else {
                holder = (AccessoriesViewHolder) convertView.getTag();
            }

            holder.content.setText(subjectList.get(position));

            return convertView;
        }
    }

    private void showMessage(String message) {
        Toast.makeText(SubjectActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private View.OnClickListener mBuyButtonClickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Cyril: Not implemented yet!
            showMessage("button1");
            einToast("button1");
        }
    };

    private View.OnClickListener mBuyButtonClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Cyril: Not implemented yet!
            showMessage("button2");
            einToast("button2");
        }
    };




}