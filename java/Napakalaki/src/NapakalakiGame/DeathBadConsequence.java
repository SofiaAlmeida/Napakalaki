
package NapakalakiGame;

/**
 *
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class DeathBadConsequence extends NumericBadConsequence {
    /**
     * 
     * Constructor
     * @param t Descripción del mal rollo
     */
    DeathBadConsequence(String t) {
        super(t, Player.MAXLEVEL, NumericBadConsequence.MAXTREASURES, NumericBadConsequence.MAXTREASURES);
    }
    
    /**
     * 
     * @return String con información del mal rollo
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
