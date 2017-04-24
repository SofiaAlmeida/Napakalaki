package NapakalakiGame;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class Monster {
    private String name;
    private int combatLevel;

    private Prize prize;
    private BadConsequence badConsequence;
    
    private int levelChangeAgainstCultistPlayer; 
    
    /**
     * 
     * Constructor 
     * @param n Nombre del monstruo
     * @param l Nivel de combate del mostruo
     * @param b Mal rollo del monstruo
     * @param p Premio al ganar al monstruo
     */
    public Monster(String n, int l, BadConsequence b, Prize p) {
        name = n;
        combatLevel = l;
        levelChangeAgainstCultistPlayer = 0;
        badConsequence = b;
        prize = p;
    }
    
    /**
     * 
     * Constructor 
     * @param n Nombre del monstruo
     * @param l Nivel de combate del mostruo
     * @param b Mal rollo del monstruo
     * @param p Premio al ganar al monstruo
     * @param lC Nivel del sectario
     */
    public Monster(String n, int l, BadConsequence b, Prize p, int lC) {
        name = n;
        combatLevel = l;
        badConsequence = b;
        prize = p;
        levelChangeAgainstCultistPlayer = lC;
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
     * Consultor del nivel afectado por el sectario
     * @return Nivel del sectario
     */
    public int getCombatLevelAgainstCultistPlayer() {
        return levelChangeAgainstCultistPlayer + getCombatLevel();
    }
    
    //REVIEW: no sale en el diagrama de clases, ¿lo borramos?
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
        return badConsequence;
    }
    
    /**
     * 
     * Devuelve el número de niveles ganados porporcionados por su buen rollo
     * @return número de niveles ganados
     */
    public int getLevelsGained() {
        return prize.getLevels();
    }
    
    /**
     * 
     * Devuelve el número de tesoros ganados proporcionados por su buen rollo
     * @return número de tesoros ganados
     */
    public int getTreasuresGained() {
        return prize.getTreasures();
    }
    
    //No sale en el diagrama de clases, pero seguramente lo utilizaremos para comprobar
    /**
     * 
     * @return objeto String con la información relativa al monstruo
     */
    public String toString() {
        return  "\nName = " + name + "\nCombat Level = " + Integer.toString(combatLevel)
                + "\n" + prize.toString() + "\n" + badConsequence.toString();
    }
}
