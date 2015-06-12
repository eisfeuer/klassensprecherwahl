/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klassensprecherwahl;

import java.util.Arrays;
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
        WahlergebnisItem[] items = toItems();
        Arrays.sort(items);
        String[][] ergebnis = new String[items.length][2];
        for(int i = 0; i < items.length; i++){
            ergebnis[i] = items[i].toStringArray();
        }
        return ergebnis;
    }
    
    public Kandidat getWahlsieger(){
        WahlergebnisItem[] items = toItems();
        Arrays.sort(items);
        return items.length < 1 ? null : items[0].getKandidat();
    }
    
    private WahlergebnisItem[] toItems(){
        WahlergebnisItem[] ergebnisse = new WahlergebnisItem[wahlergebnis.size()];
        Iterator iMap = wahlergebnis.entrySet().iterator();
        int i = 0;
        while(iMap.hasNext()){
            Map.Entry mapping = (Map.Entry) iMap.next();
            Kandidat k = (Kandidat)mapping.getKey();
            int stimmen = (Integer)mapping.getValue();
            ergebnisse[i] = new WahlergebnisItem(k,stimmen);
            i++;
        }
        return ergebnisse;
    }
    
}
