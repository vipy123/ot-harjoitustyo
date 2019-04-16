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
import dynamicPlanting.*;

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

    }

    @Test
    public void testreadDataFromFile() throws FileNotFoundException {
        o.readDataFromFile("./src/main/resources/Pensasluettelo.csv");
        ArrayList<Species> lista = o.getPlants();
        assertEquals("kääpiöpalsamipihta", lista.get(0).getFinnishName());
    }
}
