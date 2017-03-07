#encoding: utf-8
require_relative "prize.rb"

class PruebaNapakalaki
  prize = Prize.new(TreasureKind::ONEHAND, 2)
  monster = Monster.new("Nombre", 3, prize, nil)
  
  put monster.to_s
end

