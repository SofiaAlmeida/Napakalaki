#encoding: utf-8

class BadConsequence
  attr_reader :text
  attr_reader :levels
  attr_reader :nVisibleTreasures
  attr_reader :nHiddenTreasures
  attr_reader :death
  attr_reader :specificHiddenTreasures
  attr_reader :specificVisibleTreasures
  
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
 
  def BadConsequence.newLevelNumberOfTreasures(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @death = false
    @specificHiddenTreasures = Array.new
    @specificVisibleTreasures = Array.new
  end

  def BadConsequence.newLevelSpecificTreasures(aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = 0
    @nHiddenTreasures = 0
    @death = false
    @specificHiddenTreasures = someSpecificVisibleTreasures
    @specificVisibleTreasures = someSpecificHiddenTreasures
  end
  
  def BadConsequence.newDeath(aText)
    @text = aText
    @levels = 0
    @nVisibleTreasures = 0
    @nHiddenTreasures = 0
    @death = true
    @specificHiddenTreasures = Array.new
    @specificVisibleTreasures = Array.new
  end

  
  #toString
  def to_s
    # No sé cómo haremos los constructores...
    #Dejo esto por aquí para que nos sirva de base luego, pero supongo que habrá 
    #que poner algún if-else igual que en java
    "Texto: #{@text} \nNiveles: #{@levels} \n Tesoros visibles: #{@nVisibleTreasures} \n
      Tesoros ocultos: #{@nHiddenTreasures} \n Muerte: #{@death} \n Tesoros ocultos específicos:
      #{@specificHiddenTreasures} \n Tesoros visibles específicos: #{@specificVisibleTreasures}"
  end
  
  private_class_method :new # Comprobar posición
end
