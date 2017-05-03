#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class CultistPlayer < Player
    @@totalCultistPlayers = 0
    
    def initialize(p, c)
      super(p)  
      newCopy(p)
      @myCultistCard = c
      @@totalCultistPlayers += 1
    end
    
    # Sectarios en juego
    def getTotalCultistPlayer
      @@totalCultistPlayers
    end
    
    # Elige un tesoro al azar entre los tesoros visibles
    def giveMeATresure
      posicion = rand(getVisibleTreasures.length)
      getVisibleTreasures.delete_at(posicion)
    end
    
    # Consulta si le pueden robar un tesoro
    def canYouGiveMeATreasure
      !getVisibleTreasures.empty?
    end
    
    def to_s
      "\nHolaa!! Soy sectario \n" + super
    end
    
    protected
    # Nivel de combate
    def getCombatLevel
      combatLevel = 1.7*super + @myCultistCard.getGainedLevels*@@totalCultistPlayers
      combatLevel.to_i 
    end
    
    # Nivel del oponente
    def getOponentLevel(m)
      m.getCombatLevelAgainstCultistPlayer
    end
    
    # Un sectario no puede dejar de serlo
    def shouldConvert
      false
    end
  end
end
