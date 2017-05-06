#encoding: utf-8

require_relative "bad_consequence"

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class DeathBadConsequence < NumericBadConsequence   
    def initialize (t)
      super(t, Player.getMaxLevel, BadConsequence.getMaxTreasures, BadConsequence.getMaxTreasures)
      @death = true
    end
    
    def to_s
      "\n\tTexto: #{getText} \n\tMuerto"
    end
  end
end
