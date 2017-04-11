package NapakalakiGame;
import java.util.Random;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class Dice {
    private static Dice instance = null;
    
    /**
     * 
     * Constructor vacío
     */
    private Dice() { }
    
    public static Dice getInstance() {
        if (instance == null)
            instance = new Dice();
        return instance;
    }
    
    public int nextNumber() {
        Random rand = new Random();
        int num = rand.nextInt(5 + 1) + 1; //(max-1+min)+min
        return num;
    }
}
