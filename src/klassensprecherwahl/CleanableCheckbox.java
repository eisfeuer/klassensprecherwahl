package klassensprecherwahl;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JCheckBox;

/**
 * Checkbox, die auf aenderungen im Stimmzettel reagiert und sich wenn noetig
 * deselektiert
 * @author Niclas Schirrmeister, Stefan Kulow, Sean Sinare
 */
public class CleanableCheckbox extends JCheckBox implements Observer{
    /** Spaltennummer */
    private final int pos;
    /**
     * @param pos Spalte der Checkbox
     */
    public CleanableCheckbox(int pos){
        this.pos = pos;
    }
    
    @Override
    public void update(Observable ob, Object arg){
        int posToClean = (Integer)arg;
        if(posToClean == pos || posToClean == CheckboxCleaner.ALL){
            setSelected(false);
        }
    }
}
