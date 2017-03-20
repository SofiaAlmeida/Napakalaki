#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

include Singleton

class Dice
  def initialize
    @@instance = nil
  end
  
  def self.getInstance
    @@instance
  end
  
  def nextNumber
    rand(1..6)
  end
end
