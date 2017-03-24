package NapakalakiGame;
import java.util.ArrayList;
import java.util.Random;

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
        for (String name : names)
            players.add(new Player(name));
    }
    
    /**
     * 
     * Dedice que jugador es el siguiente en jugar
     * @return el siguiente jugador
     */
    private Player nextPlayer() {
        int posicion;
        if (currentPlayer == null){
            Random rand = new Random();
            posicion = rand.nextInt(players.size());
        }
        else{
            posicion = players.indexOf(currentPlayer); //Devuelve solo la primera ocurrencia
            if (posicion == players.size() -1)
                posicion = 0;
            else
                posicion ++;
        }
        currentPlayer = players.get(posicion);
        return currentPlayer;        
    }
    
    /**
     * 
     * Comprueba si el jugador activo cumpla con las reglas del jugador para 
     * terminar el turno
     * @return true si el jugador cumple las reglas
     *         false en otro caso
     */
    private boolean nextTurnAllowed() {
        if (currentPlayer == null)
            return true;
        else
            return currentPlayer.validState();
    }
    
    /**
     * 
     * Asigna enemigo a cada jugador
     */
    private void setEnemies() {
        int posicion;
        for (Player player : players){
            do{
                Random rand = new Random();
                posicion = rand.nextInt(players.size());
            }while (posicion == players.indexOf(player));
            player.setEnemy(players.get(posicion));
        }
    }
    
    /*public static Napakalaki getInstance() {
        
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
        
    }
    */
    
    /**
     * 
     * Consultor del jugador actual
     * @return jugador actual
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * 
     * Consultor del monstruo actual
     * @return monstruo en juego
     */
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    
    /*public boolean nextTurn() {
        
    }*/
    
    /**
     * 
     * Comprueba si se acaba el juego
     * @param result
     * @return true si alguien gana
     *         false en caso contrario
     */
    public boolean endOfGame (CombatResult result) {
        if (result == CombatResult.WINGAME)
            return true;
        else
            return false;
    }
}
