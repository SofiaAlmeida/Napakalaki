/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author usuario
 */
public class Monster {
    private String name;
    private int combatLevel;
   
    private Prize prize;
    private BadConsequence bc;
    
    public Monster(String name, int level, BadConsequence bc, Prize prize) {
        this.name = name;
        combatLevel = level;
        this.bc = bc;
        this.prize = prize;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCombatLevel() {
        return combatLevel;
    }
    
    public Prize getPrize() {
        return prize;
    }
    
    public BadConsequence getBadConsequence() {
        return bc;
    }

    public String toString() {
        return "Name = " + name + "\nCombat Level = " + Integer.toString(combatLevel)
                + "\n" + prize.toString() + "\n" + bc.toString();
    }
}
