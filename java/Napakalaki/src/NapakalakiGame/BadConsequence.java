package NapakalakiGame;
import java.util.ArrayList;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public abstract class BadConsequence {
    private String text;
    private int levels;

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
