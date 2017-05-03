#encoding: utf-8

require_relative "bad_consequence"

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class SpecificBadConsequence < BadConsequence
    def initialize (t, l, v, h)
      super(t, l)
      @specificVisibleTreasures = v
      @specificHiddenTreasures = h
    end
    
    def isEmpty
      if @specificHiddenTreasures.empty? and @specificVisibleTreasures.empty?
        true
      else 
        false
      end
    end
    
    def getSpecificHiddenTreasures
      @specificHiddenTreasures
    end

    def getSpecificVisibleTreasures
      @specificVisibleTreasures
    end
    
    def substractVisibleTreasure(t)
      @specificVisibleTreasures.delete(t.getType)
            
    end

    def substractHiddenTreasure(t)
      @specificHiddenTreasures.delete(t.getType)
      
    end
    
    def adjustToFitTreasureLists(v, h)
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
      SpecificBadConsequence.new(@text, @levels, sVT, sHT)
    end
    def to_s
      super + "\n\tTesoros visibles específicos: #{@specificVisibleTreasures}\n\tTesoros ocultos específicos: #{@specificHiddenTreasures} "
    end
    
  end
end
