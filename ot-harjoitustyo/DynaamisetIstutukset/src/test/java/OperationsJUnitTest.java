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
    public Operations o;
    public OperationsJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Operations o = new Operations();
        Species test = new Species("aa", "bb");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testCreateNewSpecies() {
        assertEquals("Be_pu_ru", Operations.CreateNewSpecies("koivu", "Betula pubescens rubra"));
        
    }
    @Test
    public void testreadDataFromFile() throws FileNotFoundException {
        o.readDataFromFile("Pensasluettelo.csv");
        ArrayList<Species> lista = o.getPlants();
        assertEquals("kääpiöpalsamipihta", lista.get(0).getFinnishName());
    }
}
