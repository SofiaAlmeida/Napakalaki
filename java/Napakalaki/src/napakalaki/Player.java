package napakalaki;
import java.util.ArrayList;
import java.util.Collections;

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
    private Player enemy;
    
    
    /**
     * 
     * Constructor
     * @param name Nombre del jugador
     */
    public Player(String name) {
        this.name = name;
        level = 0;
        dead = true;
        canISteal = true;
        pendingBadConsequence = null;
        hiddenTreasures = new ArrayList();
        visibleTreasures = new ArrayList();
        enemy = null; 
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
    private int getCombatLevel() {
        int combatLevel = level;
        for(Treasure treasure: visibleTreasures) {
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
            if (level+l <= MAXLEVEL)
                level += l;
            else
                level = MAXLEVEL;
    }
    
    /**
     * 
     * Decrementa niveles
     * @param l Número de niveles a decrementar 
     */
    private void decrementLevels(int l) {
        if (l > 0)
            if (level-l > 0)
                level -= l;
            else
                level = 1;
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
    /*private void applyPrize(Monster m) {  
    }*/
    
    /**
     * 
     * Aplica el mal rollo del monstruo
     * @param m monstruo del que aplicar el mal rollo
     */
    /*private void applyBadConsequence(Monster m) {
    }*/
    
    /**
     * 
     * @param t
     * @return 
     */
    /*private boolean canMakeTreasureVisible(Treasure t) {
         
    }*/
    
    /**
     * 
     * Número de tesoros visibles de un determinado tipo
     * @param tKind tipo de tesoro a comparar
     * @return número 
     */
    public int howManyVisibleTreasures(TreasureKind tKind) {
        int contador=0;
        for (Treasure t: visibleTreasures)
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
     * @return 
     */
    /*public ArrayList<Treasure> getHiddenTreasures() {
        
    }*/
    
     /**
     * 
     * @return 
     */
    /*public ArrayList<Treasure> getVisibleTreasures() {
        
    }*/
    
    /**
     * 
     * @param m
     * @return 
     */
    /*public CombatResult combat(Monster m) {
        
    }*/
    
    /**
     * 
     * @param t 
     */
    /*public void makeTreasureVisible(Treasure t) {
        
    }*/
    
    /**
     * 
     * @param t 
     */
    /*public void discardVisibleTreasure(Treasure t) {
        
    }*/
    
    /**
     * 
     * @param t 
     */
    /*public void discardHiddenTreasure (Treasure t){
        
    }*/
    
    /**
     * 
     * Comprueba si el estado de un jugador es válido
     * @return true si el jugador no tiene ningún mal rollo que cumplir
     *              y no tiene más de cuatro tesoros ocultos
     *         false en caso contrario
     */
    public boolean validState() {
        if (pendingBadConsequence.isEmpty() && hiddenTreasures.size()<= 4)
            return true;
        else 
            return false;
    }
    
    /**
     * 
     */
    /*public void initTreasures() {
        
    }*/
    
    /**
     * 
     * Consultor del nivel
     * @return nivel del jugador
     */
    public int getLevels() {
        return level;
    }
    
    /*public Treasure stealTreasure() {
        
    }*/
    
    /**
     * 
     * 
     * @param enemy 
     */
    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    
    /*private Treasure giveMeATreasure() {
        
    }*/
    
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
        if (hiddenTreasures.isEmpty())
            return false;
        return true;
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
     * 
     */
    /*public void discardAllTreasures() {
        
    }*/
}
