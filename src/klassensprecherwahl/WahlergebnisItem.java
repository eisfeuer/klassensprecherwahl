/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klassensprecherwahl;

import klassensprecherwahl.Kandidat;

/**
 *
 * @author niclas
 */
public class WahlergebnisItem implements Comparable{
    
    private final Kandidat kandidat;
    private final int punkte;
    
    public WahlergebnisItem(Kandidat k, int punkte){
        this.kandidat = k;
        this.punkte = punkte;
    }
    
    public int compareTo(Object other){
        if(other.getClass() != getClass()) return -1;
        WahlergebnisItem anderer = (WahlergebnisItem)other;
        if(punkte < anderer.punkte) return 1;
        if(punkte > anderer.punkte) return -1;
        return 0;
    }
    
    public String[] toStringArray(){
        String[] ergebnis = new String[2];
        ergebnis[0] = kandidat.toString();
        ergebnis[1] = Integer.toString(punkte);
        return ergebnis;
    }
    
    public Kandidat getKandidat(){
        return kandidat;
    }
    
}
