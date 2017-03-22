#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class Monster
    def initialize(n, l, b, p)
      @name = n
      @combatLevel = l
      @prize = p
      @badConsequence = b
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

    def to_s
      "Nombre: #{@name} \nNivel de combate: #{@combatLevel} \nPremio: #{@prize} \nMal rollo: #{@badConsequence}"
    end

  end
end

