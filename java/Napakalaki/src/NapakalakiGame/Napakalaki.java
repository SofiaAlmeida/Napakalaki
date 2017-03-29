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
        dealer = CardDealer.getInstance();
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
        
    }*/
    
    public CombatResult developCombat() {
        CombatResult combatResult = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        return combatResult;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
        for (Treasure treasure : treasures){
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
        
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
        for (Treasure treasure : treasures){
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
        for (Treasure t : treasures){
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    public void initGame(ArrayList<String> players) {
        initPlayers(players);
        setEnemies();
        nextTurn();
        dealer.initCards();
    }
    
    
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
    
    public boolean nextTurn() {
        boolean stateOK = nextTurnAllowed();
        if (stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            boolean dead = currentPlayer.isDead();
            if (dead){
                currentPlayer.initTreasures();
            }
        }
        return stateOK;
    }
    
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
