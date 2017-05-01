#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class Monster
    def initialize(n, l, b, p, lC)
      @name = n
      @combatLevel = l
      @prize = p
      @badConsequence = b
      @levelChangeAgainstCultistPlayer = lC
    end
    
    def self.newCultistMonster(n, l, b, p, lC)
      new(n, l, b, p, lC)
    end
    
    def self.newMonster(n, l, b, p)
      new(n, l, b, p, 0)
    end

    def getName
      @name
    end

    def getCombatLevel
      @combatLevel
    end

    def getBadConsequence
      @badConsequence
    end

    def getLevelsGained
      @prize.getLevels
    end

    def getTreasuresGained
      @prize.getTreasures
    end
    
    def getCombatLevelAgainstCultistPlayer
      @levelChangeAgainstCultistPlayer
    end

    def to_s
      "Nombre: #{@name} \nNivel de combate: #{@combatLevel} \nPremio: #{@prize} \nMal rollo: #{@badConsequence}"
    end
    private_class_method :new
  end
end

