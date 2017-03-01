
package napakalaki;
import java.util.ArrayList;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class BadConsequence {
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    /**
     * 
     * Constructor: número tesoros
     * @param text Descripción del mal rollo
     * @param levels Número de niveles que se pierden
     * @param nVisible Número de tesoros visible que se pierden
     * @param nHidden Número de tesoros ocultos que se pierden
     */
    public BadConsequence(String text, int levels, int nVisible, int nHidden) {
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        death = false;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }        
    
    /**
     * 
     * Constructor: Muerte
     * @param text Descripción del mal rollo
     * @param death Boolean que indica si el mal rollo es muerte
     */
    public BadConsequence(String text, boolean death) {
        this.text = text;
        this.death = death;
        this.levels = 0;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
        
    /**
     * 
     * Constructor: Listas
     * @param text Descripción del mal rollo
     * @param levels Número de niveles que se pierden
     * @param tVisible Tesoros visibles que se pierden
     * @param tHidden Tesores ocultos que se pierden
     */
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,
            ArrayList<TreasureKind> tHidden) {
        this.text = text;
        this.levels = levels;
        specificVisibleTreasures = tVisible;
        specificHiddenTreasures = tHidden;
        this.levels = 0;
        this.death = false;       
    }
    
    /**
     * 
     * Consultor del texto
     * @return texto con la información del mal rollo
     */
    public String getText() {
        return text;
    }
    
    /**
     * 
     * Consultor de niveles
     * @return número de niveles que se pierden
     */
    public int getLevels() {
        return levels;
    }
    
    /**
     * 
     * Consultor del número de tesoros visibles
     * @return número de tesoros visibles que pierden
     */
    public int getNVisibleTreasures() {
        return nVisibleTreasures;
    }
    
    /**
     * 
     * Consultor del número de tesoros ocultos
     * @return número de tesoros ocultos que se pierden
     */
    public int getNHiddenTreasures() {
        return nHiddenTreasures;
    }
    
    /**
     * 
     * Consultor de la muerte
     * @return true si se muere
     *         false si no se muere
     */
    public boolean getDeath() {
        return death;
    }
    
    /**
     * 
     * Consultor de tesoros visibles
     * @return tesoros específicos visibles que se pierden
     */
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    /**
     * 
     * Consultor de tesoros ocultos
     * @return tesoros específicos ocultos que se pierden
     */
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    
    /**
     * 
     * @return String con información del mal rollo
     */
    public String toString() {
        if (death)
            return text;
        if (getSpecificHiddenTreasures() != null && getSpecificVisibleTreasures() != null) {
            return text + "\nLevels = " + Integer.toString(levels) + "\nTreasures Visibles = "
                   + specificVisibleTreasures.toString() + "\nHidden Treasures"
                    specificHiddenTreasures.toString();
        }
    }
}
