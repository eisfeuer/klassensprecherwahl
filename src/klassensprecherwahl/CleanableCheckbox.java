/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package klassensprecherwahl;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JCheckBox;

/**
 *
 * @author Niclas
 */
public class CleanableCheckbox extends JCheckBox implements Observer{
    
    private final int pos;
    
    public CleanableCheckbox(int pos){
        this.pos = pos;
    }
    
    public void update(Observable ob, Object arg){
        int posToClean = (Integer)arg;
        if(posToClean == pos || posToClean == CheckboxCleaner.ALL){
            setSelected(false);
            //System.out.println("hallo");
        }
    }
}
