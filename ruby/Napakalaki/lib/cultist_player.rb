#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class CultistPlayer < Player
    @@totalCultistPlayers
    def initialize (p, c)
      super(p)
      @myCultistCard = c
      @@totalCultistPlayers += 1
    end
    
    def getTotalCultistPlayer
      @@totalCultistPlayers
    end
    
    protected
    def getCombatLevel
      combatLevel = 1.7*super.getCombatLevel + @myCultistCard.getGainedLevels*@@totalCultistPlayers
      combatLevel #pasar a int
    end
    def getOponentLevel
      
    end
    def shouldConvert
      false
    end
    private
    def giveMeATresure
      
    end
    
    def canYouGiveMeATreasure
      
    end
  end
end
