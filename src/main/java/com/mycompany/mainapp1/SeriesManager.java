/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp1;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author USER-PC
 */
public class SeriesManager {
    private ArrayList<Series> seriesList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);


    // Adding series
    //(Farrell, 2023)
    public void captureSeries() {
        String id = JOptionPane.showInputDialog("Enter Series ID:");
        String name = JOptionPane.showInputDialog("Enter Series Name:");
        String genre = JOptionPane.showInputDialog("Enter Series Genre:");
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter Release Year:"));

        Series s = new Series(id, name, genre, year);
        seriesList.add(s);

        JOptionPane.showMessageDialog(null, "Series added successfully!");
    }

    // method to Search by ID
    //(Farrell, 2023)
    public Series searchSeries(String id) {
        for (Series s : seriesList) {
            if (s.getId().equalsIgnoreCase(id)) {
                JOptionPane.showMessageDialog(null, s.toString());
                return s;
            }
        }
        JOptionPane.showMessageDialog(null, "Series not found!");
        return null;
    }

    // method to Update by ID
    //(Farrell, 2023)
    public void updateSeries(String id) {
        Series s = searchSeries(id);
        if (s != null) {
            String newName = JOptionPane.showInputDialog("Enter new name:", s.getName());
            String newGenre = JOptionPane.showInputDialog("Enter new genre:", s.getGenre());
            int newYear = Integer.parseInt(JOptionPane.showInputDialog("Enter new year:", s.getYear()));

            s.setName(newName);
            s.setGenre(newGenre);
            s.setYear(newYear);

            JOptionPane.showMessageDialog(null, "Series updated successfully!");
        }
    }

    // method to Delete by ID
    //(Farrell, 2023)
    public void deleteSeries(String id) {
        Series s = searchSeries(id);
        if (s != null) {
            seriesList.remove(s);
            JOptionPane.showMessageDialog(null, "Series deleted successfully!");
        }
    }

    // method to Print all
    //(Farrell, 2023)
    public void printReport() {
        StringBuilder report = new StringBuilder("All Series:\n");
        for (Series s : seriesList) {
            report.append(s.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
    
    public void captureSeries(Series s) {
    seriesList.add(s);
}
    
    // method to Update directly
    //(Farrell, 2023)
    public boolean updateSeriesDirect(String id, String newName, String newGenre, int newYear) {
    Series s = searchSeries(id);
    if (s != null) {
        s.setName(newName);
        s.setGenre(newGenre);
        s.setYear(newYear);
        return true;
    }
    return false;
}

    // method to make Age restriction check
    //(Farrell, 2023)
    public boolean isAgeRestrictionValid(int releaseYear, int minAge, int currentYear) {
    return (currentYear - releaseYear) >= minAge;
    }
}
