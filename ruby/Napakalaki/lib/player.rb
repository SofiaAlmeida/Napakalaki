#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

class Player
  @@MAXLEVEL = 10
    
  def initialize(name)
    @name = name
    @level = 1
    @dead = true
    @canISteal = true
    @pendingBadConsequence = nil
    @hiddenTreasueres = Array.new
    @visibleTreasures = Array.new
    @enemy = nil
  end
  
  def getName
    @name
  end
  
  def isDead
    @dead
  end
  
  def getHiddenTreasures
    
  end
  
  def getVisibleTreasures
    
  end
  
  def combat(m)
    
  end
  
  def makeTreasureVisible(t)
    
  end
  
  def discardVisibleTreasure(t)
    
  end
  
  def discardHiddenTreasure(t)
    
  end
  
  # Devuelve true cuando el jugador no tiene ningún mal rollo que cumplir y no 
  # tiene más de 4 tesoros, false en caso contrario
  def validState
    state = false 
    if @pendingBadConsequence.isEmpty and @hiddenTreasures.length <= 4
      state = true           
    end
    state
  end
  
  def initTreasures
    
  end
  
  def getLevels
    @level
  end
  
  def stealTreasure
    
  end
  
  def setEnemy(enemy)
    @enemy = enemy
  end
  
  # Devuelve si el jugador ha robado un tesoro a su enemigo (true)
  def canISteal
    @canISteal
  end
  
  def discardAllTreasures
    
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
  
  def incrementLevels(l)
    if l > 0
      if @level + l > @@MAXLEVEL
        @level = @@MAXLEVEL
      else
        @level += l
      end
    end
    
  end
  
  def decrementLevels(l)
    if l > 0
      if @level - l < 1
        @level = 1
      else
        @level -= l
      end
    end   
    
  end
  
  def setPendingBadConsequence(b)
    @pendingBadConsequence = b
    
  end
  
  def applyPrize(m)
    
  end
  
  def applyBadConsequence(m)
    
  end
  
  def canMakeTreasureVisible(t)
    
  end
  
  def howManyVisibleTreasures(tKind)
    @visibleTreasures.count{|t| t.getType == tKind}
  end
  
  # Cambia el estado del jugador a muerto
  def dieIfNoTreasures
    if hiddenTreasures.empty? and visibleTreasures.empty?
      @dead = true
    end
    
  end
    
  def giveMeATreasure
    
  end
  
  # True si el jugador tiene tesoros para ser robados
  def canYouGiveMeATreasure
    aux = false
    if (@hiddenTreasures.length > 0)
      aux = true
    end
    aux
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