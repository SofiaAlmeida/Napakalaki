#encoding: utf-8

class BadConsequence
  attr_reader :text
  attr_reader :levels
  attr_reader :nVisibleTreasures
  attr_reader :nHiddenTreasures
  attr_reader :death
  attr_reader :specificHiddenTreasures
  attr_reader :specificVisibleTreasures
  
   @specificHiddenTreasures = Array.new
   @specificVisibleTreasures = Array.new
  
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

  
  #toString
  def to_s
    if @death==false
      if @specificVisibleTreasures.nil? and @specificHiddenTreasures.nil? #La linea de abajo hay que ponerla así sino hace un salto de linea mas
        "\n\tTexto: #{@text} \n\tNiveles: #{@levels} \n\tTesoros visibles: #{@nVisibleTreasures}\n\tTesoros ocultos: #{@nHiddenTreasures}"
      else
        "\n\tTexto: #{@text} \n\tNiveles: #{@levels} \n\tTesoros ocultos específicos:
        #{@specificHiddenTreasures} \n\tTesoros visibles específicos: #{@specificVisibleTreasures}"
      end
    else
      "\n\tTexto: #{@text} \n\tMuerto"
    end
    
  end
  
  private_class_method :new # Comprobar posición
end
