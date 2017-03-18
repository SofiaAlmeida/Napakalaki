package napakalaki;
import java.util.ArrayList;

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
        level += l;
    }
    
    /**
     * 
     * Decrementa niveles
     * @param l Número de niveles a decrementar 
     */
    private void decrementLevels(int l) {
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
    }
    
    /**
     * 
     * Aplica el mal rollo del monstruo
     * @param m monstruo del que aplicar el mal rollo
     */
    private void applyBadConsequence(Monster m) {
    }
    
    /**
     * 
     * @param t
     * @return 
     */
    private boolean canMakeTreasureVisible(Treasure t) {
         
    }
    
    //REVIEW Ver si existe función que te diga el número de aparencia de un elemento en un array
    /**
     * 
     * Número de tesoros visibles de un determinado tipo
     * @param tKind tipo de tesoro a comparar
     * @return número 
     */
    private int howManyVisibleTreasures (TreasureKind tKind){
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
    private void dieIfNoTreasures(){
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()){
            dead = true;
        }
    }
    
    /**
     * 
     * Consultor de dead
     * @return true si está muerto
     *         false en caso contrario
     */
    public boolean isDead(){
        return dead;
    }
    
    /**
     * 
     * @return 
     */
    /*public ArrayList<Treasure> getHiddenTreasures(){
        
    }*/
    
     /**
     * 
     * @return 
     */
    /*public ArrayList<Treasure> getVisibleTreasures(){
        
    }*/
    
    /**
     * 
     * @param m
     * @return 
     */
    /*public CombatResult combat (Monster m){
        
    }*/
    
    /**
     * 
     * @param t 
     */
    public void makeTreasureVisible (Treasure t){
        
    }
    
    /**
     * 
     * @param t 
     */
    public void discardVisibleTreasure (Treasure t){
        
    }
    
    /**
     * 
     * @param t 
     */
    public void discardHiddenTreasure (Treasure t){
        
    }
    
    public boolean validState(){
        if (pendingBadConquence.isEmpty() && hiddenTreasures.size()<= 4)
            return true;
        else 
            return false;
    }
    
    public void initTreasures(){
        
    }
    
    /**
     * 
     * Consultor del nivel
     * @return nivel del jugador
     */
    public int getLevel(){
        return level;
    }
    
    /*public Treasure stealTreasure(){
        
    }*/
    
    /**
     * 
     * 
     * @param enemy 
     */
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    /*private boolean giveMeATreasure(){
        
    }*/
    
    public boolean canISteal (){
        return canISteal;
    }
    
    /**
     * 
     * Consulta si le pueden robar un tesoro
     * @return true si el jugador tiene tesoros ocultos
     *         false en caso contrario
     */
    private boolean canYouGiveMeATreasure (){
        if (!hiddenTreasures.isEmpty())
            return true;
        return false;
    }
    
    /**
     * 
     * Si el jugador roba un tesoro cambia canISteal
     */
    private void haveStolen(){
        canISteal = false;
    }
    
    public void discardAllTreasures(){
        
    }
}
