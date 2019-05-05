/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import components.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import logic.*;

/**
 *
 * @author vipy
 */
public class OperationsJUnitTest {

    Operations o;
    Species test;

    public OperationsJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        o = new Operations();
        test = new Species("aaaa", "bbbb");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateNewSpecies() {
        Species test = o.createNewSpecies("koivu", "Betula pubescens rubra");
        assertEquals("koivu", test.getFinnishName());
        assertEquals("Betula pubescens rubra", test.getLatinName());

    }

    @Test
    public void testCreateNewSpeciesFullData() {
        GrowingMedia gm10 = new GrowingMedia(7, 7, 7, 7, 7);
        Species test = o.createNewSpeciesFullData("testFin", "Test testins",
                "xx", 40.5, 1.8, 0.6, gm10);
        assertEquals("testFin", test.getFinnishName());
        assertEquals("Test testins", test.getLatinName());
        assertEquals("xx", test.getZone());
        assertEquals("Te te", test.getAcronym());
        assertEquals(40.5, test.getAdultHeight(), 0.001);
        assertEquals(1.8, test.getSpacing(), 0.001);
        assertEquals(0.6, test.getAmountPerSquare(), 0.001);
        assertEquals(gm10, test.getGrowMedia());
        assertEquals("generic", test.getPlantType().getName());

    }

    @Test
    public void testWriteSpeciesToFile() {

    }

    @Test
    public void testSpeciesSearchLatin() throws FileNotFoundException {
        String latinName = "Test testins";
        o.readDataFromFile("./src/main/resources/Pensasluettelo.csv");

        ArrayList<Species> testList = o.speciesSearchLatin(latinName);
        System.out.println("-------->Testi testSpeciesSearchLatin : listan koko " + testList.size());
        if (testList.isEmpty()) {
            fail("Latin name was not found.");
        }
//        System.out.println(testList.get(0));
//        System.out.println(testList.get(0).getLatinName());
        assertEquals(latinName, testList.get(0).getLatinName());

    }

    @Test
    public void testSpeciesSearchFin() throws FileNotFoundException {
        String finName = "mustilanhortensia";
        o.readDataFromFile("./src/main/resources/Pensasluettelo.csv");
        ArrayList<Species> testList = o.speciesSearchFin(finName);
        System.out.println("-------->Testi testSpeciesSearchFin : listan koko " + testList.size());
        if (testList.isEmpty()) {
            fail("Finnish name was not found.");
        }
        assertEquals(finName, testList.get(0).getFinnishName());

    }

    @Test
    public void testSpeciesSearch() {
        Species test = o.createNewSpeciesFullData("testFin", "Test testins",
                "xx", 40.5, 1.8, 0.6, new GrowingMedia(7, 7, 7, 7, 7));
        GrowingMedia gm4 = new GrowingMedia(7, 7, 7, 7, 7);
        ArrayList<Species> testList = o.speciesSearch(gm4);
        System.out.println("-------->Testi testSpeciesSearch : listan koko " + testList.size());
        assertEquals(test.getGrowMedia(), testList.get(0).getGrowMedia());

    }

    @Test
    public void testreadDataFromFile() throws FileNotFoundException {
        o.readDataFromFile("./src/main/resources/Pensasluettelo.csv");
        ArrayList<Species> lista = o.getPlants();
        boolean findsTheList = (lista.size() > 0);

        assertEquals(true, findsTheList);
    }
}
