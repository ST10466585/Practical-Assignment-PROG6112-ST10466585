/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp1;

/**
 *
 * @author USER-PC
 */
public class Series {
    
    //naming variables
    private String id;
    private String name;
    private String genre;
    private int year;
    
    
    //(Farrell, 2023)
    public Series(String id, String name, String genre, int year) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.year = year;
    }
    
    //the setter and getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }

    public void setName(String name) { this.name = name; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setYear(int year) { this.year = year; }
    
    //(Farrell, 2023)
    @Override
    public String toString() {
        return "Series ID: " + id +
               ", Name: " + name +
               ", Genre: " + genre +
               ", Year: " + year;
    }
}
