#encoding: utf-8
require_relative "treasure_kind.rb"

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
    new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, nil,nil,false)
  end

  def self.newLevelSpecificTreasures(aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    new(aText, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)
  end
  
  def self.newDeath(aText)
    new(aText, 0, 0, 0, nil, nil, true)
  end

  
  #toString
  def to_s
    # No sé cómo haremos los constructores...
    #Dejo esto por aquí para que nos sirva de base luego, pero supongo que habrá 
    #que poner algún if-else igual que en java
   # "Texto: #{@text} \nNiveles: #{@levels} \n Tesoros visibles: #{@nVisibleTreasures} \n
   #  Tesoros ocultos: #{@nHiddenTreasures} \n Muerte: #{@death} \n Tesoros ocultos específicos:
   # #{@specificHiddenTreasures} \n Tesoros visibles específicos: #{@specificVisibleTreasures}"
    
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
