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
        assertEquals(k1,we.getWahlsieger());
    }
}
