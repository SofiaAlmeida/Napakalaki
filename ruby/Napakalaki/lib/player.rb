#encoding: utf-8

require_relative "card_dealer.rb"
require_relative "dice.rb"

require_relative "monster.rb" #QUITAAAR
require_relative "prize.rb" #QUITAR
require_relative "bad_consequence.rb"  #QUITAR

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class Player
    @@MAXLEVEL = 10

    def initialize(name)
      @name = name
      @level = 1
      @dead = true
      @canISteal = true
      @pendingBadConsequence = nil
      @hiddenTreasures = Array.new
      @visibleTreasures = Array.new
      @enemy = nil
    end

    def self.getMaxLevel
      @@MAXLEVEL
    end

    def getName
      @name
    end

    def isDead
      @dead
    end

    def getHiddenTreasures
      @hiddenTreasures
    end

    def getVisibleTreasures
      @visibleTreasures
    end

    #Simulación del combate con el monstruo
    def combat(m)
      myLevel = getCombatLevel
      monsterLevel = m.getCombatLevel
      if !@canISteal
        dice = Dice.instance
        number = dice.nextNumber
        
        if number < 3
          enemyLevel = @enemy.getCombatLevel
          monsterLevel += enemyLevel
        end
        
        if myLevel > monsterLevel
          applyPrize (m)
          if (@level >= @@MAXLEVEL)
            CombatResult::WINGAME
          else
            CombatResult::WIN
          end
        else
          applyBadConsequence (m)
          puts "PIERDE"
          CombatResult::LOSE
        end
      end
    end

    #Hace visible el tesoro del parámetro
    def makeTreasureVisible(t)
      canI = canMakeTreasureVisible(t) #self necesario?
      if canI
        @visibleTreasures << t
        @hiddenTreasures.remove(t)
      end
      
    end

    #Descarta un tesoro visible para completar el mal rollo
    def discardVisibleTreasure(t)
      @visibleTreasures.remove(t)
      if (@pendingBadConsequence != nil) and !@pendingBadConsequence.empty?
        @pendingBadConsequence.substractVisibleTreasure(t)
      end
      @currentPlayer.dieIfNoTreasures
      
    end
    
    #Descarta un tesoro oculto para completar el mal rollo
    def discardHiddenTreasure(t)
      @visibleTreasures.remove(t)
      if (@pendingBadConsequence != nil) and !@pendingBadConsequence.empty?
        @pendingBadConsequence.substractHiddenTreasure(t)
      end
      @currentPlayer.dieIfNoTreasures
    end

    # Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y no 
    # tiene más de 4 tesoros, false en caso contrario
    def validState
      if @pendingBadConsequence.isEmpty and @hiddenTreasures.length <= 4
        true
      else
        false
      end
    end

    #Da tesoros iniciales al jugador
    def initTreasures
      dealer = CardDealer.instance
      dice = Dice.instance
      bringToLife
      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure
      number = dice.nextNumber
      
      if number > 1
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
      end
      
      if number == 6
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
      end
    end
   

    def getLevels
      @level
    end
    
    #REVIEW ver si funciona el ret
    #Roba un tesoro
    #Devuelve dicho tesoro, en caso de no robar un tesoro se devolverá nil
    def stealTreasure
      canI = canISteal
      if canI
        canYou = @enemy.canYouGiveMeATreasure
        if canYou
          treasure = enemy.giveMeATreasure
          hiddenTreasures.add(treasure)
          haveStolen
          
          treasure
        end
      else
        nil
      end
    end
    

    #Asigna un enemigo al jugador
    def setEnemy(enemy)
      @enemy = enemy
    end

    # Devuelve si el jugador ha robado un tesoro a su enemigo (true)
    def canISteal
      @canISteal
    end

    #Descarta todos los tesoros del jugador
    def discardAllTreasures
      @visibleTreasures.each {|treasure| discardVisibleTreasure(treasure)}
      @hiddenTreasures.each {|treasure| discardHiddenTreasure(treasure)}
      
    end

    #private 
    def bringToLife
       @dead = false

    end

    # Nivel de combate = nivel + bonus de tesoros
    def getCombatLevel
      combatLevel = @level
      @visibleTreasures.each { |treasure|  combatLevel += treasure.getBonus}
      combatLevel
    end

    #Aumenta el número de niveles pasados como parámetro
    def incrementLevels(l)
      if l > 0
        if @level + l > @@MAXLEVEL
          @level = @@MAXLEVEL
        else
          @level += l
        end
      end

    end

    #Decrementa el número de niveles pasados como parámetro
    def decrementLevels(l)
      if l > 0
        if @level - l < 1
          @level = 1
        else
          @level -= l
        end
      end   

    end
    
    #Asigna el mal rollo pendiente
    def setPendingBadConsequence(b)
      @pendingBadConsequence = b

    end

    #Aplica el premio del monstruo
    def applyPrize(m)
      nLevels = m.getLevelsGained
      self.incrementLevels (nLevels)
      nTreasures = m.getTreasuresGained
      
      if nTreasures > 0
        dealer = CardDealer.instance
        nTreasures.times do
          treasure = dealer.nextTreasure
          @hiddenTreasures << treasure
        end
      end
      
    end

    #Aplica el mal rollo del monstruo
    def applyBadConsequence(m)
      badConsequence = m.getBadConsequence
      nLevels = badConsequence.getLevels
      self.decrementLevels (nLevels)
      pendingBad = badConsequence.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
      self.setPendingBadConsequence(pendingBad)
      
    end

    def canMakeTreasureVisible(t)
      if t.getType == TreasureKind::ONEHAND
        if howManyVisibleTreasures(TreasureKind::ONEHAND) < 2 or howManyVisibleTreasures(TreasureKind::BOTHHANDS) == 0
          true
        end
      elsif t.getType == TreasureKind::BOTHHANDS
        if howManyVisibleTreasures(TreasureKind::ONEHAND) == 0 or howManyVisibleTreasures(TreasureKind::BOTHHANDS) == 0
          true
        end
      elsif howManyVisibleTreasures(t.getType) == 0
        true
      end
      false
    end

    def howManyVisibleTreasures(tKind)
      @visibleTreasures.count{|t| t.getType == tKind}
    end

    # Cambia el estado del jugador a muerto sino tiene ningún tesoro
    def dieIfNoTreasures
      if @hiddenTreasures.empty? and @visibleTreasures.empty?
        @dead = true
      end

    end

    def giveMeATreasure
      posicion = rand (@hiddenTreasures.length)
      @hiddenTreasures.fetch(posicion)
    end

    # True si el jugador tiene tesoros para ser robados
    def canYouGiveMeATreasure
      if @hiddenTreasures.length == 0
        false
      end
        true
    end

    # Llamar cuando el jugador roba un tesoro
    def haveStolen
      @canISteal = false

    end

    def to_s
      "\nNombre: #{@name} \nLevel: #{@level} \nMuerte: #{@dead}\nPuede robar: #{@canISteal}\n" +
      "Mal rollo pendiente: #{@pendingBadConsequence} \nTesoros ocultos: #{@hiddenTreasures}\n" +
      "Tesoros visibles: #{@visibleTreasures} \nEnemigo: #{@enemy.getName}" 
    end

  end

  #PRUEBAA
mazo = CardDealer.instance
mazo.initCards
jugador = Player.new("jug1")
enemigo = Player.new("ene")
badc1 = BadConsequence.newLevelNumberOfTreasures("Number", 5, 0, 3)
badc2 = BadConsequence.newLevelSpecificTreasures("Array", 3, [TreasureKind::ONEHAND,TreasureKind::HELMET], [TreasureKind::BOTHHANDS])
p = Prize.new(3, 4)

monpremio = Monster.new("Miguee", 8, badc1, p)
monbc = Monster.new("asd", 20, badc2, p)
jugador.initTreasures
jugador.setEnemy(enemigo)
puts "Jugador Antes:\n #{jugador}"
jugador.applyPrize (monpremio)
puts "Jugador Premio:\n #{jugador}"
jugador.combat(monbc)
puts "Jugador BC:\n #{jugador}"
 

end