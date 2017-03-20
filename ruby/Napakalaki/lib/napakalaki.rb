#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

include Singleton

class Napakalaki
  def initialize 
    @@instance = nil
    @currentMonster = nil
    @dealer = nil
    @players = nil
    @currentPlayer = nil
  end
  
  def self.getInstance
    @@instance
  end
  
  def developCombat
    
  end
  
  def discardVisibleTreasures(treasures)
    
  end
  
  def discardHiddenTreasures(treasures)
    
  end
  
  def makeTreasuresVisible(treasures)
    
  end
  
  def initGame(players)
    
  end
  
  def getCurrentPlayer
    @currentPlayer
  end
  
  def getCurrentMonster
    @currentMonster
  end
  
  def nextTurn
    
  end
  
  def endOfGame(result)
    
  end
  
end
