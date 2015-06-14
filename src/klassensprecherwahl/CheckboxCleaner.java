/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package klassensprecherwahl;

import java.util.Observable;

/**
 *
 * @author Niclas
 */
public class CheckboxCleaner extends Observable{
    
    public static final int ALL = -1;
    
    public void cleanRow(int row){
        setChanged();
        notifyObservers(row);
    } 
}
