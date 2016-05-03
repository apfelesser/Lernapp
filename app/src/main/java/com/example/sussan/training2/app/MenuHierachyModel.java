package com.example.sussan.training2.app;

import java.util.ArrayList;
/**
 * Created by Sussan on 29.04.2016.
 */
public class MenuHierachyModel implements operateOnHierachyModel{

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



    @Override
    public ArrayList<String> getSubjectList() {
        return subjectNames;
    }

    @Override
    public void setSubject(String subject) {
        subjects.add(new Subject(subject));

    }

    @Override
    public void deleteSubject(String subject) {
        int indexOfsubject = subjectNames.indexOf(subject);
        subjectNames.remove(indexOfsubject);
        subjects.remove(indexOfsubject);
    }

    @Override
    public void editSubject(String subject) {

    }

    @Override
    public ArrayList<String> getChapterList(String subject) {
        return null;
    }

    @Override
    public void setChapter(String subject, String chapter) {

    }

    @Override
    public void deleteChapter(String subject, String chapter) {

    }

    @Override
    public void editChapter(String subject, String chapter) {

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
