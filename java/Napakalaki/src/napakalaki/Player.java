
package napakalaki;
import java.util.ArrayList;
/**
 *
 * @author victoria
 */
public class Player {
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private BadConsequence pendingBadConquence;
    private ArrayList<Treasure> hiddenTreasures;
    private ArrayList<Treasure> visibleTreasures;
    
    
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
     * 
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
    private int howManyVisible (TreasureKind tKind){
        int contador=0;
        for (Treasure t: visibleTreasures)
            if (t.getType() == tKind)
                ++contador;        
        return contador;
    }
}
