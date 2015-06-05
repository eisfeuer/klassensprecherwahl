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
    
    private Wahl wahl;
    
    public Wahlcontroller(){
        wahl = new Wahl();
    }
    
    public String[] getKandidaten(){
        Kandidat[] kandidaten = wahl.getKandidatenAsArray();
        String[] stringArray = new String[kandidaten.length];
        for(int i = 0; i < kandidaten.length; ++i){
            stringArray[i] = kandidaten[i].getName();
        }
        Arrays.sort(stringArray);
        return stringArray;
    }
    
    public void addKandidat(String name){
        Kandidat k = new Kandidat(name);
        wahl.addKandidat(k);
    }
    
}
