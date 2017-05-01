#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class Cultist
    def initialize(name, gainedLevels)
      @name = name
      @gainedLevels = gainedLevels
    end
    
    def getGainedLevels
      @gainedLevels
    end  
  end
end
