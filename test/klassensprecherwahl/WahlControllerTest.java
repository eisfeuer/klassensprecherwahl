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
public class WahlControllerTest {
    
    @Test
    public void getKandidatenOnInit(){
        Wahlcontroller wc = new Wahlcontroller();
        assertEquals("", wc.getKandidaten());
    }
    
    @Test
    public void getKandidaten(){
        Wahlcontroller wc = new Wahlcontroller();
        wc.addKandidat("Stefan Kulow");
        wc.addKandidat("Niclas Schirrmeister");
        wc.addKandidat("Sean Sinare");
        String erwartet = "Niclas Schirrmeister\nSean Sinare\nStefan Kulow\nyy";
        assertEquals(erwartet, wc.getKandidaten());
    }
   
    
    @Test
    public void getThesenWennKandidatNichtExistiert(){
        Wahlcontroller wc = new Wahlcontroller();
        assertEquals("",wc.getThesen("ghost"));
    }
    
    @Test
    public void waehlenUndStatistikErmitteln(){
       Wahlcontroller wc = new Wahlcontroller();
       wc.addKandidat("a");
       wc.addKandidat("b");
       wc.addKandidat("c");
       wc.commitStimmzettel(new String[] {"a","c","a","b","b"});
       wc.commitStimmzettel(new String[] {"a","a","c","c","b"});
       wc.commitStimmzettel(new String[] {"a","b","b","b","b"});
       String[][] erwartet = {{"a","5"},{"b","7"},{"c","3"}};
       Assert.assertArrayEquals(erwartet, wc.getWahlergebnis());
       
    }
    
}
