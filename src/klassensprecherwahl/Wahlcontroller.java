/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klassensprecherwahl;

import java.util.Arrays;

/**
 *
 * @author niclas
 */
public class Wahlcontroller {
    
    private final Wahl wahl;
    private Kandidat[] kandidatenliste = null;
    private int position = 0;
    
    public Wahlcontroller(){
        wahl = new Wahl();
    }
    
    public String getKandidaten(){
        Kandidat[] kandidaten = wahl.getKandidatenAsArray();
        Arrays.sort(kandidaten);
        String strKandidaten = "";
        for(int i = 0; i < kandidaten.length; ++i){
            strKandidaten += kandidaten[i].getName() + "\n";
        }
        return strKandidaten;
    }
    
    public void addKandidat(String name){
        Kandidat k = new Kandidat(name);
        wahl.addKandidat(k);
    }
    
    public void setThesen(String thesen){
        kandidatenliste[position != 0 ? position-1: 0].setThesen(thesen);
    }
    
    public String getThesen(String kandidat){
        Kandidat k = wahl.findKandidatByName(kandidat);
        return k == null ? "" : k.getThesen();
    }
    
    public String[][] getStimmzettel(){
        Kandidat[] kandidaten = wahl.getKandidatenAsArray();
        Arrays.sort(kandidaten);
        String[][] stimmzettel = new String[kandidaten.length][2];
        for(int i = 0; i < kandidaten.length; ++i){
            stimmzettel[i][0] = kandidaten[i].getName();
            stimmzettel[i][1] = kandidaten[i].getThesen();
        }
        return stimmzettel;
    }
    
    public void commitStimmzettel(String[] kandidaten){
        Kandidat[] k = new Kandidat[kandidaten.length];
        for(int i = 0; i < k.length; i++){
            k[i] = wahl.findKandidatByName(kandidaten[i]);
        }
        wahl.addStimme(new Stimmzettel(k));
    }
    
    public String[][] getWahlergebnis(){
        return wahl.getWahlergebnis().getWahlergebnisAsStringArray();
    }
    
    public String getNext(){
        if(kandidatenliste == null)
            kandidatenliste = wahl.getKandidatenAsArray();
        if(position < kandidatenliste.length)
            return kandidatenliste[position++].getName();
        else
            return null;
    }
}
