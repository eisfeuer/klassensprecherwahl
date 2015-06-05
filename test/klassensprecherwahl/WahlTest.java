/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package klassensprecherwahl;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author it3-schini
 */
public class WahlTest {

    @Test
    public void leereKandidatenListeBeiInit(){
        Wahl wahl = new Wahl();
        Kandidat[] erwartet = new Kandidat[0];
        Assert.assertArrayEquals(erwartet, wahl.getKandidatenAsArray());
    }
    
    @Test
    public void addKandidatUndGetKandidat(){
        Wahl wahl = new Wahl();
        Kandidat k = new Kandidat("Olaf Scholz");
        wahl.addKandidat(k);
        Kandidat[] ergebnis = wahl.getKandidatenAsArray();
        assertEquals(1, ergebnis.length);
        assertEquals(k, ergebnis[0]);
    }
    
    @Test
    public void getKandidatByName(){
        Wahl wahl = new Wahl();
        Kandidat k = new Kandidat("Olaf Scholz");
        wahl.addKandidat(k);
        assertEquals(k, wahl.findKandidatByName("Olaf Scholz"));
    }
    
    @Test
    public void findKandidatByNameWennNichtVorhanden(){
        Wahl wahl = new Wahl();
        assertEquals(null, wahl.findKandidatByName("Olaf Scholz"));
    }
}
