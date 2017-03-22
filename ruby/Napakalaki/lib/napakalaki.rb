#encoding: utf-8
require "singleton"
#Sofía Almeida Bruno
#María Victoria Granados Pozo

class Napakalaki
  include Singleton
  
  def initialize 
    @currentMonster = Array.new
    @dealer = CardDealer.instance
    @players = Array.new
    @currentPlayer = Array.new
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
