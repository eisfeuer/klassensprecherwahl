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
public class WahlergebnisItemTest {
    
    @Test
    public void toStringArray(){
        Kandidat k1 = new Kandidat("a");
        WahlergebnisItem wi = new WahlergebnisItem(k1,1);
        Assert.assertArrayEquals(new String[]{"a","1"}, wi.toStringArray());
    }
    
    @Test
    public void beComparable(){
        Kandidat k1 = new Kandidat("a");
        WahlergebnisItem wi1 = new WahlergebnisItem(k1,1);
        WahlergebnisItem wi2 = new WahlergebnisItem(k1,2);
        WahlergebnisItem wi3 = new WahlergebnisItem(k1,2);
        assertEquals(1,wi1.compareTo(wi2));
        assertEquals(0,wi2.compareTo(wi3));
        assertEquals(-1,wi3.compareTo(wi1));
    }
    
}
