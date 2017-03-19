#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

class Monster
=begin
  attr_reader :name
  attr_reader :combatLevel
  attr_reader :prize
  attr_reader :badConsequence
=end
  def initialize(n, l, b, p)
    @name = n
    @combatLevel = l
    @prize = p
    @badConsequence = b
  end
  
  def getName
    @name
  end
  
  def getCombatLevel
    @combatLevel
  end
  
  def getBadConsequence
    @badConsequence
  end
  
  def getLevelsGained
    @prize.getLevels
  end
  
  def getTreasuresGained
    @prize.getTreasures
  end
  
  
  
  #toString

  def to_s
    "Nombre: #{@name} \nNivel de combate: #{@combatLevel} \nPremio: #{@prize} \nMal rollo: #{@badConsequence}"
  end

  
end

=begin
prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta", 
  0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
monster = Monster.new("Byakhess de bonanza", 8, badConsequence, prize)

puts monster
=end
