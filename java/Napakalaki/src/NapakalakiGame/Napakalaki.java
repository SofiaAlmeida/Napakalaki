package NapakalakiGame;
import java.util.ArrayList;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class Napakalaki {
    private static Napakalaki instance = null;
    private CardDealer dealer;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private Monster currentMonster;
    
    /**
     * 
     * Constructor por defecto
     */
    private Napakalaki() {
        instance = new Napakalaki();
        dealer = null;
        currentPlayer = null;
        currentMonster = null;
        players = new ArrayList();
    }
    
    /**
     * 
     * @param names 
     */
    private void initPlayers(ArrayList<String> names) {
        
    }
    
    /*private Player nextPlayer() {
        
    }
    
    private boolean nextTurnAllowed() {
        
    }
    
    private void setEnemies() {
        
    }
    
    public static Napakalaki getInstance() {
        
    }
    
    public CombatResult developCombat() {
        
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
        
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
        
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
        
    }
    
    public void initGame(ArrayList<String> players) {
        
    }*/
    
    /*public Player getCurrentPlayer() {
        
    }
    
    public Monster getCurrentMonster() {
        
    }
    
    public boolean nextTurn() {
        
    }
    
    public boolean endOfGame (CombatResult result) {
        
    }*/
}
