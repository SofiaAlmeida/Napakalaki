package napakalaki;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class Prize {
    private int treasures;
    private int level;
    
    /**
     * 
     * Constructor
     * @param treasures número de tesoros ganados
     * @param level número de niveles ganados
     */
    public Prize(int treasures, int level) {
        this.treasures = treasures;
        this.level = level;
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
    public int getLevel() {
        return level;
    }
    
    /**
     * 
     * @return String con la información del objeto
     */
    public String toString() {
        return "Treasures = " + Integer.toString(treasures) +
                "\nLevels = " + Integer.toString(level);
    }
}
