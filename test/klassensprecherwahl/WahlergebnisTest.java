/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klassensprecherwahl;


import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author niclas
 */
public class WahlergebnisTest {
    
    @Test
    public void addStimmeAndGetWahlergebnis(){
        Wahlergebnis we = new Wahlergebnis();
        Kandidat k1 = new Kandidat("a");
        Kandidat k2 = new Kandidat("b");
        we.addStimme(k1);
        we.addStimme(k1);
        we.addStimme(k2);
        we.addStimme(k1);
        we.addStimme(k2);
        String[][] wahlergebnis = {{"a","3"},{"b","2"}};
        Assert.assertArrayEquals(wahlergebnis, we.getWahlergebnisAsStringArray());
    }
    
    @Test
    public void getWahlsieger(){
        Wahlergebnis we = new Wahlergebnis();
        Kandidat k1 = new Kandidat("a");
        Kandidat k2 = new Kandidat("b");
        we.addStimme(k1);
        we.addStimme(k1);
        we.addStimme(k2);
        we.addStimme(k1);
        we.addStimme(k2);
        Assert.assertArrayEquals(new Kandidat[]{k1},we.getWahlsieger());
    }
    
    @Test
    public void mehrereWahlsiegerFuerStichwahl(){
        Wahlergebnis we = new Wahlergebnis();
        Kandidat k1 = new Kandidat("a");
        Kandidat k2 = new Kandidat("b");
        we.addStimme(k1);
        we.addStimme(k2);
        we.addStimme(k1);
        we.addStimme(k2);
        Assert.assertArrayEquals(new Kandidat[]{k1,k2},we.getWahlsieger());
    }
    
    @Test
    public void gibKeineStimmeWennKandidatIstNull(){
        Wahlergebnis we = new Wahlergebnis();
        Kandidat k1 = new Kandidat("a");
        Kandidat k2 = new Kandidat("b");
        we.addStimme(k1);
        we.addStimme(k1);
        we.addStimme(null);
        we.addStimme(null);
        we.addStimme(k2);
        String[][] wahlergebnis = {{"a","2"},{"b","1"}};
        Assert.assertArrayEquals(wahlergebnis, we.getWahlergebnisAsStringArray());
    }
    
    @Test
    public void gibSummeAllerStimmen(){
        Wahlergebnis we = new Wahlergebnis();
        Kandidat k1 = new Kandidat("a");
        Kandidat k2 = new Kandidat("b");
        we.addStimme(k1);
        we.addStimme(k1);
        we.addStimme(k2);
        we.addStimme(k1);
        we.addStimme(k2);
        assertEquals(5, we.getSummeAllerStimmen());
    }
    
    @Test
    public void MehrereWahlsieger(){
        Wahlergebnis we = new Wahlergebnis();
        Kandidat k1 = new Kandidat("a");
        Kandidat k2 = new Kandidat("b");
        we.addStimme(k1);
        we.addStimme(k2);
        we.addStimme(k1);
        we.addStimme(k2);
        assertEquals(true, we.istStimmenGleichstand());
    }
    
    @Test
    public void einWahlsieger(){
        Wahlergebnis we = new Wahlergebnis();
        Kandidat k1 = new Kandidat("a");
        Kandidat k2 = new Kandidat("b");
        we.addStimme(k1);
        we.addStimme(k1);
        we.addStimme(k2);
        we.addStimme(k1);
        we.addStimme(k2);
        assertEquals(false, we.istStimmenGleichstand());
    }
}
