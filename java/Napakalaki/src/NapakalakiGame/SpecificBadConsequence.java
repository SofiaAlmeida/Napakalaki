
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class SpecificBadConsequence extends BadConsequence {
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    /**
     * 
     * Constructor
     * @param text Descripción del mal rollo
     * @param levels Número de niveles que se pierden
     * @param tVisible Tesoros visibles que se pierden
     * @param tHidden Tesores ocultos que se pierden
     */
    public SpecificBadConsequence(String t, int l, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h) {
        super(t, l);
        specificVisibleTreasures = v;
        specificHiddenTreasures = h;
    }
    
    /**
     * 
     * Indica si se pierden o no tesoros
     * @return true si  no se pierden tesoros
     *         false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty();
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
    @Override
    public void substractVisibleTreasure(Treasure t) {
        specificVisibleTreasures.remove(t.getType());
    }
        
    /**
     * 
     * Actualiza el mal rollo quitanto el tesoro de la lista
     * @param t Tesoro oculto
     */
    @Override
    public void substractHiddenTreasure(Treasure t) {
        specificHiddenTreasures.remove(t.getType());
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
        ArrayList<TreasureKind> vT = new ArrayList();
        ArrayList<TreasureKind> hT = new ArrayList();
        ArrayList<TreasureKind> sVT = new ArrayList(specificVisibleTreasures);
        ArrayList<TreasureKind> sHT = new ArrayList(specificHiddenTreasures);

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
        
        return new SpecificBadConsequence(getText(), getLevels(), vT, hT);
    }
       
    /**
     * 
     * @return String con información del mal rollo
     */
    @Override
    public String toString() {
     return super.toString() + "\nTreasures Visibles = " + specificVisibleTreasures.toString()
            + "\nHidden Treasures = " + specificHiddenTreasures.toString();
}

