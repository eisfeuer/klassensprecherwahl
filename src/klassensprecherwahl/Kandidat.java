/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package klassensprecherwahl;

/**
 *
 * @author it3-schini
 */
public class Kandidat {

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

}
