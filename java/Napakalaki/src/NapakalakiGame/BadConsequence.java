package NapakalakiGame;
import java.util.ArrayList;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public abstract class BadConsequence {
    static final int MAXTREASURES = 10;
    private String text;
    private int levels;
    /*private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;*/
    

    /**
     * 
     * Constructor
     * @param t Descripción del mal rollo
     * @param l Número de niveles que se pierden
     */
    public BadConsequence(String t, int l) {
        text = t;
        levels = l;
    }
    
    /**
     * 
     * Indica si se pierden o no tesoros
     * @return true si  no se pierden tesoros
     *         false en caso contrario
     */
    public abstract boolean isEmpty();
    
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
     * Actualiza el mal rollo quitanto el tesoro de la lista
     * @param t Tesoro visible
     */
    public abstract void substractVisibleTreasure(Treasure t);
    
    /**
     * 
     * Actualiza el mal rollo quitanto el tesoro de la lista
     * @param t Tesoro oculto
     */
    public abstract void substractHiddenTreasure(Treasure t);
            
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
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
            
    /**
     * 
     * @return String con información del mal rollo
     */
    public String toString() {
        return text + "\nLevels = " + Integer.toString(levels);
    }
    
}
