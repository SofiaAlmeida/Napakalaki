package NapakalakiGame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class CardDealer {
    private static CardDealer instance = null;
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultists = new ArrayList();
    
    /**
     * 
     * Constructor vacío
     */
    private CardDealer() { }
    
    /**
     * 
     * Inicializa el mazo de cartas no usadas de tesoros
     */
    private void initTreasureCardDeck () {
        unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND)); 
        unusedTreasures.add(new Treasure("Necro-playboycón", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOE));
    }
    
    /**
     * 
     * Inicializa el mazo de cartas no usadas de monstruos
     */
    private void initMonsterCardDeck() {
        BadConsequence bc;
        Prize prize;
        
        bc = new BadConsequence("Pierdes tu armadura visible y otra oculta", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR )),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize (2, 1);
        unusedMonsters.add (new Monster("3 Byakhees de bonanza", 8, bc, prize));
       
        bc = new BadConsequence("Embobados con el lindo primigenio te descartas "
                + "de tu casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize (1, 1);
        unusedMonsters.add (new Monster("Tenochtitlan", 2, bc, prize));
       
        bc = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 
                0, new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bc, prize));
        
        bc = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. "
                + "Descarta 1 mano visible y 1 mano oculta", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Demonios de Magaluf", 2, bc, prize));
        
        bc = new BadConsequence("Pierdes todos tus tesoros visibles", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 13, bc, prize));
        
        bc = new BadConsequence("Pierdes la armadura visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, bc, prize));
        
        bc = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible", 
                0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Necrófago", 13, bc, prize));
        
        bc = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(3, 2);
        unusedMonsters.add(new Monster("El rey de rosado", 11, bc, prize));
        
        bc = new BadConsequence("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Flecher", 2, bc, prize));
        
        bc = new BadConsequence("Estos monstruos resultan bastante superficiales "
                + "y te aburren mortalmente. Estás muerto", true);
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, bc, prize));
        
        bc = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize (2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, bc, prize));

        bc = new BadConsequence ("Te intentas escaquear. Pierdes una mano visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND )), new ArrayList());
        prize = new Prize (2, 1);
        unusedMonsters.add (new Monster("Dameargo", 1, bc, prize));
        
        bc = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, bc, prize));
        
        bc = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto", true);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 14, bc, prize));
        
        bc = new BadConsequence("La familia te atrapa. Estás muerto", true);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, bc, prize));
        
        bc = new BadConsequence("La quinta directiva primaria te obliga a perder "
                + "2 niveles y un tesoro de 2 manos visible", 2, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, bc, prize));
        
        bc = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espía sordo", 5, bc, prize));
        
        bc = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 
                                2, 5, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Tongue", 19, bc, prize));
        
        bc = new BadConsequence("Te faltan manos para tanta cabeza. "
                + "Pierdes 3 niveles y tus tesoros visibles de las manos", 3, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND)), 
                new ArrayList());
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, bc, prize));
        
        // Monstruos con sectarios
        bc = new BadConsequence("Pierdes una mano visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, bc, prize, -2));
        
        bc = new BadConsequence("Pierdes tus tesoros visibles. Ja ja ja.", 0, 
                BadConsequence.MAXTREASURES, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, bc, prize, 2));
        
        bc = new BadConsequence("Hoy no es tu día de suerte. Mueres.", true);
        prize = new Prize (2, 5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, bc, prize, 4));
        
        bc = new BadConsequence("Tu gobierno te recorta 2 niveles.", 2, 
                0, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Serpiente Político", 8, bc, prize, -2));
        
        bc = new BadConsequence("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.", 
                0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND)));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, bc, prize, 5));
        
        bc = new BadConsequence("Pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(4, 2);
        unusedMonsters.add(new Monster("Shoggoth", 16, bc, prize, -4));
        
        bc = new BadConsequence("Pintalabios negro. Pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, bc, prize, 3));
    }
    
    /**
     * 
     * Inicializa el mazo de cartas no usadas de los sectarios
     */
    private void initCultistCardDeck() {
        
        /*
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 2));
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 2));
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 1));
        */
        
        //REVIEW: ¿Con un bucle mejor?
        for(int i = 0; i < 4; ++i)
            unusedCultists.add(new Cultist("Sectario", 1));
        for(int i = 0; i < 2; ++i)
            unusedCultists.add(new Cultist("Sectario", 2));
    }
    
    /**
     * 
     * Baraja el mazo de cartas de tesoros sin usar
     */
    private void shuffleTreasures() {
        Collections.shuffle(unusedTreasures);
    }
    
    /**
     * 
     * Baraja el mazo de cartas de monstruos sin usar
     */
    private void shuffleMonsters() {
        Collections.shuffle(unusedMonsters);
    }
    
    /**
     * 
     * Baraja el mazo de cartas de sectarios sin usar
     */
    private void shuffleCultist() {
        Collections.shuffle(unusedCultists);
    }
    
    /**
     * 
     * @return la única instancia de esta clase
     */
    public static CardDealer getInstance() {
        if (instance == null)
            instance = new CardDealer();
        return instance;
    }
    
    /**
     * 
     * @return El siguiente monstruo de la baraja
     */
    public Treasure nextTreasure() {
        if (unusedTreasures.isEmpty()) {
            for (Treasure t : usedTreasures)
                unusedTreasures.add(t);
            usedTreasures.clear();
            shuffleTreasures();
        }
        Treasure treasure = unusedTreasures.get(0);
        unusedTreasures.remove(treasure);
        return treasure;
    }
    
    /**
     * 
     * @return El siguiente monstruo de la baraja
     */
    public Monster nextMonster() {
        if (unusedMonsters.isEmpty()){
            for (Monster m :  usedMonsters)
                unusedMonsters.add(m);
            usedMonsters.clear();
            shuffleMonsters();
        }
        Monster monster = unusedMonsters.get(0);
        unusedMonsters.remove(monster);
        return monster;
    }

    /**
     * 
     * @return El siguiente sectario de la baraja
     */
    public Cultist nextCultist() {
        if (unusedCultists.isEmpty()){
            // REVIEW: ¿QUÉ HACEMOS EN ESTE CASO?
        }
        Cultist cultist = unusedCultists.get(0);
        unusedCultists.remove(cultist);
        return cultist;
    }
    
    /**
     * 
     * Introduce el tesoro en el mazo de tesoros descartados
     * @param t Tesoro a descartar
     */
    public void giveTreasureBack(Treasure t) {
        usedTreasures.add(t);
    }
    
    /**
     * 
     * Introduce el monstruo en el mazo de monstruos descartados
     * @param m Monstruo a descartar
     */
    public void giveMonsterBack(Monster m) {
        usedMonsters.add(m);
    }
    
    /**
     * 
     * Inicializa el mazo de tesoros y el de monstruos
     */
    public void initCards() {
        initTreasureCardDeck();
        shuffleTreasures();
        initMonsterCardDeck();
        shuffleMonsters();
        initCultistCardDeck();
        shuffleCultist();
    }
}   

