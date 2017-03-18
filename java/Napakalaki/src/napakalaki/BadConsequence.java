package napakalaki;
import java.util.ArrayList;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class BadConsequence {
    static final int MAXTREASURES = 10;
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
  
    //TODO: documentación, según lo que tenga que hacer
    public boolean isEmpty() {
        if (nVisibleTreasures == 0 && nHiddenTreasures == 0 && getSpecificHiddenTreasures().isEmpty() && getSpecificVisibleTreasures().isEmpty())
            return true;
        return false;
    }
    //NOTE: podríamos llamar a esta función en la función de PruebaNapakalaki
    
    /**
     * 
     * Consultor del texto
     * @return texto con la información del mal rollo
     */
    /*public String getText() {
        return text;
    }*/
    
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
    /*public boolean getDeath() {
        return death;
    }*/
    
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
     * Consultor de tesoros visibles
     * @return tesoros específicos visibles que se pierden
     */
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    /**
     * 
     * 
     * @param t Tesoro
     */
    public void substractVisibleTreasure(Treasure t) {
        
    }
    
    /**
     * 
     * 
     * @param t 
     */
    public void substractHiddenTreasure(Treasure t) {
        
    }
    /**
     * 
     * Constructor: número tesoros
     * @param t Descripción del mal rollo
     * @param l Número de niveles que se pierden
     * @param nVisible Número de tesoros visible que se pierden
     * @param nHidden Número de tesoros ocultos que se pierden
     */
    public BadConsequence(String t, int l, int nVisible, int nHidden) {
        text = t;
        levels = l;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        death = false;
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
    public BadConsequence(String t, int l, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h) {
        text = t;
        levels = l;
        specificVisibleTreasures = v;
        specificHiddenTreasures = h;
        levels = 0;
        death = false;       
    }
    
    /**
     * 
     * Constructor: Muerte
     * @param text Descripción del mal rollo
     * @param death Boolean que indica si el mal rollo es muerte
     */
    public BadConsequence(String t, boolean death) {
        this.text = t;
        this.death = death;
        this.levels = 0;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
        
   
    /**
     * 
     * @param v
     * @param h
     * @return 
     */
    /*public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        
    }*/
    /**
     * 
     * @return String con información del mal rollo
     */
    /*public String toString() {
        if (death)
            return text;
        else if (getSpecificHiddenTreasures().isEmpty() && getSpecificVisibleTreasures().isEmpty())
            return text + "\nLevels = " + Integer.toString(levels) + "\nTreasures Visibles = "
                   + Integer.toString(nVisibleTreasures) + "\nHidden Treasures = "
                   + Integer.toString(nHiddenTreasures);
        
            else
                return text + "\nLevels = " + Integer.toString(levels) + "\nTreasures Visibles = "
                       + specificVisibleTreasures.toString() + "\nHidden Treasures = "
                       + specificHiddenTreasures.toString();
    }*/
    
}
