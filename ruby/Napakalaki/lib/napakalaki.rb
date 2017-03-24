#encoding: utf-8
require "singleton"
#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class Napakalaki
    include Singleton

    def initialize 
      @currentMonster = Player.new
      @dealer = CardDealer.instance
      @players = Array.new
      @currentPlayer = Player.new
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
      if result == CombatResult::WINGAME
        true
      else
        false
      end
    end
    
    private
    def initPlayers (names)
      names.each { |player| @players << Player.new(player)}
      
    end
    
    def nextPlayer
      if @currentPlayer.nil?
        posicion = rand (@players.count)
      else
        posicion = @players.index(@currentPlayer)
        if (posicion == (@players.count -1))
          posicion = 0
        else
          posicion += 1
        end
      end
      @currentPlayer = @players.fetch(posicion)
    end
    
    def nextTurnAllowed
      if @currentPlayer.nil?
        true
      else
        @currentPlayer.validState
      end
    end
    
    def setEnemies
      @players.each { |player| begin
          posicion = rand (@players.count)
        end while posicion == @players.index(player)
        player.setEnemy (@players.fetch(posicion))
       }
    end
      
  end
end