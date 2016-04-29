package com.example.sussan.training2.app;

import java.util.ArrayList;
/**
 * Created by Sussan on 29.04.2016.
 */
public class MenuHierachyModel {

    private static MenuHierachyModel menuHierachyModel;

    ArrayList<Subject> subjects;
    ArrayList<String> subjectNames;

    public static MenuHierachyModel getMenuHierachyModel()
    {
        if(menuHierachyModel != null){
            return menuHierachyModel;
        }
        else{
            menuHierachyModel = new MenuHierachyModel();
            menuHierachyModel.subjects = new ArrayList<Subject>();
            menuHierachyModel.subjectNames = new ArrayList<String>();

            menuHierachyModel.DummyWerte();

            return menuHierachyModel;
        }
    }

    private void DummyWerte()
    {
        subjectNames.add("Mathe");
        subjectNames.add("Digitaltechnik");
        subjectNames.add("Physik");
        subjectNames.add("Latein");
    }

    public MenuHierachyModel() {}

    public void addSubject(String newSubject)
    {
        subjects.add(new Subject(newSubject));
    }

    public ArrayList<String> getSubjectNames()
    {
        return subjectNames;
    }
    private class Subject{
        private String name;

        ArrayList<Chapter> chapters;


        public Subject(String p_name)
        {
            name = p_name;
            subjectNames.add(name);
        }

        private Subject(){}

        public void addChapter(Chapter chapter){

        }

    }

    private class Chapter{

    }

    private class LearningUnit{

    }
}
