package com.example.dam_bilet4_sesizare;

import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class XMLParser extends AsyncTask<String,Void, ArrayList<Sesizare>> {

    ArrayList<Sesizare> sesizares = new ArrayList<>();
    DateConverter dateConverter = new DateConverter();

    @Override
    protected ArrayList<Sesizare> doInBackground(String... strings) {

        URL url = null;
        try {
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = xmlPullParserFactory.newPullParser();
            url = new URL("https://pastebin.com/raw/wdDUhB06");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            int evType = 0;
            evType = parser.getEventType(); //evType - verifica daca a ajuns la final
            Sesizare sesizareCurr = null;
            while (evType != XmlPullParser.END_DOCUMENT) {
                String elNume = null;
                switch (evType) {
                    case XmlPullParser.START_TAG:
                        elNume = parser.getName();
                        if ("sesizare".equals(elNume)) {
                            sesizareCurr = new Sesizare();
                            sesizares.add(sesizareCurr);
                        } else if (sesizareCurr != null) {
                            if ("titlu".equals(elNume))
                                sesizareCurr.setTitlu(parser.nextText());
                            else if ("descriere".equals(elNume))
                                sesizareCurr.setDescriere(parser.nextText());
                            else if ("tip".equals(elNume))
                                sesizareCurr.setTip(dateConverter.EnumfromString(parser.nextText()));
                            else if ("dataInregistrarii".equals(elNume))
                                sesizareCurr.setDataInregistrarii(dateConverter.fromString(parser.nextText()));
                        }
                        break;
                }
                evType = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sesizares;
    }
}