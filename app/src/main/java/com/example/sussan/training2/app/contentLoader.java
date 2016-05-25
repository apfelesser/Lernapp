package com.example.sussan.training2.app;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Sussan on 24.05.2016.
 */
public class ContentLoader {

    private String MenueFileName = "menueHierachy.xml";

    private Document menu;
    private ArrayList<Document> LearningUnits;

    ContentLoader()
    {
        getAllFiles();
    }

    private void getAllFiles()
    {
        File folder = new File("/storage/emulated/0/Pictures/Lernapp/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles)
        {
            if (file.isFile()) {
                System.out.println(file.getName());

                try {
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(file);

                    if(file.getName().equals(MenueFileName))
                    {
                        menu = doc;
                    }
                    if(file.getName().equals("README")) {}
                    else
                    {
                        if(LearningUnits != null)
                        {
                            LearningUnits = new ArrayList<Document>();
                        }
                        else
                        {
                            LearningUnits.add(doc);
                        }
                    }

                }
                catch(Exception e)
                {

                }
            }
        }
    }

    public ArrayList<String> getAllSubjects()
    {
        ArrayList<String> subjects = new ArrayList<String>();

        NodeList nListSubject = menu.getElementsByTagName("subject");

        for (int countSubjects = 0; countSubjects < nListSubject.getLength(); countSubjects++) {

            Node nNodeSubject = nListSubject.item(countSubjects);

            if (nNodeSubject.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNodeSubject;
                subjects.add(eElement.getAttribute("name"));
            }
        }
        return subjects;
    }

    public ArrayList<String> getAllChaptersOfSubject(String subject) {
        ArrayList<String> chapters = new ArrayList<String>();

        NodeList nListSubject = menu.getElementsByTagName("subject");

        for (int countSubjects = 0; countSubjects < nListSubject.getLength(); countSubjects++) {

            Node nNodeSubject = nListSubject.item(countSubjects);

            if (nNodeSubject.getNodeType() == Node.ELEMENT_NODE) {

                Element sElement = (Element) nNodeSubject;

                if (sElement.getAttribute("name").equals(subject)) {
                    NodeList nListSChapter = sElement.getElementsByTagName("chapter");

                    for (int countChapters = 0; countChapters < nListSubject.getLength(); countChapters++) {

                        Node nNodeChapter = nListSubject.item(countChapters);

                        if (nNodeSubject.getNodeType() == Node.ELEMENT_NODE) {

                            Element cElement = (Element) nNodeSubject;

                            chapters.add(cElement.getAttribute("name"));
                        }
                    }


                    break;
                }
            }

        }
        return chapters;
    }

    public void setSubject(String subject)
    {
        if( !getAllSubjects().contains(subject)) {
            Element menueElement = menu.getDocumentElement();

            Element subjectElement = menu.createElement("subject");
            menueElement.appendChild(subjectElement);

            subjectElement.setAttribute("name", subject);
        }
        else
        {
            //TODO
        }
    }

    public void setChapter(String subject, String chapter)
    {
        if(getAllSubjects().contains(subject))
        {
            NodeList nListSubject = menu.getElementsByTagName("subject");

            for (int countSubjects = 0; countSubjects < nListSubject.getLength(); countSubjects++) {

                Node nNodeSubject = nListSubject.item(countSubjects);

                if (nNodeSubject.getNodeType() == Node.ELEMENT_NODE) {

                    Element sElement = (Element) nNodeSubject;
                    if(sElement.getAttribute("name").equals(subject))
                    {
                        if(!getAllChaptersOfSubject(subject).contains(chapter))
                        {
                            Element chapterElement = menu.createElement("chapter");
                            sElement.appendChild(chapterElement);
                            break;
                        }
                    }

                }
            }

        }
        else
        {
            // neues Subject und Chapter anlegen
            Element menueElement = menu.getDocumentElement();

            Element subjectElement = menu.createElement("subject");
            menueElement.appendChild(subjectElement);

            subjectElement.setAttribute("name", subject);

            Element chapterElement = menu.createElement("chapter");
            subjectElement.appendChild(chapterElement);

            chapterElement.setAttribute("name", chapter);
        }

    }

    private Document getLearningUnit(String subject, String chapter, String LearningUnit)
    {
        for(Document docLearningUnit : LearningUnits)
        {
            NodeList nListSubjects = docLearningUnit.getElementsByTagName("BelongsToSubject");
            Node nNodeSubject = nListSubjects.item(0);
            if (nNodeSubject.getNodeType() == Node.ELEMENT_NODE) {

                Element sElement = (Element) nNodeSubject;
                if(sElement.getAttribute("name").equals(subject))
                {
                    NodeList nListChapters = sElement.getElementsByTagName("BelongsToChapter");
                    Node nNodeChapter = nListChapters.item(0);
                    Element cElement = (Element) nNodeChapter;

                    if(cElement.getAttribute("name").equals(chapter))
                    {
                        return docLearningUnit;
                    }
                }
            }

        }

        return null;
    }

    /*
     ArrayList: Name der LearningUnit, Imagepath, Anzahl der Buttons, text, xpoistion, yposition, text, xposition, yposition...
     */
    public ArrayList getSchematicMode(String subject, String chapter, String LearningUnit)
    {
        Document docSchematic = getLearningUnit(subject, chapter, LearningUnit);

        ArrayList paramSchematic = new ArrayList();
        paramSchematic.add(docSchematic.getDocumentElement().getAttribute("name"));

        NodeList nListSchematic = menu.getElementsByTagName("Schematic");
        Node nSchematic = nListSchematic.item(0);

        if (nSchematic.getNodeType() == Node.ELEMENT_NODE) {

            Element schematicElement = (Element) nSchematic;

            paramSchematic.add(schematicElement.getElementsByTagName("Image").item(0).getTextContent());

            Element elettering = (Element)schematicElement.getElementsByTagName("Letterings").item(0);
            paramSchematic.add(elettering.getAttribute("number"));

            NodeList nListLettering = elettering.getElementsByTagName("Lettering");

            for (int countLettering = 0; countLettering < nListLettering.getLength(); countLettering++) {

                Node nNodeSubject = nListLettering.item(countLettering);

                if (nNodeSubject.getNodeType() == Node.ELEMENT_NODE) {

                    Element letteringElement = (Element) nNodeSubject;

                    paramSchematic.add(letteringElement.getElementsByTagName("name").item(0).getTextContent());
                    paramSchematic.add(letteringElement.getElementsByTagName("xposition").item(0).getTextContent());
                    paramSchematic.add(letteringElement.getElementsByTagName("yposition").item(0).getTextContent());
                }

            }
        }

        return paramSchematic;
    }
}
