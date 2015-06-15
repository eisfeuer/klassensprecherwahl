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
    
    
    public Wahl(){
        kandidaten = new HashMap<String,Kandidat>();
        stimmzettel = new ArrayList<Stimmzettel>();
    }
    
    public Wahlergebnis getWahlergebnis() {
        Wahlergebnis ergebnis = new Wahlergebnis();
        for(Stimmzettel s:stimmzettel) {
            s.auswerten(ergebnis);
        }
        return ergebnis;
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
        Kandidat[] kandis = kandidaten.values().toArray(new Kandidat[0]);
        Arrays.sort(kandis);
        return kandis;
    }
    
    
    public Kandidat findKandidatByName(String name) {
        return this.kandidaten.get(name);
    }
    
    public void stichwahlStarten() {
        Kandidat[] wahlsieger = getWahlergebnis().getWahlsieger();
        stimmzettel.clear();
        kandidaten.clear();
        for(Kandidat k:wahlsieger){
            addKandidat(k);
        }
    }
    
}
