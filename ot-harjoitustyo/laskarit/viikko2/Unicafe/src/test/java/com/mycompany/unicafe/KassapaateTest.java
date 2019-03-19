/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

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
public class KassapaateTest {
    Kassapaate paate;
    Maksukortti kortti;
    public KassapaateTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void rahanLatausToimii() {
         paate.lataaRahaaKortille(kortti, 500);
         assertEquals(100500, paate.kassassaRahaa());
         assertEquals(1500, kortti.saldo());
         paate.lataaRahaaKortille(kortti, -500);
         assertEquals(100500, paate.kassassaRahaa());
         assertEquals(1500, kortti.saldo());
     }
     @Test
     public void alkukassanRahamaaraJaLounaitaMyytyOikein() {
         assertEquals(100000, paate.kassassaRahaa());
         assertEquals(0, paate.maukkaitaLounaitaMyyty());
         assertEquals(0, paate.edullisiaLounaitaMyyty());
     
     }
     @Test
     public void syoMaukkaastiToimiiOikeinKateisella() {
         paate.syoMaukkaasti(400);
         assertEquals(100400, paate.kassassaRahaa());
         assertEquals(30, paate.syoMaukkaasti(430));
         assertEquals(2, paate.maukkaitaLounaitaMyyty());
         paate.syoMaukkaasti(300);
         assertEquals(100800, paate.kassassaRahaa());
         assertEquals(300, paate.syoMaukkaasti(300));
         assertEquals(2, paate.maukkaitaLounaitaMyyty());
         
         assertEquals(0, paate.edullisiaLounaitaMyyty());
     
     }
     
     @Test
     public void syoEdullisestiToimiiOikeinKateisella() {
         paate.syoEdullisesti(400);
         assertEquals(100240, paate.kassassaRahaa());
         assertEquals(10, paate.syoEdullisesti(250));
         assertEquals(2, paate.edullisiaLounaitaMyyty());
         paate.syoEdullisesti(200);
         assertEquals(100480, paate.kassassaRahaa());
         assertEquals(200, paate.syoMaukkaasti(200));
         assertEquals(2, paate.edullisiaLounaitaMyyty());
         
         assertEquals(0, paate.maukkaitaLounaitaMyyty());
     
     }
     @Test
     public void syoEdullisestiToimiiOikeinKortilla() {
         paate.syoEdullisesti(kortti);
         assertEquals(100240, paate.kassassaRahaa());
         assertEquals(true, paate.syoEdullisesti(kortti));
         assertEquals(2, paate.edullisiaLounaitaMyyty());
         paate.syoEdullisesti(kortti);
         paate.syoEdullisesti(kortti);
         
         
         assertEquals(100960, paate.kassassaRahaa());
         assertEquals(false, paate.syoEdullisesti(kortti));
         assertEquals(4, paate.edullisiaLounaitaMyyty());
         
         assertEquals(0, paate.maukkaitaLounaitaMyyty());
     
     }
     @Test
     public void syoMaukkaastistiToimiiOikeinKortilla() {
         paate.syoMaukkaasti(kortti);
         assertEquals(100400, paate.kassassaRahaa());
         assertEquals(true, paate.syoMaukkaasti(kortti));
         assertEquals(2, paate.maukkaitaLounaitaMyyty());
         paate.syoMaukkaasti(kortti);
         
         
         
         assertEquals(100800, paate.kassassaRahaa());
         assertEquals(false, paate.syoMaukkaasti(kortti));
         assertEquals(2, paate.maukkaitaLounaitaMyyty());
         
         assertEquals(0, paate.edullisiaLounaitaMyyty());
     
     }
}
