package com.example.sussan.training2.app;

import java.util.ArrayList;

/**
 * Created by Sussan on 29.04.2016.
 */
public interface operateOnHierachyModel {
    ArrayList<String> getSubjectList();
    void setSubject(String subject);
    void deleteSubject(String subject);
    void editSubject(String subject);

    ArrayList<String> getChapterList(String subject);
    void setChapter(String subject, String chapter);
    void deleteChapter(String subject, String chapter);
    void editChapter(String subject, String chapter);
}
