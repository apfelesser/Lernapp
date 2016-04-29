package com.example.sussan.training2.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubjectFragment extends Fragment {

    MenuHierachyModel menuHierachyModel;

    // Der ArrayAdapter ist jetzt eine Membervariable der Klasse SubjectFragment
    ArrayAdapter<String> mSubjectlisteAdapter;

    public SubjectFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Menü bekannt geben, dadurch kann unser Fragment Menü-Events verarbeiten
        setHasOptionsMenu(false);

        menuHierachyModel = MenuHierachyModel.getMenuHierachyModel();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ArrayList<String> subjectList = menuHierachyModel.getSubjectNames();

        mSubjectlisteAdapter = new ArrayAdapter<>(
                getActivity(), // Die aktuelle Umgebung (diese Activity)
                R.layout.list_item_subject, // ID der XML-Layout Datei
                R.id.list_item_aktienliste_textview, // ID des TextViews
                subjectList); // Beispieldaten in einer ArrayList

        View rootView = inflater.inflate(R.layout.fragment_subject, container, false);

        ListView subjectlisteListView = (ListView) rootView.findViewById(R.id.listview_subjectliste);
        subjectlisteListView.setAdapter(mSubjectlisteAdapter);

        return rootView;
    }


}