/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Pawan
 */
class MyHandler extends DefaultHandler{
    ArrayList<Movie> movieList=null;
     StringBuilder sb;
     Movie m;
     String tag;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       // super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
        if(qName.equalsIgnoreCase("movie")){
            m=new Movie();
            m.id=attributes.getValue("id");
            if(movieList==null)
                movieList=new ArrayList<>();
        }
        else{
            tag=qName;
        }
        sb=new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
       // super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
           if(tag.equalsIgnoreCase("name")){
               m.name=sb.toString().trim();
           }
           else if(tag.equalsIgnoreCase("year")){
                m.year=Integer.parseInt(sb.toString().trim());
           }
            else if(tag.equalsIgnoreCase("genre")){
                m.genre=sb.toString().trim();
           }
           if(qName.equalsIgnoreCase("movie")){
                    movieList.add(m);
           }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       // super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
        sb.append(new String(ch,start,length));
    }
    
    
}
public class SAX_Parser {
    public static void main(String[] args) {
        try {
            File file=new File("src/XML/Movies.xml");
            SAXParserFactory factory=SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser=factory.newSAXParser();
            MyHandler handler=new MyHandler();
            parser.parse(file, handler);
            System.out.println(handler.movieList);
                    
                    
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
       
                
    }
}
