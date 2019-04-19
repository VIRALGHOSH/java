/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

/**
 *
 * @author Viral
 */
public class Movie {
    String id,name,genre;
    int year;

    public Movie() {
        id="M000";
        name=genre="";
        year=2000;
    }

    public Movie(String id, String name, String genre, int year) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", genre=" + genre + ", year=" + year + '}';
    }
    
    
}
