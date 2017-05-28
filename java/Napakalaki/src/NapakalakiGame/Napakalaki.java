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
    private CardDealer dealer = CardDealer.getInstance();
    private ArrayList<Player> players = new ArrayList();;
    private Player currentPlayer = null;
    private Monster currentMonster = null;
    
    /**
     * 
     * Constructor por defecto
     */
    private Napakalaki() { }

    /**
     * 
     * Inicializa la lista de jugadores a partir de los nombres dados
     * @param names Nombre de los jugadores
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
        if (currentPlayer == null) {
            Random rand = new Random();
            posicion = rand.nextInt(players.size());
        }
        else {
            posicion = players.indexOf(currentPlayer); //Devuelve solo la primera ocurrencia
            if (posicion == (players.size() - 1))
                posicion = 0;
            else
                posicion++;
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
        for (Player player : players) {
            do {
                Random rand = new Random();
                posicion = rand.nextInt(players.size());
            } while (posicion == players.indexOf(player));
            player.setEnemy(players.get(posicion));
        }
    }
    
    /**
     * 
     * @return la única instancia de esta clase
     */
    public static Napakalaki getInstance() {
        if (instance == null)
            instance = new Napakalaki();
        return instance;
    }
    
    /**
     * 
     * Desarrollo del combate
     * @return resultado del combate
     */
    public CombatResult developCombat() {
        CombatResult combatResult = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        if(combatResult == CombatResult.LOSEANDCONVERT) {
            // Creamos el sectario
            Cultist c = dealer.nextCultist();
            CultistPlayer cp = new CultistPlayer(currentPlayer, c);
            // Reemplazamos al jugador actual por el sectario correspondiente
            // (currentPlayer, players, enemy)
            
            for(Player p : players)
                if(p.getEnemy() == currentPlayer)
                    p.setEnemy(cp);
            players.set(players.indexOf(currentPlayer), cp); // Reemplazamos jugador en el array
            currentPlayer = cp;
        }
        return combatResult;
    }
    
    /**
     * 
     * Elimina los tesoros visibles pasados como parámetro del jugador actual
     * @param treasures Tesoros a descartar
     */
    public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
        for (Treasure treasure : treasures){
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    /**
     * 
     * Elimina los tesoros ocultos pasados como parámetro del jugador actual
     * @param treasures Tesoros a descartar
     */
    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
        for (Treasure treasure : treasures){
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    /**
     * 
     * Introduce la lista de tesoros pasados como parámetro a la de tesoros visibles
     * @param treasures Lista con los tesoros que queremos descubrir
     */
    public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
        for (Treasure t : treasures){
            currentPlayer.makeTreasureVisible(t);
        }
    }
    
    /**
     * 
     * Realiza las gestiones necesarias para iniciar el juego:
     * inicializar los mazos de cartas, jugadores, enemigos...
     * @param players 
     */
    public void initGame(ArrayList<String> players) {
        initPlayers(players);
        setEnemies();
        dealer.initCards();
        nextTurn();
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
    
    /**
     * Comprueba que el jugador actual ha terminado su turno y se pasa al siguiente 
     * @return true si se puede pasar al siguiente jugador
     *         false en caso contrario
     */
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
     * @param result Resultado del combate
     * @return true si alguien gana
     *         false en caso contrario
     */
    public boolean endOfGame(CombatResult result) {
        if (result == CombatResult.WINGAME)
            return true;
        else
            return false;
    }
}
