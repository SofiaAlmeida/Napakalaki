package NapakalakiGame;
import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import GUI.TreasureView;
import java.util.ArrayList;


/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);
        napakalakiView.setNapakalaki(game);
        
        
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        names = namesCapture.getNames();
        game.initGame(names);
        
        
        TreasureView treasure = new TreasureView();
        treasure.setTreasure(new Treasure ("prueba", 7, TreasureKind.ARMOR));
        treasure.setVisible(true);
        napakalakiView.setVisible(true);
        
    }   
}
