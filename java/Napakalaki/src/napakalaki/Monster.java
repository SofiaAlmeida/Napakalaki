package napakalaki;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class Monster {
    private String name;
    private int combatLevel;
   
    private Prize prize;
    private BadConsequence bc;
    
    /**
     * 
     * Constructor 
     * @param name Nombre del monstruo
     * @param level Nivel de combate del mostruo 
     * @param bc Mal rollo del monstruo
     * @param prize Premio al ganar al monstruo
     */
    public Monster(String name, int level, BadConsequence bc, Prize prize) {
        this.name = name;
        combatLevel = level;
        this.bc = bc;
        this.prize = prize;
    }
    
    /**
     * 
     * Consultor del nombre
     * @return Nombre del monstruo
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * Consultor del nivel de combate
     * @return Nivel del monstruo
     */
    public int getCombatLevel() {
        return combatLevel;
    }
    
    /**
     * 
     * Consultor del premio
     * @return Premio que se obtiene al ganar al monstruo
     */
    /*public Prize getPrize() {
        return prize;
    }*/
    
    /**
     * 
     * Mal rollo
     * @return Mal rollo aplicado al perder contra el monstruo
     */
    public BadConsequence getBadConsequence() {
        return bc;
    }

    /**
     * 
     * @return objeto String con la información relativa al monstruo
     */
    /*public String toString() {
        return  "\nName = " + name + "\nCombat Level = " + Integer.toString(combatLevel)
                + "\n" + prize.toString() + "\n" + bc.toString();
    }*/
    
    /**
     * 
     * Devuelve el número de niveles ganados porporcionados por su buen rollo
     * @return número de niveles ganados
     */
    public int getLevelsGained(){
        return prize.getLevel();
    }
    
    /**
     * 
     * Devuelve el número de tesoros ganados proporcionados por su buen rollo
     * @return número de tesoros ganados
     */
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
}
