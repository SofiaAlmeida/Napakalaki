#encoding: utf-8

class Monster
  attr_reader :name
  attr_reader :combatLevel
  attr_reader :prize
  attr_reader :badConsequence
  
  def initialize(name, combatLevel, prize, badConsequence)
    @name = name
    @combatLevel = combatLevel
    @prize = prize
    @badConsequence = badConsequence
  end
  
  #toString
  def to_s
    "Nombre: #{@name} \nNivel de combate: #{@combatLevel} \nPremio: #{@prize} \nMal rollo: #{@badConsequence}"
  end
end