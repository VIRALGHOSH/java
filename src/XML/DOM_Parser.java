/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import java.io.File;
import static java.lang.System.*;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Viral
 */
public class DOM_Parser {
    public static void main(String[] args){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            File file = new File("src/XML/Movies.xml");
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = (Document)builder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("root element "+doc.getDocumentElement().getNodeName());
            NodeList nodlist = doc.getElementsByTagName("movie");
            ArrayList<Movie> movieList = new ArrayList<>();
            for (int i = 0; i < nodlist.getLength(); i++) {
               Node node = nodlist.item(i);
               if(node.getNodeType()==Node.ELEMENT_NODE){
                   Element e = (Element) node;
                   Movie m = new Movie();
                   m.id = e.getAttribute("id");
                   m.name = e.getElementsByTagName("name").item(0).getTextContent();
                   m.year = Integer.parseInt(e.getElementsByTagName("year").item(0).getTextContent());
                   m.genre = e.getElementsByTagName("genre").item(0).getTextContent();
                   movieList.add(m);
               }
            }
            for (int i = 0; i < movieList.size(); i++) {
                Movie movie = movieList.get(i);
                System.out.println(movie.name);
                out.println(movie.id +" " + movie.name + " " + movie.year + " "  + movie.genre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    }
}
