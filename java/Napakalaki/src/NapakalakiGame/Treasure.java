package NapakalakiGame;

/**
 * 
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class Treasure {
    private String name;
    private int bonus;
    private TreasureKind type;
    
    /**
     * 
     * Constructor
     * @param n nombre de la carta de tesoros
     * @param bonus puntuación adicional del tesoro
     * @param t tipo de tesoro
     */
    public Treasure(String n, int bonus, TreasureKind t) {
        name = n;
        this.bonus = bonus;
        type = t;
    }
    
    /**
     * 
     * Consultor del nombre
     * @return nombre de la carta de tesoros
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * Consultor del bonus 
     * @return bonus del tesoro
     */
    public int getBonus() {
        return bonus;
    }
    
    /**
     * 
     * Consultor del tipo de tesoro
     * @return tipo de tesoro
     */
    public TreasureKind getType() {
        return type;
    }
}
