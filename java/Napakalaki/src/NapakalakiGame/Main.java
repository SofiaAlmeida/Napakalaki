package NapakalakiGame;
import GUI.Dice;
import GUI.NapakalakiView;

import GUI.Dice;

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
        napakalakiView.setVisible(true);
        
    }   
}
