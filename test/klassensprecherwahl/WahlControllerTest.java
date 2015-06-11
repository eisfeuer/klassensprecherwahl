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
        Assert.assertArrayEquals(new String[0], wc.getKandidaten());
    }
    
    @Test
    public void getKandidaten(){
        Wahlcontroller wc = new Wahlcontroller();
        wc.addKandidat("Stefan Kulow");
        wc.addKandidat("Niclas Schirrmeister");
        wc.addKandidat("Sean Sinare");
        String[] erwartet = {"Niclas Schirrmeister","Sean Sinare","Stefan Kulow"};
        Assert.assertArrayEquals(erwartet, wc.getKandidaten());
    }
    
    @Test
    public void setWahlthese(){
        Wahlcontroller wc = new Wahlcontroller();
        wc.addKandidat("Homer Simpsons");
        wc.setThesen("Homer Simpsons", "Schulfrei und Freibier für alle");
        assertEquals("Schulfrei und Freibier für alle",wc.getThesen("Homer Simpsons"));
    }
    
    @Test
    public void getThesenWennKandidatNichtExistiert(){
        Wahlcontroller wc = new Wahlcontroller();
        assertEquals("",wc.getThesen("ghost"));
    }
    
    @Test
    public void getStimmzettel(){
        Wahlcontroller wc = new Wahlcontroller();
        wc.addKandidat("a");
        wc.setThesen("a", "t");
        wc.addKandidat("b");
        wc.setThesen("b", "u");
        wc.addKandidat("c");
        wc.setThesen("c", "v");
        String[][] erwartet = {{"a","t"},{"b","u"},{"c","v"}};
        Assert.assertArrayEquals(erwartet, wc.getStimmzettel());
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
