#encoding: utf-8

class BadConsequence
#  def initialize
 # end
 
  attr_accessor :text
  attr_accessor :levels
  attr_accessor :nVisibleTreasures
  attr_accessor :nHiddenTreasures
  attr_accessor :death
  attr_accessor :specificHiddenTreasures
  attr_accessor :specificVisibleTreasures
  
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
