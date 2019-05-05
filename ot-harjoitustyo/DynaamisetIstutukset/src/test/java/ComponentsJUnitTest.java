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
    public void testSpeciesSetZone() {
        testS.setZone("zone");
        assertEquals("zone", testS.getZone());
    }

    @Test
    public void testSpeciesSetAdultHeight() {
        testS.setAdultHeight(0.5);
        assertEquals(0.5, testS.getAdultHeight(), 0.001);
    }

    @Test
    public void testSpeciesSetSpacing() {
        testS.setSpacing(1.5);
        assertEquals(1.5, testS.getSpacing(), 0.001);
    }

    @Test
    public void testSpeciesSetAmountPerSquare() {
        testS.setAmountPerSquare(2.5);
        assertEquals(2.5, testS.getAmountPerSquare(), 0.001);
    }

    @Test
    public void testSpeciesSetGrowMedia() {
        GrowingMedia gm3 = new GrowingMedia(3, 3, 3, 3, 3);
        testS.setGrowMedia(gm3);
        assertEquals(gm3, testS.getGrowMedia());
    }

    @Test
    public void testGrowingMediaGetters() {

        assertEquals(5, gm.getMoist());
        assertEquals(5, gm.getNutrition());
        assertEquals(5, gm.getPermability());
        assertEquals(5, gm.getSunlight());
        assertEquals(5, gm.getAcidity());

    }
    
    @Test
    public void testGrowingMediaSetters() {
        GrowingMedia gm6 = new GrowingMedia(8, 8, 8, 8, 8);
        gm6.setMoist(5);
        gm6.setNutrition(5);
        gm6.setPermability(5);
        gm6.setSunlight(5);
        gm6.setAcidity(5);

        assertEquals(5, gm6.getMoist());
        assertEquals(5, gm6.getNutrition());
        assertEquals(5, gm6.getPermability());
        assertEquals(5, gm6.getSunlight());
        assertEquals(5, gm6.getAcidity());

    }

    @Test
    public void testGrowingMediaEquals() {
        GrowingMedia gm2 = new GrowingMedia(5, 5, 5, 5, 5);
        boolean gmEquals = (gm2.equals(gm));
        assertEquals(true, gmEquals);
        GrowingMedia gm1 = new GrowingMedia(5, 4, 5, 5, 5);
        boolean gmEquals1 = (gm1.equals(gm));
        assertEquals(false, gmEquals1);
        GrowingMedia gm4 = new GrowingMedia(4, 4, 4, 4, 5);
        boolean gmEquals2 = (gm4.equals(gm));
        assertEquals(false, gmEquals2);
        GrowingMedia gm5 = new GrowingMedia(5, 5, 4, 5, 5);
        boolean gmEquals3 = (gm5.equals(gm));
        assertEquals(false, gmEquals3);
        GrowingMedia gm8 = new GrowingMedia(5, 5, 5, 4, 5);
        boolean gmEquals4 = (gm8.equals(gm));
        assertEquals(false, gmEquals4);
        GrowingMedia gm9 = new GrowingMedia(5, 5, 5, 5, 4);
        boolean gmEquals5 = (gm9.equals(gm));
        assertEquals(false, gmEquals5);
    }
    
    @Test
    public void testGrowingMediaEquals2() {
        GrowingMedia gm2 = new GrowingMedia(3, 5, 5, 5, 5);
        gm.setMoist(3);
        boolean gmEquals = (gm2.equals(gm));
        assertEquals(true, gmEquals);
        GrowingMedia gm4 = new GrowingMedia(4, 5, 5, 5, 5);
        boolean gmEquals2 = (gm4.equals(gm));
        assertEquals(false, gmEquals2);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
