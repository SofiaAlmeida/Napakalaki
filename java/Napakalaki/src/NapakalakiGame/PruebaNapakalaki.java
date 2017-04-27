package NapakalakiGame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;


/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class PruebaNapakalaki {

    static ArrayList<Monster> monstruos = new ArrayList();
   
    /**
     * 
     * Monstruos con nivel de combate mayor que 10
     * @param m lista de monstruos de la que evaluar el nivel de combate
     * @return lista de monstruos cuyo nivel de combate es mayor que 10
     */
    public static ArrayList<Monster> combatLevelGt10(ArrayList<Monster> m) {
        ArrayList<Monster> result = new ArrayList();
        
        for(Monster monster : m)
            if(monster.getCombatLevel() > 10)
                result.add(monster);
        
        return result;
    }
    
    /**
     * 
     * Monstruos que no pierden tesoros
     * @param m lista de monstruos a evaluar
     * @return lista de monstruos que solo hacen perder niveles
     */
    public static ArrayList<Monster> lossLevel(ArrayList<Monster> m) {
        ArrayList<Monster> result = new ArrayList();
        
        for(Monster monster : m)
            if(((NumericBadConsequence) monster.getBadConsequence()).getNHiddenTreasures() == 0 &&
               ((NumericBadConsequence) monster.getBadConsequence()).getNVisibleTreasures() == 0 &&
               ((SpecificBadConsequence) monster.getBadConsequence()).getSpecificHiddenTreasures().isEmpty() &&
               ((SpecificBadConsequence) monster.getBadConsequence()).getSpecificVisibleTreasures().isEmpty())
                 
                   result.add(monster);
        
        return result;
    }
    
    /**
     * 
     * Monstruos que ganan más de 1 nivel
     * @param m lista de monstruos a evaluar
     * @return lista de monstruos que hacen ganar más de 1 nivel
     */
    public static ArrayList<Monster> levelGt1(ArrayList<Monster> m) {
        ArrayList<Monster> result = new ArrayList();
        
        for(Monster monster : m)
            if(monster.getTreasuresGained() > 1)
                result.add(monster);
        
        return result; 
    }
    
    /**
     * 
     * Monstruos que hacen perder el tipo de tesoro pasado como argumento
     * @param m lista de monstruos a evaluar
     * @param t tipo de tesoro a encontrar
     * @return listado de monstruos que incluyen t en su mal rollo
     */
    public static ArrayList<Monster> lossTreasure(ArrayList<Monster> m, TreasureKind t) {
        ArrayList<Monster> result = new ArrayList();
        
        for(Monster monster : m)
            if(((SpecificBadConsequence) monster.getBadConsequence()).getSpecificHiddenTreasures().contains(t)
               || ((SpecificBadConsequence) monster.getBadConsequence()).getSpecificVisibleTreasures().contains(t))  
                result.add(monster);
        
        return result;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        BadConsequence bc;
        Prize prize;
        
        //Añadimos los monstruos
        //------------------MONSTRUOS Y PRUEBAS FUNCIONES-----------------------
        /*
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
                0, new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, bc, prize));
        
        
        bc = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. "
                + "Descarta 1 mano visible y 1 mano oculta. ", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Demonios de Magaluf", 2, bc, prize));
        
        
        bc = new BadConsequence("Pierdes todos tus tesoros visibles. ", 0, 5, 0);
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 13, bc, prize));
        System.out.println(bc);
        
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
       
        
        // Probamos los métodos de la clase PruebaNapakalaki
        ArrayList<Monster> m1 = new ArrayList();
        
        m1 = combatLevelGt10(monstruos);
        System.out.println("Monstruos con nivel mayor que 10: \n" + m1);
        
        m1 = lossLevel(monstruos);
        System.out.println("Monstruos que solo hacen perder niveles: \n" + m1);
        
        m1 = levelGt1(monstruos);
        System.out.println("Monstruos que hacen ganar más de 1 nivel: \n" + m1);
        
        m1 = lossTreasure(monstruos, TreasureKind.ARMOR);
        System.out.println("Monstruos que hacen perder tesoros de tipo armadura:\n" +m1);
        
        m1 = lossTreasure(monstruos, TreasureKind.ONEHAND);
        System.out.println("Monstruos que hacen perder tesoros de una mano:\n" +m1);
        
        m1 = lossTreasure(monstruos, TreasureKind.BOTHHANDS);
        System.out.println("Monstruos que hacen perder tesoros de dos manos:\n" +m1);
        
        m1 = lossTreasure(monstruos, TreasureKind.HELMET);
        System.out.println("Monstruos que hacen perder tesoros de tipo cubrecabeza:\n" +m1);
        
        m1 = lossTreasure(monstruos, TreasureKind.SHOE);
        System.out.println("Monstruos que hacen perder tesoros de tipo calzado:\n" +m1);
        */
        
    //Prueba clase Player
        Player jugador = new Player ("Nombreeee");
        System.out.println("\n\n\nplayeeeer");
        //System.out.println(jugador.howManyVisibleTreasures(TreasureKind.HELMET));
        //---------------PRUEBAS DE LAS CLASES---------------
    // Prueba clase Prize
        Prize prize1 = new Prize(1,1);
        
        System.out.println(Integer.toString(prize1.getTreasures()));
        //System.out.println(Integer.toString(prize.getLevel()));
        System.out.println(prize1.toString());
    
    // Prueba del enum TreasureKind
        TreasureKind tk = TreasureKind.HELMET;
        
    // Prueba clase BadConsequence
        ArrayList<TreasureKind> tes = new ArrayList();
        tes.add(tk);
        BadConsequence bc1 = new NumericBadConsequence("No muerte",2,3,4);
        BadConsequence bc2 = new DeathBadConsequence("Muerte");
        BadConsequence bc3 = new SpecificBadConsequence("No muerte 3", 2, tes, tes);
        
        
        System.out.println(bc1);
        System.out.println(bc2);
        System.out.println(bc3);
        // Prueba de los consultores
        //System.out.println(bc3.getText());
        System.out.println(bc3.getLevels());
        System.out.println(((NumericBadConsequence) bc3).getNVisibleTreasures());
        System.out.println(((NumericBadConsequence) bc3).getNHiddenTreasures());
        //System.out.println(bc3.getDeath());
        System.out.println(((SpecificBadConsequence) bc3).getSpecificVisibleTreasures());
        System.out.println(((SpecificBadConsequence) bc3).getSpecificHiddenTreasures());
     
    // Prueba clase Monster
        Monster monster = new Monster("Nombre", 1, bc1, prize1);
        System.out.println(monster);
        //Prueba de los consultores
        System.out.println(monster.getName());
        System.out.println(monster.getCombatLevel());
        System.out.println(monster.getBadConsequence());
        //System.out.println(monster.getPrize());
      
    //---------------PLANTILLA MONSTRUOS---------------
        
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
        
        System.out.println("PRUEBA NÚMERO ALEATORIO");
        for (int i=0; i<50; i++){
            Random rand = new Random();
            int num = rand.nextInt(5 + 1) + 1;
            System.out.println(num);
        }
        ArrayList<Monster> unusedMonsters = new ArrayList();
        bc = new SpecificBadConsequence("Pierdes la armadura visible. ", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, bc, prize));
        
        
        bc = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 
                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Necrófago", 13, bc, prize));
              
        
        bc = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(3, 2);
        unusedMonsters.add(new Monster("El rey de rosado", 11, bc, prize));
        
        System.out.println(unusedMonsters);
        Collections.shuffle(unusedMonsters);
        System.out.println(unusedMonsters);
    }
}
