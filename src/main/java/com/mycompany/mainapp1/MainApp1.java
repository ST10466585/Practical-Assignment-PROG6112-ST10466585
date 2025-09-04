/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainapp1;

import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author USER-PC
 */
public class MainApp1 {
    static ArrayList<Series> seriesList = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //(Farrell, 2023)
        SeriesManager manager = new SeriesManager();
        String menu = "1. Capture Series\n"
                    + "2. Search Series\n"
                    + "3. Update Series\n"
                    + "4. Delete Series\n"
                    + "5. Print Report\n"
                    + "6. Exit";

        while (true) {
            String choice = JOptionPane.showInputDialog(menu);

            if (choice == null || choice.equals("6")) {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                break;
            }
            //this is the switch case nedded
            switch (choice) {
                case "1":
                    manager.captureSeries();
                    break;
                case "2":
                    String idSearch = JOptionPane.showInputDialog("Enter Series ID to search:");
                    manager.searchSeries(idSearch);
                    break;
                    
                case "3":
                    String idUpdate = JOptionPane.showInputDialog("Enter Series ID to update:");
                    manager.updateSeries(idUpdate);
                    break;
                case "4":
                    String idDelete = JOptionPane.showInputDialog("Enter Series ID to delete:");
                    manager.deleteSeries(idDelete);
                    break;
                case "5":
                    
                    manager.printReport();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
        }
    }
}

/*Bibliography
1.Farrel, J. 2024. Java Programming, 26 September 2024. [Accessed 24 May 2025]
*/
