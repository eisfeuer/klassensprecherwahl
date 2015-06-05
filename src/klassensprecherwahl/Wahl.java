/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klassensprecherwahl;
import java.util.*;
/**
 *
 * @author it3-sinase
 */
public class Wahl {
    
    private HashMap<String,Kandidat> kandidaten;
    private ArrayList<Stimmzettel> stimmzettel;
    
    
    
    public String getWahlergebnis() {
        return "";
    }
    
    
    
    public Kandidat getWahlsieger() {
        Kandidat k1;
        k1 = new Kandidat();
        return k1;
    }
    
    
    
    public void addStimme(Stimmzettel stimme) {
        this.stimmzettel.add(stimme);
    }
    
    
    
    public void addKandidat(Kandidat kandidat) {
        this.kandidaten.put(kandidat.getName(),kandidat);
    }
    
    
    
    public Kandidat[] getKandidatenAsArray() {
        return new Kandidat[3];//kandidaten.values().toArray();
    }
    
    
    public Kandidat findKandidatByName(String name) {
        return this.kandidaten.get(name);
    }
    
    public void createStichwahl() {
        if(1==1) {
            
        }else {
            
        }
    }
    
}
