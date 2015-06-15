package klassensprecherwahl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 * ActionListener der auf aendern von Wahlkreuzen reagiert
 * @author Niclas Schirrmeister, Stefan Kulow, Sean Sinare
 */
public class StimmzettelActionListener implements ActionListener{
    /** Label in dem der Name steht */
    private final JLabel label;
    /** Position des Stimmenkreuzes */
    private final int position;
    /** Array mit den Stimmen */
    private final String[] stimme;
    /** Checkbox-Cleaner-Objekt */
    private final CheckboxCleaner cbc;

    /**
     * @param label Label in dem der Name steht
     * @param pos Position des Stimmenkreuzes
     * @param stimme Array mit den Stimmen
     * @param cbc Checkbox-Cleaner-Objekt
     */
    public StimmzettelActionListener(JLabel label, int pos, String[] stimme, CheckboxCleaner cbc){
        this.label = label;
        this.position = pos;
        this.stimme = stimme;
        this.cbc = cbc;
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        JCheckBox checkbox = (JCheckBox)evt.getSource();
        if(checkbox.isSelected()){
          stimme[position] = label.getText();
          cbc.cleanRow(position);
          checkbox.setSelected(true);
        } else {
            // alle leergebliebenen Stimmfelder werden mit null belegt
            stimme[position] = null;
        }
    }
    
}
