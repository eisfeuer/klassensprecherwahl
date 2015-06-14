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
public class CleanableCheckbox implements Observer{
    
    private final JCheckBox checkbox;
    private final int pos;
    
    public CleanableCheckbox(JCheckBox checkbox, int pos){
        this.checkbox = checkbox;
        this.pos = pos;
    }
    
    public void update(Observable ob, Object arg){
        int posToClean = (Integer)arg;
        if(posToClean == pos || posToClean == CheckboxCleaner.ALL){
            checkbox.setSelected(false);
        }
    }
}
