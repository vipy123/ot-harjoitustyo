/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import components.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vipy
 */
public class ComponentsJUnitTest {

    Species testS;
    Species bigS;
    GrowingMedia gm;
    PlantType t;

    public ComponentsJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testS = new Species("Aaaa", "Aaaa bbbb");
        gm = new GrowingMedia(5, 5, 5, 5, 5);
        t = new PlantType("hpe");
        bigS = new Species("Cccc", "Dddd eeee", "XX", 0.4, 0.4, 0.4, gm, t);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSpeciesGetAcronym() {
        String acro = testS.getAcronym();
        assertEquals("Aa_bb", acro);
    }

    @Test
    public void testSpeciesGetPlantType() {
        assertEquals("hpe", bigS.getPlantType().getName());
    }

    @Test
    public void testGrowingMedia() {

        assertEquals(5, gm.getMoist());
        assertEquals(5, gm.getNutrition());
        assertEquals(5, gm.getPermability());
        assertEquals(5, gm.getSunlight());
        assertEquals(5, gm.getAcidity());

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
