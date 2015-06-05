package klassensprecherwahl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author it3-schini
 */
public class KandidatTest {

    @Test
    public void nameIsEmpty(){
        Kandidat k = new Kandidat();
        assertEquals("",k.getName());
    }

    @Test
    public void thesisIsEmpty(){
        Kandidat k = new Kandidat();
        assertEquals("",k.getThesen());
    }

    @Test
    public void nameGiven(){
        Kandidat k = new Kandidat("alice");
        assertEquals("alice",k.getName());
    }

    @Test
    public void setAndGetTheses(){
        Kandidat k = new Kandidat();
        k.setThesen("meine Thesen");
        assertEquals("meine Thesen",k.getThesen());
    }


}
