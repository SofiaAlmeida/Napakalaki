#encoding: utf-8
require_relative "prize.rb"
require_relative "treasure_kind.rb"
require_relative "bad_consequence"
require_relative "monster.rb"

#Sofía Almeida Bruno
#María Victoria Granados Pozo

class PruebaNapakalaki
=begin 
  Pruebas previas
  prize = Prize.new(TreasureKind::ONEHAND, 2)
  bc = BadConsequence.newLevelNumberOfTreasures("Muerte", 1, 2, 3)
  monster = Monster.new("Nombre", 3, prize, bc)
  
  puts bc
  puts bc
  puts prize.to_s
  puts monster.to_s
=end
  
  def self.combatLevelGt10(monstruos)
  result = Array.new
  monstruos.each { |monstruo| if (monstruo.getCombatLevel > 10)
      result << monstruo
    end
  }
  result
end

def self.lossLevel(monstruos) 
  result = Array.new
  monstruos.each { |monstruo| 
    if (monstruo.getBadConsequence.getNHiddenTreasures == 0 and 
        monstruo.getBadConsequence.getNVisibleTreasures == 0 and
        monstruo.getBadConsequence.getSpecificHiddenTreasures.empty? and
        monstruo.getBadConsequence.getSpecificVisibleTreasures.empty?) 
          
      result << monstruo
    end
  }
  result
end
 
def self.levelGt1(monstruos)
  result = Array.new
  monstruos.each { |monstruo| if (monstruo.getLevelsGained > 1)
      result << monstruo
    end
  }
  result
end

def self.lossTreasure(monstruos, t)
  result = Array.new
  monstruos.each { |monstruo|
    if (monstruo.getBadConsequence.getSpecificHiddenTreasures.include? t)
      result << monstruo
    end
  }
  result
end
  
  #-----------------------------------------------------------------------------
  #                          MONSTRUOS
  #-----------------------------------------------------------------------------
  @@monsters = Array.new
    
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta", 
  0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
  @@monsters<< Monster.new("Byakhess de bonanza", 8, badConsequence, prize)
  
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible", 
  0, [TreasureKind::HELMET], []) 
  @@monsters<< Monster.new("Tenochtitlan", 2, badConsequence, prize)
    
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible", 
  0, [TreasureKind::SHOES], [])
  @@monsters<< Monster.new("El sopor de Dunwich", 2, badConsequence, prize)
  
  prize = Prize.new(4,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y 
  te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
  @@monsters<< Monster.new("Demonios de Magaluf", 2, badConsequence, prize)
  
  prize = Prize.new(3,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles.", 0, 5, 0)
  @@monsters<< Monster.new("El gorrón en el umbral", 13, badConsequence, prize)
  
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible.", 0, [TreasureKind::ARMOR], [])
  @@monsters<< Monster.new("H.P. Munchcraft", 6, badConsequence, prize)
  
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible", 
  0, [TreasureKind::ARMOR], [])
  @@monsters<< Monster.new("Necrófago", 13, badConsequence, prize)
  
  prize = Prize.new(3,2)
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles", 
  5, 3, 0)
  @@monsters<< Monster.new("El rey de rosado", 11, badConsequence, prize)
    
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 pulmones", 2, 0, 0)
  @@monsters << Monster.new("Flecher", 2, badConsequence, prize)
  
  
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newDeath("Estos monstruos resultan bastantes superficiales y te aburren mortalmente. Estás muerto.")
  @@monsters << Monster.new("Los hondos", 8, badConsequence, prize)
  
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2)
  @@monsters << Monster.new("Semillas Cthulhu", 4, badConsequence, prize)
  
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible.", 0, [TreasureKind::ONEHAND], [])
  @@monsters << Monster.new("Dameargo", 1, badConsequence, prize)
  
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0)
  @@monsters << Monster.new("Pollipólipo volante", 3, badConsequence, prize)
  
  prize = Prize.new(3,1)
  badConsequence = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estás muerto.")
  @@monsters << Monster.new("Yskhtihyssg-Goth", 14, badConsequence, prize)
  
  prize = Prize.new(3,1)
  badConsequence = BadConsequence.newDeath("La familia te atrapa. Estás muerto.")
  @@monsters << Monster.new("Familia feliz", 1, badConsequence, prize)
  
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2, [TreasureKind::BOTHHANDS], [])
  @@monsters << Monster.new("Roboggoth", 8, badConsequence, prize)
  
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible.", 0, [TreasureKind::HELMET], [])
  @@monsters << Monster.new("El espía sordo", 5, badConsequence, prize)
  
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0)
  @@monsters << Monster.new("Tongue", 19, badConsequence, prize)
  
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures("Te faltan menos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 
    3, [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], [])
  @@monsters << Monster.new("Bicéfalo", 21, badConsequence, prize)
  
  #-----------------------------------------------------------------------------
  
  m1 = Array.new
  m1 = combatLevelGt10(@@monsters)
  puts m1
  
  m1 = lossLevel(@@monsters)
  puts m1
  
  m1 = levelGt1(@@monsters)
  puts m1

  m1 = lossTreasure(@@monsters, TreasureKind::ONEHAND)
  puts m1
  
end

