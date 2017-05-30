package NapakalakiGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import GUI.Dice;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class Player {
    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    protected Player enemy;
    
    
    /**
     * 
     * Constructor
     * @param name Nombre del jugador
     */
    public Player(String name) {
        this.name = name;
        level = 1;
        dead = true;
        canISteal = true;
        pendingBadConsequence = null;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
        enemy = null; 
    }
    
    /**
     * 
     * Constructor copia
     * @param p Jugador a copiar
     */
    public Player(Player p) {
        name = p.name;
        level = p.level;
        dead = p.dead;
        canISteal = p.canISteal;
        pendingBadConsequence = p.pendingBadConsequence;
        hiddenTreasures = p.hiddenTreasures;
        visibleTreasures = p.visibleTreasures;
        enemy = p.enemy;
    }
    
    /**
     * 
     * Consultor del nivel máximo
     * @return nivel máximo de un jugador
     */
    public int getMaxLevel() {
        return MAXLEVEL;
    }
    
     /**
      * 
      * Consultor del nombre
      * @return nombre del jugador
      */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * Consultor del enemigo
     * @return jugador enemigo
     */
    public Player getEnemy() {
        return enemy;
    }
    
    /**
     * 
     * Consultor del mal rollo
     * @return mal rollo pendiente
     */
    public BadConsequence getPendingBc() {
        return pendingBadConsequence;
    }
    
     /**
      * 
      * Da vida al jugador
      */
    private void bringToLife() {
        dead = false;
    }
    
    /**
     * 
     * Consultor del nivel de combate
     * @return nivel de combate
     */
    public int getCombatLevel() {
        int combatLevel = level;
        for(Treasure treasure : visibleTreasures) {
           combatLevel += treasure.getBonus();
        }
        return combatLevel;
    }
    
    /**
     * 
     * Incrementa niveles
     * @param l Número de niveles a incrementar 
     */
    private void incrementLevels(int l) {
        if (l > 0) 
            if (level + l > MAXLEVEL) 
                level = MAXLEVEL;
            else 
                level += l;
    }
    
    /**
     * 
     * Decrementa niveles
     * @param l Número de niveles a decrementar 
     */
    private void decrementLevels(int l) {
        if (l > 0) 
            if (level - l < 1) 
                level = 1;
            else 
                level -= l;
            
    }
    
    /**
     * 
     * Asigna el mal rollo pendiente 
     * @param b 
     */
    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;
    }
    
    /**
     * 
     * Aplica el premio del monstruo
     * @param m monstruo del que aplicar el premio
     */
    private void applyPrize(Monster m) {
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        
        if (nTreasures > 0) {
            CardDealer dealer = CardDealer.getInstance();
            for (int i = 0; i < nTreasures; i++){
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }    
        }
    }
    
    /**
     * 
     * Aplica el mal rollo del monstruo
     * @param m monstruo del que aplicar el mal rollo
     */
    private void applyBadConsequence(Monster m) {
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    /**
     * 
     * Comprueba si un tesoro puede pasarse a visible
     * @param t tesoro para hacer visible
     * @return true si el tesoro puede ser visible
     *         false en caso contrario
     */
    private boolean canMakeTreasureVisible(Treasure t) {
        if (t.getType() == TreasureKind.ONEHAND) {
            if (howManyVisibleTreasures(TreasureKind.ONEHAND) < 2 && howManyVisibleTreasures(TreasureKind.BOTHHANDS) == 0) {
                return true;
            }
        } 
        else if (t.getType() == TreasureKind.BOTHHANDS) {
            if (howManyVisibleTreasures(TreasureKind.ONEHAND) == 0 && howManyVisibleTreasures(TreasureKind.BOTHHANDS) == 0) {
                return true; 
            }
        }
        else if (howManyVisibleTreasures(t.getType()) == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * 
     * Número de tesoros visibles de un determinado tipo
     * @param tKind tipo de tesoro a comparar
     * @return número 
     */
    private int howManyVisibleTreasures(TreasureKind tKind) {
        int contador=0;
        for (Treasure t : visibleTreasures)
            if (t.getType() == tKind)
                ++contador;
        return contador;   
    }
    
    /**
     * 
     * Cambia el estado a muerto si se pierden todos los tesoros
     */
    private void dieIfNoTreasures() {
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            dead = true;
    }
    
    /**
     * 
     * Consultor de dead
     * @return true si está muerto
     *         false en caso contrario
     */
    public boolean isDead() {
        return dead;
    }
    
    /**
     * 
     * Consultor de los tesoros ocultos
     * @return Array de los tesoros ocultos
     */
    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
    
     /**
     * 
     * Consultor de los tesoros visibles
     * @return Array de los tesoros visibles
     */
    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    /**
     * 
     * Simula un combate contra un monstruo. Si el jugador tiene un enemigo,
     * se sumará su nivel al del monstruo en caso de que salga un número menor
     * que 3 al tirar el dado. 
     * @param m monstruo contra el que luchar
     * @return CombatResult indicando cómo quedó el combate
     */
    public CombatResult combat(Monster m) {
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        if (!canISteal) {
           Dice dice = Dice.getInstance();
           int number = dice.nextNumber("Si sale un número menor que 3 se sumará el", 
                                " nivel de tu enemigo al del monstruo");
           
           if (number < 3){
               int enemyLevel = enemy.getCombatLevel();
               monsterLevel += enemyLevel;
           }
        }
        if (myLevel > monsterLevel) {
            applyPrize(m);
            if (level >= MAXLEVEL)
                return CombatResult.WINGAME;
            else
                return CombatResult.WIN;
        }
        else {
            applyBadConsequence(m);
            
            if(shouldConvert())
                return CombatResult.LOSEANDCONVERT;
            return CombatResult.LOSE;
        }
    }
    
    /**
     * 
     * Equipa un tesoro
     * @param t Tesoro a equipar
     */
    public void makeTreasureVisible(Treasure t) {
        boolean canI = canMakeTreasureVisible(t);
        if (canI) {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }            
    }
    
    /**
     * 
     * Descarta un tesoro visible para completar el mal rollo
     * @param t Tesoro a descartar
     */
    public void discardVisibleTreasure(Treasure t) {
        visibleTreasures.remove(t);
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()) {
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        
        dieIfNoTreasures();
    }
    
    /**
     * 
     * Descarta un tesoro visible para completar el mal rollo
     * @param t tesoro a descartar
     */
    public void discardHiddenTreasure(Treasure t) {
        hiddenTreasures.remove(t);
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()) {
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        
        dieIfNoTreasures();
    }
    
    /**
     * 
     * Comprueba si el estado de un jugador es válido
     * @return true si el jugador no tiene ningún mal rollo que cumplir
     *              y no tiene más de cuatro tesoros ocultos
     *         false en caso contrario
     */
    public boolean validState() {
        if (pendingBadConsequence == null || (pendingBadConsequence.isEmpty() && hiddenTreasures.size()<= 4)) 
            return true;
        else 
            return false;
    }
    
    /**
     * 
     * Tesoros iniciales del jugador
     */
    public void initTreasures() {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber("Si sacas un 1 tendrás un tesoro, si sacas un 6",
                 " tres tesoros, en otro caso tendrás 2");
        
        if (number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if (number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    /**
     * 
     * Consultor del nivel
     * @return nivel del jugador
     */
    public int getLevels() {
        return level;
    }
    
    /**
     * 
     * Nivel del oponente
     * @param m Monstruo contra el que luchar
     * @return Nivel del monstruo
     */
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevel();
    }
    /**
     * 
     * Roba un tesoro 
     * @return tesoro robado, null en caso de no poder robarse un tesoro
     */
    public Treasure stealTreasure() {
        boolean canI = canISteal();
        if (canI) {
            boolean canYou = enemy.canYouGiveMeATreasure();
            if (canYou) {
                Treasure treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                haveStolen();
                return treasure;
            }
        }
        return null;
    }
    
    /**
     * 
     * Modificador de enemy
     * @param enemy enemigo a asignar
     */
    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    
    /**
     * 
     * Elige un tesoro al azar entre los tesoros ocultos
     * @return un tesoro oculto
     */
    private Treasure giveMeATreasure() {
        Random rand = new Random();
        int posicion = rand.nextInt(hiddenTreasures.size());
        return hiddenTreasures.remove(posicion);
    }
    
    /**
     * 
     * Consultor de canISteal
     * @return true si el jugador puede robar una carta
     *         false en caso contrario
     */
    public boolean canISteal() {
        return canISteal;
    }
    
    /**
     * 
     * Consulta si le pueden robar un tesoro
     * @return true si el jugador tiene tesoros ocultos
     *         false en caso contrario
     */
    private boolean canYouGiveMeATreasure() {
        return !hiddenTreasures.isEmpty();
    }
    
    /**
     * 
     * Si el jugador roba un tesoro cambia el valor de canISteal
     */
    private void haveStolen() {
        canISteal = false;
    }
    
    /**
     * 
     * Descarta todos los tesoros del jugador
     */
    public void discardAllTreasures() {
        ArrayList<Treasure> copyVisibleTreasures = new ArrayList(visibleTreasures);
        for(Treasure treasure : copyVisibleTreasures) {
            discardVisibleTreasure(treasure);
        }
        
        ArrayList<Treasure> copyHiddenTreasures = new ArrayList(hiddenTreasures);
        for(Treasure treasure : copyHiddenTreasures) {
            discardHiddenTreasure(treasure);
        }
    }
     
    /**
     * 
     * @return String con la información del objeto 
     */
    public String toString() {
        return "\nNombre: " + name + "\nLevel: " + Integer.toString(level) + "\nMuerte: " + dead + 
                "\nPuede robar: " + canISteal + "\nMal rollo pendiente: " + pendingBadConsequence + 
                "\nTesoros ocultos: " + hiddenTreasures + "\nTesoros visibles: " + visibleTreasures +
                "\nEnemigo: " + enemy.getName();
    }
    
    /**
     * 
     * Indica si el jugador se convertirá en sectario
     * @return true, si al lanzar el dado sale un 6
     *         false, en caso contrario
     */
    protected boolean shouldConvert() {
        Dice dice = Dice.getInstance();
        int number = dice.nextNumber("", "Si sacas un 6 te convertirás en sectario");
        
        return number == 6;
    } 
}