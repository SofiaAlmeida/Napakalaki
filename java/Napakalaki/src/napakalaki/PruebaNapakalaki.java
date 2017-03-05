/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class PruebaNapakalaki {

    static ArrayList<Monster> monstruos = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     /*   
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
        */
        
        
           //Monstruos
        BadConsequence bc;
        Prize prize;
        /*
        param: text, nivel, nVisible, nHidden
        param: ntreasures, level
        param: combatlevel
        bc = new BadConsequence("", , , );
        prize = new Prize( , );
        monstruos.add(new Monster("", , bc, prize));
        
        param: text, death
        param: ntreasures, level
        param: combatlevel
        bc = new BadConsequence("", true);
        prize = new Prize ( , );
        monstruos.add(new Monster ("", , bc, prize));
        
        param: text, levels, tvisible, thidden
        param: ntrasures, level
        param: combatlevel
        bc = new BadConsequence ("", , 
                new ArrayList(Arrays.asList(TreasureKind. )),
                new ArrayList(Array.asList(TreasureKind. )));
        prize = new Prize ( , );
        monstruos.add (new Monster ("", , bc, prize));
       */
        
        bc = new BadConsequence ("Pierdes tu armadura visible y otra oculta", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR )),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        
        prize = new Prize (2, 1);
        monstruos.add (new Monster ("Byakhees de bonanza", 8, bc, prize));
       
        
        bc = new BadConsequence ("Embobados con el lindo primigenio te descartas "
                + "de tu casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize (1, 1);
        monstruos.add (new Monster ("Tenochtitlan", 2, bc, prize));
       
        
        bc = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 
                0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, bc, prize));
        
        
        bc = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. "
                + "Descarta 1 mano visible y 1 mano oculta. ", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Demonios de Magaluf", 2, bc, prize));
        
        
        bc = new BadConsequence("Pierdes todos tus tesoros visibles. ", 0, Integer.MAX_VALUE, 0);
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 13, bc, prize));
        
        
        bc = new BadConsequence("Pierdes la armadura visible. ", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, bc, prize));
        
        
        bc = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 
                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Necrófago", 13, bc, prize));
              
        
        bc = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(3, 2);
        monstruos.add(new Monster("El rey de rosado", 11, bc, prize));
        
        
        bc = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        monstruos.add(new Monster("Flecher", 2, bc, prize));
        
        
        bc = new BadConsequence("Estos monstruos resultan bastante superficiales "
                + "y te aburren mortalmente. Estás muerto", true);
        prize = new Prize (2, 1);
        monstruos.add(new Monster ("Los hondos", 8, bc, prize));
        
        
        bc = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prize = new Prize (2, 1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, bc, prize));

        
        bc = new BadConsequence ("Te intentas escaquear. Pierdes una mano visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND )), new ArrayList());
        prize = new Prize (2, 1);
        monstruos.add (new Monster ("Dameargo", 1, bc, prize));
        
        
        
       
        bc = new BadConsequence("Da mucho asquito. Pierdes 3 niveles. ", 3, 0, 0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Pollipólipo volante", 3, bc, prize));
        
        
        bc = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 14, bc, prize));
        
        
        bc = new BadConsequence("La familia te atrapa. Estás muerto. ", true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Familia feliz", 1, bc, prize));
        
        
        bc = new BadConsequence("La quinta directiva primaria te obliga a perder "
                + "2 niveles y un tesoro de 2 manos visible. ", 2, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth", 8, bc, prize));
        
        
        bc = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El espía sordo", 5, bc, prize));
        
        
        bc = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles. ", 
                                2, 5, 0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Tongue", 19, bc, prize));
        
        
        bc = new BadConsequence("Te faltan manos para tanta cabeza. "
                + "Pierdes 3 niveles y tus tesoros visibles de las manos. ", 3, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND, TreasureKind.ONEHAND)), 
                new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Bicéfalo", 21, bc, prize));
       
    }
}
