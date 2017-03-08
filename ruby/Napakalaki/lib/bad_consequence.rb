#encoding: utf-8

class BadConsequence
#  def initialize
 # end
 
  attr_reader :text
  attr_reader :levels
  attr_reader :nVisibleTreasures
  attr_reader :nHiddenTreasures
  attr_reader :death
  attr_reader :specificHiddenTreasures
  attr_reader :specificVisibleTreasures
  
  #toString
  def to_s
    # No sé cómo haremos los constructores...
    #Dejo esto por aquí para que nos sirva de base luego, pero supongo que habrá 
    #que poner algún if-else igual que en java
    "Texto: #{@text} \n Niveles: #{@levels} \n Tesoros visibles: #{@nVisibleTreasures} \n
      Tesoros ocultos: #{@nHiddenTreasures} \n Muerte: #{@death} \n Tesoros ocultos específicos:
      #{@specificHiddenTreasures} \n Tesoros visibles específicos: #{@specificVisibleTreasures}"
  end
end
