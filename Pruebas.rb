#-----------------------------------------------------------------------------
#                            PRUEBAS FUNCIONES
#-----------------------------------------------------------------------------
=begin
m1 = Array.new
m1 = combatLevelGt10(@@monsters)
puts m1

m1 = lossLevel(@@monsters)
puts m1

m1 = levelGt1(@@monsters)
puts m1

m1 = lossTreasure(@@monsters, TreasureKind::ONEHAND)
puts m1
=end

=begin
#-----------------------------------------------------------------------------
#                          PRUEBAS NAPAKALAKI
#-----------------------------------------------------------------------------
n = Napakalaki.instance
puts (n.getCurrentPlayer.nil? ? "si" : "no")

#-----------------------------------------------------------------------------
#                          PRUEBAS DICE
#-----------------------------------------------------------------------------
d = Dice.instance
puts d.nextNumber

#-----------------------------------------------------------------------------
#                          PRUEBAS TREASURE
#-----------------------------------------------------------------------------
t = Treasure.new("Prueba Tesoro", 2, TreasureKind::ARMOR)
puts "Tesoro: #{t.getName}, nivel: #{t.getBonus}, tipo: #{t.getType}"

#-----------------------------------------------------------------------------
#                          PRUEBAS PLAYER
#-----------------------------------------------------------------------------
p = Player.new("Jugador")
puts "Jugador: "
puts "Antes: #{p.isDead}"
p.bringToLife
puts "Bring to life: #{p.isDead}"

puts "Get combat level: #{p.getCombatLevel}"
puts "IncrementLevel #{p.incrementLevels(4)}"
puts "IncrementLevel #{p.incrementLevels(6)}"
puts "DecrementLevel #{p.decrementLevels(3)}"
puts "DecrementLevel #{p.decrementLevels(11)}"
puts "ValidState #{p.validState}"

#-----------------------------------------------------------------------------
#                          PRUEBAS MONSTER
#-----------------------------------------------------------------------------
prize = Prize.new(2,1)
badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta",
0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
monster = Monster.new("Byakhess de bonanza", 8, badConsequence, prize)

puts monster
=end

#-----------------------------------------------------------------------------
#                          PRUEBAS BAD CONSEQUENCE
#-----------------------------------------------------------------------------
=begin
badc1 = BadConsequence.newLevelNumberOfTreasures("Number", 5, 0, 3)
badc2 = BadConsequence.newLevelSpecificTreasures("Array", 4, [TreasureKind::ONEHAND, TreasureKind::ONEHAND,TreasureKind::HELMET], [TreasureKind::BOTHHANDS])
badc3 = BadConsequence.newDeath("Muertee", true)
badc4 = BadConsequence.newLevelSpecificTreasures("Array", 4, [], [])


puts "#{badc1}\n  #{badc1.isEmpty}\n"
puts "#{badc2}\n  #{badc2.isEmpty}\n"
puts "#{badc3}\n  #{badc3.isEmpty}\n"
puts "#{badc4}\n  #{badc4.isEmpty}\n"
t = Treasure.new("tesoro", 3, TreasureKind::ONEHAND)
badc2.subtractVisibleTreasure(t)
puts "#{badc2}\n"

v = [TreasureKind::ONEHAND,TreasureKind::HELMET]
h = [TreasureKind::SHOE]
ajustada = badc1.adjustToFitTreasureLists(v, h)
puts "#{ajustada}\n"

t1 = Treasure.new("tesoro", 3, TreasureKind::ONEHAND)
t2 = Treasure.new("tesoro", 2, TreasureKind::HELMET)
t3 = Treasure.new("tesoro", 1, TreasureKind::ARMOR)
v = [t1]
h = [t1, t2, t3]
ajustada = badc2.adjustToFitTreasureLists(v, h)
puts "#{ajustada}\n"
=end
