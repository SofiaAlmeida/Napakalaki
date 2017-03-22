#encoding: utf-8
require "singleton"
#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class Dice
    include Singleton

    def nextNumber
      rand(1..6)
    end
  end
end