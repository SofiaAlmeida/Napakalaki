#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

class Treasure
  def initialize(n, bonus, t)
    @name = n
    @bonus = bonus
    @type = t
  end
  
  def getName
    @name
  end
  
  def getBonus
    @bonus
  end
  
  def getType
    @type
  end
  
  def to_s
    "Nombre: #{@name} \nBonus: #{@bonus} \nTipo: #{@type}"
  end
  
end
