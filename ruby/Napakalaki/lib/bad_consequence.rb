#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class BadConsequence
    @@MAXTREASURES = 10

    def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, 
        someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
      @text = aText
      @levels = someLevels
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
      @specificHiddenTreasures = someSpecificVisibleTreasures
      @specificVisibleTreasures = someSpecificHiddenTreasures
      @death = death
    end

    def self.newLevelNumberOfTreasures(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
      new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, [], [], false)
    end

    def self.newLevelSpecificTreasures(aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      new(aText, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)
    end

    def self.newDeath(aText)
      new(aText, 0, 0, 0, [], [], true)
    end

    def self.getMaxTreasures
      @@MAXTREASURES
    end

    def isEmpty
      if @nHiddenTreasures == 0 and @nVisibleTreasures == 0 and
         @specificHiddenTreasures.empty? and @specificVisibleTreasures.empty?
          empty = true
      else 
          empty = false
      end
      empty
    end

    def getLevels
      @levels
    end

    def getNVisibleTreasures
      @nVisibleTreasures
    end

    def getNHiddenTreasures
      @nHiddenTreasures
    end

    def getSpecificHiddenTreasures
      @specificHiddenTreasures
    end

    def getSpecificVisibleTreasures
      @specificVisibleTreasures
    end


    def subtractVisibleTreasure(t)
      @specificVisibleTreasures.delete(t)
            
    end

    def subtractHiddenTreasure(t)
      @specificHiddenTreasues.delete(t)
      
    end
=begin
    def adjustToFitTreasureLists(v, h)

    end
=end

    def to_s
      if @death==false
        if @specificVisibleTreasures.nil? and @specificHiddenTreasures.nil? 
          "\n\tTexto: #{@text} \n\tNiveles: #{@levels} \n\tTesoros visibles: #{@nVisibleTreasures}\n\tTesoros ocultos: #{@nHiddenTreasures}"
        else
          "\n\tTexto: #{@text} \n\tNiveles: #{@levels} \n\tTesoros ocultos específicos:
          #{@specificHiddenTreasures} \n\tTesoros visibles específicos: #{@specificVisibleTreasures}"
        end
      else
        "\n\tTexto: #{@text} \n\tMuerto"
      end

    end

    private_class_method :new
  end
end
