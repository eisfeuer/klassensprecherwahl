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
    
}
