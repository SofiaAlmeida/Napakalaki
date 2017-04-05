package NapakalakiGame;
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
    
  
    /**
     * 
     * Indica si se pierden o no tesoros
     * @return true si  no se pierden tesoros
     *         false en caso contrario
     */
    public boolean isEmpty() {
        if (nVisibleTreasures == 0 && nHiddenTreasures == 0 && getSpecificHiddenTreasures().isEmpty() && getSpecificVisibleTreasures().isEmpty())
            return true;
        return false;
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
     * Actualiza el mal rollo quitanto el tesoro de la lista
     * @param t Tesoro visible
     */
    public void substractVisibleTreasure(Treasure t) {
        if (specificVisibleTreasures.isEmpty())
            nVisibleTreasures --;
        else
            specificVisibleTreasures.remove(t.getType());
    }
    
    /**
     * 
     * Actualiza el mal rollo quitanto el tesoro de la lista
     * @param t Tesoro oculto
     */
    public void substractHiddenTreasure(Treasure t) {
        if (specificHiddenTreasures.isEmpty())
            nHiddenTreasures --;
        else
            specificHiddenTreasures.remove(t.getType());
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
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        specificVisibleTreasures = v;
        specificHiddenTreasures = h;
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
        this.levels = Player.MAXLEVEL;
        nVisibleTreasures = MAXTREASURES;
        nHiddenTreasures = MAXTREASURES;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
        
   
    /**
     * 
     * Ajusta el mal rollo según los tesoros del jugador
     * @param v Tesoros visibles del jugador
     * @param h Tesoros ocultos del jugador
     * @return mal rollo ajustado
     */
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        BadConsequence adjusted;
        int nVT, nHT;
        ArrayList<TreasureKind> vT = new ArrayList();
        ArrayList<TreasureKind> hT = new ArrayList();
        ArrayList<TreasureKind> sVT = new ArrayList(specificVisibleTreasures);
        ArrayList<TreasureKind> sHT = new ArrayList(specificHiddenTreasures);

        if (specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty()){
            if (nVisibleTreasures > v.size())
                nVT = v.size();
            else
                nVT = nVisibleTreasures;
            if (nHiddenTreasures > h.size())
                nHT = h.size();
            else    
                nHT = nHiddenTreasures;
            adjusted = new BadConsequence(getText(), getLevels(), nVT, nHT);
        }
        else{
            if (!v.isEmpty())
                for (Treasure treasure : v) {
                    if (sVT.contains(treasure.getType()))
                        vT.add(treasure.getType());
                        sVT.remove(treasure.getType());
                }
            if (!h.isEmpty())
                for (Treasure treasure : h) {
                    if (sHT.contains(treasure.getType()))
                        hT.add(treasure.getType());
                        sHT.remove(treasure.getType());
                }
            adjusted = new BadConsequence(getText(), getLevels(), vT, hT);
        }
        return adjusted;
    }
    /**
     * 
     * @return String con información del mal rollo
     */
    public String toString() {
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
    }
    
}
