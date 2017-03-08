#encoding: utf-8
require_relative "prize.rb"
require_relative "treasure_kind.rb"
require_relative "bad_consequence"
require_relative "monster.rb"

class PruebaNapakalaki
  prize = Prize.new(TreasureKind::ONEHAND, 2)
  bc = BadConsequence.newLevelSpecificTreasures("Muerte", 1, 2, 3)
  monster = Monster.new("Nombre", 3, prize, nil)
  
  puts bc.to_s
  #puts prize.to_s
  #puts monster.to_s
end

