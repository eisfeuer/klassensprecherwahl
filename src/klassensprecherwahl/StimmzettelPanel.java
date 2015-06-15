package klassensprecherwahl;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Benutzeroberflaeche zum Ausfuellen des Stimmzettels
 * @author Niclas Schirrmeister, Stefan Kulow, Sean Sinare
 */
public class StimmzettelPanel extends JPanel{
    
    /** Wahl Controller */
    private final Wahlcontroller wahl;
    /** aktuelle Stimmen */
    private final String[] stimmen;
    /** Checkbox-Cleaner-Objekt */
    private final CheckboxCleaner cbCleaner = new CheckboxCleaner();
    
    /**
     * @param wahl Wahlcontroller des Main-Panels 
     * @param stimmen Simmen-Array
     */
    public StimmzettelPanel(Wahlcontroller wahl, String[] stimmen){
        this.wahl = wahl;
        this.stimmen = stimmen;
        init();
    }
    
    /**
     * berechnet View neu
     */
    public void reset(){
        removeAll();
        init();
    }
    
    /**
     * Erstellt Stimmzetteloberflaeche
     */
    private void init(){
        String[][] stimmzettel = wahl.getStimmzettel();
        int anzahlZeilen = stimmzettel.length;
        removeAll();
        setLayout(new GridLayout(3,1));
        // Wahlzettel
        JPanel stimmzettelPanel = new JPanel();
        stimmzettelPanel.setLayout(new GridLayout(anzahlZeilen,7));
        for(int i = 0; i < anzahlZeilen; i++){
            JLabel label1 = new JLabel(stimmzettel[i][0]);
            JLabel label2 = new JLabel(stimmzettel[i][1]);
            stimmzettelPanel.add(label1);
            stimmzettelPanel.add(label2);
            for(int j = 0; j < 5; j++){
                CleanableCheckbox checkbox = new CleanableCheckbox(j);
                checkbox.addActionListener(new StimmzettelActionListener(label1, j, stimmen,cbCleaner));
                cbCleaner.addObserver(checkbox);
                stimmzettelPanel.add(checkbox);
            }
        }
        // Buttom zum Abschicken
        
        JButton button2 = new JButton("Wahl beenden");
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                wahlzettelPanel.setVisible(false);
                initWahlergebnisPanel();
                setComponent(wahlergebnisPanel);
                wahlergebnisPanel.setVisible(true);
            }
        });
        wahlzettelPanel.add(stimmzettelPanel);
        wahlzettelPanel.add(button);
        wahlzettelPanel.add(button2);
    }
    
    /**
     * Erzeugt Button zum Stimmzettel abgeben
     * @return Button zum Stimmzettel abgeben
     */
    private JButton createBntWahlzettelAbgeben(){
        JButton btnSubmitStimmzettel = new JButton("Abschicken");
        btnSubmitStimmzettel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                wahl.commitStimmzettel(stimmen);
                cbCleaner.cleanRow(CheckboxCleaner.ALL);
            }
        });
        return btnSubmitStimmzettel;
    }
    
}
