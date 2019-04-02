package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void onkoSaldoAlussaOikein() {
        assertEquals("saldo: 10.0", kortti.toString());
    }
    @Test
    public void kasvattaakoLataaminenSaldoaOikein() {
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 20.0", kortti.toString());
    }
    @Test
    public void saldoEiMuutuJosRahaEiRiita() {
        kortti.otaRahaa(1500);
        assertEquals("saldo: 10.0", kortti.toString());
        assertEquals(false, kortti.otaRahaa(1500));
    }
    public void saldovaheneeJosRahaRiittaa() {
        kortti.otaRahaa(500);
        assertEquals(true, kortti.otaRahaa(5));
        assertEquals("saldo: 5.0", kortti.toString());
    }
    @Test
    public void saldoAntaaOikeanSaldon() {
        assertEquals(1000, kortti.saldo());
    }
}
