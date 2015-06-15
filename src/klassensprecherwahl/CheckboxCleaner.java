package klassensprecherwahl;

import java.util.Observable;

/**
 * Observable-Klasse, die beim Wahlzettel zum deselektieren aller Checkboxen in
 * einer Spalte benoetigt wird.
 * @author Niclas Schirrmeister, Stefan Kulow, Sean Sinare
 */
public class CheckboxCleaner extends Observable{
    
    /** Konstanten reprsesentiert alle Checkboxen */
    public static final int ALL = -1;
    
    /**
     * deselektiert alle Checkboxen in einer Spalte
     * @param row Spaltennummer, CheckboxCleaner.ALL fuer alle Spalten
     */
    public void cleanRow(int row){
        setChanged();
        notifyObservers(row);
    } 
}
