/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package klassensprecherwahl;

/**
 *
 * @author it3-schini
 */
public class Kandidat implements Comparable {

    private String name;
    private String thesen;

    public Kandidat(String name){
        this.name = name;
        this.thesen = "";
    }

    public Kandidat(){
        this("");
    }

    public String getName(){
        return name;
    }

    public String getThesen(){
        return thesen;
    }

    public void setThesen(String thesen){
        this.thesen = thesen;
    }
    
    @Override
    public int compareTo(Object other){
        if(other.getClass() != getClass()){
            return -1;
        }
        Kandidat andererKandidat = (Kandidat)other;
        return name.compareTo(andererKandidat.getName());
    }
    
    @Override
    public String toString(){
        return name;
    }

}
