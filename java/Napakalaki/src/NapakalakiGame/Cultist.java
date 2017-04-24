package NapakalakiGame;

/**
 * 
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class Cultist {
    private String name;
    private int gainedLevels;
    
    /**
     * 
     * Constructor
     * @param name Nombre del sectario
     * @param gainedLevels Niveles añadidos 
     */
    public Cultist(String name, int gainedLevels) {
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    /**
     * 
     * @return Niveles que se añaden por ser sectario
     */
    public int getGainedLevels() {
        return gainedLevels;
    }
}
