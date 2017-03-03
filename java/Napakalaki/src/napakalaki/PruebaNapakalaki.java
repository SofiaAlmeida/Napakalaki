/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    // Prueba clase Prize
        Prize prize = new Prize(1,1);
        
        System.out.println(Integer.toString(prize.getTreasures()));
        System.out.println(Integer.toString(prize.getLevel()));
        System.out.println(prize.toString());
    
    // Prueba del enum TreasureKind
        TreasureKind tk = TreasureKind.HELMET;
        
    // Prueba clase BadConsequence
        ArrayList<TreasureKind> tes = new ArrayList<TreasureKind>();
        tes.add(tk);
        BadConsequence bc1 = new BadConsequence("No muerte",2,3,4);
        BadConsequence bc2 = new BadConsequence("Muerte", true);
        BadConsequence bc3 = new BadConsequence("No muerte 3", 2, tes, tes);
        
        
        System.out.println(bc1);
        System.out.println(bc2);
        System.out.println(bc3);
        // Prueba de los consultores
        System.out.println(bc3.getText());
        System.out.println(bc3.getLevels());
        System.out.println(bc3.getNVisibleTreasures());
        System.out.println(bc3.getNHiddenTreasures());
        System.out.println(bc3.getDeath());
        System.out.println(bc3.getSpecificVisibleTreasures());
        System.out.println(bc3.getSpecificHiddenTreasures());
     
        // Prueba clase Monster
        Monster monster = new Monster("Nombre", 1, bc1, prize);
        System.out.println(monster);
        //Prueba de los consultores
        System.out.println(monster.getName());
        System.out.println(monster.getCombatLevel());
        System.out.println(monster.getBadConsequence());
        System.out.println(monster.getPrize());
    }
}
