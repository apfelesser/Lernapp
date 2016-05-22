package com.example.sussan.training2.app;

import java.util.ArrayList;

/**
 * Created by Sussan on 21.05.2016.
 */
public class MenuModel {

/**************************** create MenuMpdel *******************************/
    private static MenuModel menuModel;

    ArrayList<Subject> subjects;

    public static MenuModel getMenuModel()
    {
        if(menuModel != null){
            return menuModel;
        }
        else{
            menuModel = new MenuModel();

            return menuModel;
        }
    }

    public MenuModel() {
        subjects = new ArrayList<Subject>();
    }

    void setSubject(String subjectName)
    {
        subjects.add(new Subject(subjectName));
    }

/**************************** MenuMpdel-Functions ****************************/
    ArrayList<String> getSubjects() {
        ArrayList<String> subjectNames = new ArrayList<String>();

        if (!subjects.isEmpty()) {
            for (Subject s : subjects) {
                subjectNames.add(s.getName());
            }
        }

        return subjectNames;
    }

    void deleteSubject(String subjectName)
    {
        for (Subject s : subjects) {
            if(subjectName.equals(s.getName()))
            {
                subjects.remove(subjects.indexOf(s));
                break;
            }
        }
    }

    ArrayList<String> getChapters(String subjectName)
    {
        ArrayList<String> chapterNames = new ArrayList<String>();

        for (Subject s : subjects) {
            if(subjectName.equals(s.getName()))
            {
                for(Chapter c : s.getChapterList())
                {
                    chapterNames.add(c.getName());
                }
            }
            break;
        }
        return chapterNames;
    }

    void setChapter(String subjectName, String chapterName)
    {
        for (Subject s : subjects) {
            if(subjectName.equals(s.getName()))
            {
                s.setChapter(new Chapter(chapterName));
                break;
            }
        }
    }

    void deleteChapter(String subjectName, String chapterName)
    {
        for (Subject s : subjects) {
            if(subjectName.equals(s.getName()))
            {
                for(Chapter c : s.getChapterList())
                {
                    if(chapterName.equals(c.getName()))
                    {
                        s.deleteChapter(c);
                        break;
                    }
                }
                break;
            }
        }
    }

/**************************** setDummyValues *********************************/
    void setDummyValues()
    {
        setSubject("Digitaltechnik");
        setSubject("Mathe");
        setSubject("Physik");
        setSubject("Betriebssysteme");

        setChapter("Digitaltechnik", "FlipFlops");
        setChapter("Digitaltechnik", "TTL");
        setChapter("Digitaltechnik", "Zahlensysteme");

        setChapter("Mathe", "Reihen");

        setChapter("Physik", "Mechanik");

        setChapter("Betriebssysteme", "Scheduling-Algorithmus");
        setChapter("Betriebssysteme", "Paging");
        setChapter("Betriebssysteme", "Prozesse und Threads");
        setChapter("Betriebssysteme", "Linux");
    }

/**************************  Subject  ****************************************/
    private class Subject
    {
        String name;
        ArrayList<Chapter> chapters;

        Subject(String p_name)
        {
            setName(p_name);
            chapters = new ArrayList<Chapter>();
        }

        void setName(String p_name)
        {
            name = p_name;
        }

        String getName()
        {
            return name;
        }

        ArrayList<Chapter> getChapterList()
        {
            return chapters;
        }

        void setChapter(Chapter chapter)
        {
            chapters.add(chapter);
        }

        void deleteChapter(Chapter chapter)
        {
            chapters.remove(chapters.indexOf(chapter));
        }
    }

/**************************  Chapter  ****************************************/
    private class Chapter
    {
        String name;

        Chapter(String p_name)
        {
            setName(p_name);
        }

        void setName(String p_name)
        {
            name = p_name;
        }

        String getName()
        {
            return name;
        }
    }

    private class LearningUnit
    {

    }
}
