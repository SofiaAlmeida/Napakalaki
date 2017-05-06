#encoding: utf-8

require_relative "bad_consequence"

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class NumericBadConsequence < BadConsequence
    def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
      super(aText, someLevels)
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
    end
    
    def isEmpty
      @nHiddenTreasures == 0 and @nVisibleTreasures == 0
    end
    
    def getNVisibleTreasures
      @nVisibleTreasures
    end

    def getNHiddenTreasures
      @nHiddenTreasures
    end
    
    def substractVisibleTreasure(t)
      @nVisibleTreasures -= 1      
            
    end

    def substractHiddenTreasure(t)
      @nHiddenTreasures -= 1
      
    end
    
    def adjustToFitTreasureLists(v, h)
      if v.count < @nVisibleTreasures
        nVT = v.count
      else
        nVT = @nVisibleTreasures
      end
      if h.count < @nHiddenTreasures
        nHT = h.count
      else
        nHT = @nHiddenTreasures
      end
      NumericBadConsequence.new(@text, @levels, nVT, nHT)
    end
    
    def to_s
      super + "\n\tTesoros visibles: #{@nVisibleTreasures}\n\tTesoros ocultos: #{@nHiddenTreasures}"
    end
    
  end
end
