#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class Prize
    def initialize(t, l)
      @treasures = t
      @level = l
    end

    def getTreasures
      @treasures
    end

    def getLevels
      @level
    end

    def to_s
      "\n\tTesoros ganados: #{@treasures} \n\tNiveles ganados: #{@level}"
    end

  end
end