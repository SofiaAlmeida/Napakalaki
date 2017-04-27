package NapakalakiGame;
import java.util.ArrayList;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class NumericBadConsequence extends BadConsequence {
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    /**
     * 
     * Constructor
     * @param t Descripción del mal rollo
     * @param l Número de niveles que se pierden
     * @param nVisible Número de tesoros visibles que se pierden
     * @param nHidden Número de tesoros ocultos que se pierden
     */
    NumericBadConsequence(String t, int l, int nVisible, int nHidden) {
        super(t, l);
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    
    /**
     * 
     * Indica si se pierden o no tesoros
     * @return true si  no se pierden tesoros
     *         false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return nVisibleTreasures == 0 && nHiddenTreasures == 0;
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
     * Actualiza el mal rollo disminuyendo el número de tesoros visibles
     * @param t Tesoro visible
     */
    @Override
    public void substractVisibleTreasure(Treasure t) {
        nVisibleTreasures --;
    }
    
    /**
     * 
     * Actualiza el mal rollo disminuyendo el número de tesoros ocultos
     * @param t Tesoro oculto
     */
    @Override
    public void substractHiddenTreasure(Treasure t) {
        nHiddenTreasures --;
    }
    
    /**
     * 
     * Ajusta el mal rollo según los tesoros del jugador
     * @param v Tesoros visibles del jugador
     * @param h Tesoros ocultos del jugador
     * @return mal rollo ajustado
     */
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        int nVT, nHT;
        
        if (nVisibleTreasures > v.size())
            nVT = v.size();
        else
            nVT = nVisibleTreasures;
        if (nHiddenTreasures > h.size())
            nHT = h.size();
        else    
            nHT = nHiddenTreasures;
        
        return new NumericBadConsequence(getText(), getLevels(), nVT, nHT);
    }
    
    /**
     * 
     * @return String con información del mal rollo
     */
    @Override
    public String toString() {
        return super.toString() + "\nTreasures Visibles = " + Integer.toString(nVisibleTreasures) 
                + "\nHidden Treasures = " + Integer.toString(nHiddenTreasures);
    }
}
