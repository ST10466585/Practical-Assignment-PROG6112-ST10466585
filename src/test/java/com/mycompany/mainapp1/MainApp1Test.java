/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mainapp1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author USER-PC
 */
public class MainApp1Test {
    
   // Helper method to create a manager with the default test data
    //(Farrell, 2023)
    private SeriesManager createManagerWithData() {
        SeriesManager manager = new SeriesManager();
        manager.captureSeries(new Series("S001", "Breaking Bad", "Crime", 2008));
        manager.captureSeries(new Series("S002", "Stranger Things", "Sci-Fi", 2016));
        return manager;
    }

    // 1. Testing the  Search which is Found)
    //(Farrell, 2023)
    @Test
    public void TestSearchSeries() {
        SeriesManager manager = createManagerWithData();
        Series result = manager.searchSeries("S001");
        assertNotNull(result);
        assertEquals("Breaking Bad", result.getName());
    }

    // 2. Testing the Search which is Not Found)
    //(Farrell, 2023)
    @Test
    public void TestSearchSeries_SeriesNotFound() {
        SeriesManager manager = createManagerWithData();
        Series result = manager.searchSeries("S999");
        assertNull(result);
    }

    // 3. Testing the Update which is a Success)
    //(Farrell, 2023)
    @Test
    public void TestUpdateSeries() {
        SeriesManager manager = createManagerWithData();
        boolean updated = manager.updateSeriesDirect("S001", "Better Call Saul", "Drama", 2015);
        assertTrue(updated);

        Series after = manager.searchSeries("S001");
        assertEquals("Better Call Saul", after.getName());
        assertEquals("Drama", after.getGenre());
        assertEquals(2015, after.getYear());
    }

    // 4. Testing the Delete which is Success)
    //(Farrell, 2023)
    @Test
    public void TestDeleteSeries() {
        SeriesManager manager = createManagerWithData();
        manager.deleteSeries("S002");
        Series deleted = manager.searchSeries("S002");
        assertNull(deleted);
    }

    // 5. Testing the Delete which is Not Found)
    //(Farrell, 2023)
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        SeriesManager manager = createManagerWithData();
        manager.deleteSeries("S999"); // should not crash
        assertNull(manager.searchSeries("S999"));
    }

    // 6. Testing the Age Restrictions which are Valid
    //(Farrell, 2023)
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        SeriesManager manager = new SeriesManager();
        boolean isValid = manager.isAgeRestrictionValid(2018, 5, 2024);
        assertTrue(isValid);
    }

    // 7. Testing the Age Restrictions here that are invalid
    //(Farrell, 2023)
    @Test
    public void TestSeriesAgeRestriction_AgeInValid() {
        SeriesManager manager = new SeriesManager();
        boolean isValid = manager.isAgeRestrictionValid(2020, 10, 2024);
        assertFalse(isValid);
    }
    
}
