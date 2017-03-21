#encoding: utf-8
require "singleton"
#Sofía Almeida Bruno
#María Victoria Granados Pozo

class Dice
  include Singleton
  
  def initialize
  end
  
  def nextNumber
    rand(1..6)
  end
end
