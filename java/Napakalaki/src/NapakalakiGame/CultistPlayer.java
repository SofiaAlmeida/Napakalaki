package NapakalakiGame;

import java.util.Random;

/**
 * 
 * @author Sofía Almeida Bruno
 * @author María Victoria Granados Pozo
 */
public class CultistPlayer extends Player {
    static private int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    /**
     * 
     * Constructor
     * @param p Jugador
     * @param c Sectario
     */
    public CultistPlayer(Player p, Cultist c) {
        super(p);
        totalCultistPlayers++;
        myCultistCard = c;
    }
    
    /**
     * 
     * Nivel de combate del sectario:
     *      Nivel de combate + 0.7*nivel de combate + niveles de sectario*número de sectarios
     * @return Nivel de combate
     */
    @Override
    protected int getCombatLevel() {
        double combatLevel = 1.7*super.getCombatLevel() + myCultistCard.getGainedLevels()*totalCultistPlayers;
        return (int) combatLevel;                  
    }
    
    
    /**
     * 
     * Nivel del oponente
     * @param m Monstruo contra el que luchar
     * @return Nivel del monstruo
     */
    @Override
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    /**
     * 
     * Un sectario no puede dejar de serlo, ni convertirse otra vez
     * @return false
     */
    @Override
    protected boolean shouldConvert() {
        return false;
    }
    
    /**
     * 
     * Elige un tesoro al azar entre los tesoros visibles
     * @return un tesoro visible
     */
    private Treasure giveMeATreasure() {
        Random rand = new Random();
        int posicion = rand.nextInt(getVisibleTreasures().size());
        getVisibleTreasures().remove(posicion);    
        return getVisibleTreasures().get(posicion);
    }
    
     /**
     * 
     * Consulta si le pueden robar un tesoro
     * @return true si el jugador tiene tesoros visibles
     *         false en caso contrario
     */
    private boolean canYouGiveMeATreasure() {
        return !getVisibleTreasures().isEmpty();
    }
    
    public int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
}
