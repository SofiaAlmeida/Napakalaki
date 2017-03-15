
package napakalaki;
import java.util.ArrayList;
/**
 *
 * @author victoria
 */
public class Player {
    //public static int final MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private BadConsequence pendingBadConquence;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    private Player enemy;
    
    
    /**
     * 
     * Constructor
     * @param name Nombre del jugador
     */
    public Player (String name){
        this.name = name;
        level = 0;
    }
     /**
      * 
      * Consultor del nombre
      * @return nombre del jugador
      */
    public String getName(){
        return name;
    }
     /**
      * 
      * Da vida al jugador
      */
    private void bringToLife(){
        dead = false;
    }
    
    //REVIEW WARMING
    /**
     * 
     * Consultor del nivel de combate
     * @return nivel de combate
     */
    private int getCombatLevel(){
        for(Treasure treasure: visibleTreasures){
           level += treasure.getBonus();
        }
        return level;
    }
    
    /**
     * 
     * Incrementa niveles
     * @param l Número de niveles a incrementar 
     */
    private void incrementLevels(int l){
        level += l;
    }
    
    /**
     * 
     * Decrementa niveles
     * @param l Número de niveles a decrementar 
     */
    private void decrementLevels(int l){
        level -= l;
    }
    
    /**
     * 
     * Asigna la mala consecuencia pendiente 
     * @param b 
     */
    private void setPendingBadConsequence (BadConsequence b){
        pendingBadConquence = b;
    }
    
    /**
     * 
     * Aplica el premio del monstruo
     * @param m monstruo del que aplicar el premio
     */
    private void applyPrize (Monster m){  
    }
    
    /**
     * 
     * Aplica la mala consecuencia del monstruo
     * @param m monstruo del que aplicar el premio
     */
    private void applyBadConsequence (Monster m){
    }
    
    /**
     * REVIEW
     * 
     * @param tKind 
     * @return 
     */
    /*private boolean canMakeTreasureVisible (TreasureKind tKind){
        
    }*/
    
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
        if (pendingBadConquence.isEmpty() && hiddenTreasures.size())
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
    
    private boolean giveMeATreasure(){
        
    }
    
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
