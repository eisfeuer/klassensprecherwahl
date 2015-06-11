/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klassensprecherwahl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author niclas
 */
public class Wahlergebnis {
    
    private final HashMap<Kandidat,Integer> wahlergebnis;
    
    public Wahlergebnis(){
        wahlergebnis = new HashMap<Kandidat,Integer>();
    }
    
    public void addStimme(Kandidat k){
        if(wahlergebnis.containsKey(k)){
            wahlergebnis.put(k, wahlergebnis.get(k) + 1);
        } else {
            wahlergebnis.put(k, 1);
        }
    }
    
    public String[][] getWahlergebnisAsStringArray(){
        String[][] ergebnis = new String[wahlergebnis.size()][2];
        Iterator iMap = wahlergebnis.entrySet().iterator();
        int i = 0;
        while(iMap.hasNext()){
            Map.Entry mapping = (Map.Entry) iMap.next();
            ergebnis[i][0] = mapping.getKey().toString();
            ergebnis[i][1] = mapping.getValue().toString();
            i++;
        }
        return ergebnis;
    }
    
}
