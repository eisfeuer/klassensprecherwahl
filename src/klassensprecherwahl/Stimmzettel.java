/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klassensprecherwahl;

/**
 *
 * @author it3-sinase
 */
public class Stimmzettel {
    private Kandidat[] kandidaten;
    
    public Stimmzettel(Kandidat[] kandidaten){
        this.kandidaten = kandidaten;
    }
    
    public Kandidat[] getKandidaten(){
        return kandidaten;
    }
    
    public void auswerten(Wahlergebnis we){
        for(Kandidat k:kandidaten){
            we.addStimme(k);
        }
    }
}
