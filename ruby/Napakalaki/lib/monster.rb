#encoding: utf-8

class Monster
  attr_accessor name
  attr_accessor combatLevel
  attr_accessor prize
  attr_accessor badConsequence
  
  def initialize(name, combatLevel, prize, badConsequence)
    @name = name
    @combatLevel = combatLevel
    @prize = prize
    @badConsequence = badConsequence
  end
  
  #toString
  def to_s
    "Nombre: #{@name} \n Nivel de combate: #{@combatLevel} \n
     Premio: #{@Prize} \n Mal rollo: #{@badConsequence}"
  end
end
