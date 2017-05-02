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

    def isEmpty
      if @nHiddenTreasures == 0 and @nVisibleTreasures == 0 and
         @specificHiddenTreasures.empty? and @specificVisibleTreasures.empty?
        true
      else 
        false
      end
    end

    def getLevels
      @levels
    end
=begin
    def getSpecificHiddenTreasures
      @specificHiddenTreasures
    end

    def getSpecificVisibleTreasures
      @specificVisibleTreasures
    end


    def substractVisibleTreasure(t)
      if @specificVisibleTreasures.empty? 
        @nVisibleTreasures -= 1
      else
        @specificVisibleTreasures.delete(t.getType)
      end
            
    end

    def substractHiddenTreasure(t)
      if @specificHiddenTreasures.empty?
        @nHiddenTreasures -= 1
      else
        @specificHiddenTreasures.delete(t.getType)
      end
      
    end
    
    def adjustToFitTreasureLists(v, h)
      if @specificVisibleTreasures.empty? and @specificHiddenTreasures.empty? 
        # Si no hay tesoros específicos, ajustamos el número de tesoros
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
        adjusted = BadConsequence.newLevelNumberOfTreasures(@text, @levels, nVT, nHT)
      else
        # Tesoros específicos
        sVT = Array.new
        # Creamos un array con los tipos de los tesoros de v, para poder comparar
        # con @specific... directamente
        v.each { |t| sVT << t.getType}    
        # Toma la intersección de ambos vectores manteniendo la multiplicidad de cada elemento
        sVT = (sVT & @specificVisibleTreasures).flat_map { |n| [n]*[sVT.count(n), @specificVisibleTreasures.count(n)].min } 
        
        sHT = Array.new
        h.each { |t| sHT << t.getType}
        sHT = (sHT & @specificHiddenTreasures).flat_map { |n| [n]*[sHT.count(n), @specificHiddenTreasures.count(n)].min }
        adjusted = BadConsequence.newLevelSpecificTreasures(@text, @levels, sVT, sHT)
      end
      adjusted
    end
=end
    def to_s
      if @death==false
        if @specificVisibleTreasures.empty? and @specificHiddenTreasures.empty? 
          "\n\tTexto: #{@text} \n\tNiveles: #{@levels} \n\tTesoros visibles: #{@nVisibleTreasures}\n\tTesoros ocultos: #{@nHiddenTreasures}"
        else
          "\n\tTexto: #{@text} \n\tNiveles: #{@levels} \n\tTesoros visibles específicos: #{@specificVisibleTreasures}\n\tTesoros ocultos específicos: #{@specificHiddenTreasures} "
        end
      else
        "\n\tTexto: #{@text} \n\tMuerto"
      end

    end

    private_class_method :new
  end
  
end

