#encoding: utf-8
#
#Sofía Almeida Bruno
#María Victoria Granados Pozo

class Player
  MAXLEVEL = 10
  def initialize(name, level, dead, canISteal, pendingbc, ht, vt, enemy)
    @name = name
    @level = level
    @dead = dead
    @canISteal = canISteal
    @pendingBadConsequence = pendingbc
    @hiddenTreasueres = ht
    @visibleTreasures = vt
    @enemy = enemy
    
  end
  
  def self.Player(name)
    new(name, 0, true, true, nil, nil, nil, nil)
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
  
  def validState
    state = false 
    if (@pendingBadConsequence.isEmpty and @hiddenTreasueres.length <= 4)
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
  
  #Si el jugador ha robado un tesoro a su enemigo (true)
  def CanISteal
    @canISteal
  end
  
  def discardAllTreasures
    
  end
  
  private 
  def bringToLife
     @dead = false
     
  end
  
  def getCombatLevel
    combatLevel = @level
    @visibleTreasures.each { |treasure|  combatLevel += treasure.getBonus}
    combatLevel
  end
  
  def incrementLevels(l)
    @level += l
    
  end
  
  def decrementLevels(l)
    @level -= l
    
  end
  
  def setPendingBadConsequence(bc)
    @pendingBadConsequence = bc
    
  end
  
  def applyPrize(m)
    
  end
  
  def applyBadConsequence(m)
    
  end
  
  def canMakeTreasureVisible(t)
    
  end
  
  def howManyVisibleTreasures(tKind)
    @visibleTreasures.count(tKind)
  end
  
  #Llamar cuando se pierden todos los tesoros
  def dieIfNoTreasures
    @dead = true
  end
    
  def giveMeATreasure
    
  end
  
  #True si el jugador tiene tesoros para ser robados
  def canYouGiveMeATreasure
    aux = false
    if (@hiddenTreasures.length > 0)
      aux = true
    end
    aux
  end
  
  #Llamar cuando el jugador roba un tesoro
  def haveStolen
    @canISteal = false
    
  end
  
end
