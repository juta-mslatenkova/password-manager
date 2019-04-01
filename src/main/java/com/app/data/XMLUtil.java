package com.app.data;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * class aimed to connect to the database
 */

public class DatabaseHelper {

    public static DocumentBuilder builder;
    public static Document document;
    public static File xmlFile = new File("src/main/resources/logins-passwords.xml"); //xml-database file location
    public static Element root; // get root node (element) from the xml ("log-pass" in our case)

    // private constructor protects class from being instantiated in other classes
    private DatabaseHelper() {
    }

    // instantiate a new document from an xml file
    public static void parseXML() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(xmlFile);
            root = document.getDocumentElement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void saveDataToXML(){
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            Result output = new StreamResult(xmlFile);
            Source input = new DOMSource(document);
            transformer.transform(input, output);
        } catch (TransformerConfigurationException exception) {
            exception.printStackTrace();
        } catch (TransformerException exception2) {
            exception2.printStackTrace();
        }

    }
}

