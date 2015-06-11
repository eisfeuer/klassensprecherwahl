/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klassensprecherwahl;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author niclas
 */
public class StimmzettelTest {
    
    @Test
    public void StimmzettelAuswerten(){
        Wahlergebnis we = new Wahlergebnis();
        Kandidat k1 = new Kandidat("a");
        Kandidat k2 = new Kandidat("b");
        Kandidat[] stimmen = {k1,k1,k2,k2,k2};
        Stimmzettel s = new Stimmzettel(stimmen);
        s.auswerten(we);
        String[][] wahlergebnis = {{"a","2"},{"b","3"}};
        Assert.assertArrayEquals(wahlergebnis, we.getWahlergebnisAsStringArray());
    }
    
}
