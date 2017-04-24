package NapakalakiGame;

/**
 * 
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class CultistPlayer extends Player {
    static private int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    /**
     * 
     * Constructor
     * @param p 
     * @param c 
     */
    //FIXME: COMPLETAR COMENTARIO, NO ME SIENTO INSPIRADA
    public CultistPlayer(Player p, Cultist c) {
        super(p);
        totalCultistPlayers++;
        myCultistCard = c;
    }
    
    protected int getCombatLevel() {
        
    }
    
    protected int getOponentLevel(Monster m) {
        
    }
    
    protected boolean shouldConvert() {
        
    }
    
    private Treasure giveMeATreasure() {
        
    }
    
    private boolean canYouGiveMeATreasure() {
        
    }
    
    public int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
}
