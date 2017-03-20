package napakalaki;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class Prize {
    private int treasures;
    private int levels;
    
    /**
     * 
     * Constructor
     * @param t número de tesoros ganados
     * @param l número de niveles ganados
     */
    public Prize(int t, int l) {
        treasures = t;
        levels = l;
    }
    
    /**
     * 
     * Consultor de tesoros
     * @return número de tesoros ganados
     */
    public int getTreasures() {
        return treasures;
    }
    
    /**
     * 
     * Consultor de niveles
     * @return número de niveles ganados
     */
    public int getLevels() {
        return levels;
    }
    
    /**
     * 
     * @return String con la información del objeto
     */
    public String toString() {
        return "Treasures = " + Integer.toString(treasures) +
                "\nLevels = " + Integer.toString(levels);
    }
}
