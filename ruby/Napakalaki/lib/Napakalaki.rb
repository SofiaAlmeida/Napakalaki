#encoding: utf-8

require "singleton"
require_relative "card_dealer"
require_relative "player"
require_relative "combat_result"
require_relative "cultist_player"

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class Napakalaki
    include Singleton

    def initialize 
      @dealer = CardDealer.instance
      @players = Array.new
      @currentPlayer = nil
      @currentMonster = nil
    end

    def developCombat
      combatResult = @currentPlayer.combat(@currentMonster)
      @dealer.giveMonsterBack(@currentMonster)
      if combatResult == CombatResult::LOSEANDCONVERT
        cultist = @dealer.nextCultist
        cultistPlayer = CultistPlayer.new(@currentPlayer, cultist)
        # Reemplazamos al jugador actual por el sectario correspondiente
        # (currentPlayer, players, enemy)
        @players.each {|p| 
          if p.getEnemy == @currentPlayer
            p.setEnemy(cultistPlayer)
          end
        }
        @players.insert(@players.index(@currentPlayer), cultistPlayer)
      end
      combatResult
    end

    def discardVisibleTreasures(treasures)
      treasures.each { |treasure| 
        @currentPlayer.discardVisibleTreasure(treasure)
        @dealer.giveTreasureBack(treasure)
      }
      
    end

    def discardHiddenTreasures(treasures)
      treasures.each { |treasure| 
        @currentPlayer.discardHiddenTreasure(treasure)
        @dealer.giveTreasureBack(treasure)
      }
      
    end

    def makeTreasuresVisible(treasures)
      treasures.each { |t|
        @currentPlayer.makeTreasureVisible(t)
      }
      
    end

    def initGame(players)
      initPlayers(players)
      setEnemies
      @dealer.initCards
      nextTurn
      
    end

    def getCurrentPlayer
      @currentPlayer
    end

    def getCurrentMonster
      @currentMonster
    end

    def nextTurn
      stateOK = nextTurnAllowed
      if stateOK
        @currentMonster = @dealer.nextMonster
        @currentPlayer = nextPlayer
        dead = @currentPlayer.isDead
        if dead
          @currentPlayer.initTreasures
        end
      end
      stateOK
    end

    def endOfGame(result)
      if result == CombatResult::WINGAME
        true
      else
        false
      end
    end
    
    protected
    def initPlayers (names)
      names.each { |player| @players << Player.new(player)}
      
    end
    
    def nextPlayer
      if @currentPlayer.nil?
        posicion = rand(@players.count)
      else
        posicion = @players.index(@currentPlayer)
        if posicion == (@players.count - 1)
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
          posicion = rand(@players.count)
        end while posicion == @players.index(player)
        player.setEnemy(@players.fetch(posicion))
       }
    end
      
  end
end