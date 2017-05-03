#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class BadConsequence
    @@MAXTREASURES = 10

    def initialize(aText, someLevels)
      @text = aText
      @levels = someLevels
    end

    def self.getMaxTreasures
      @@MAXTREASURES
    end

    def getText
      @text
    end
    
    def getLevels
      @levels
    end

    def to_s
      "\n\tTexto: #{@text} \n\tNiveles: #{@levels}"
    end
  end
  
end

