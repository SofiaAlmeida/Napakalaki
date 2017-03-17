#encoding: utf-8

#Sofía Almeida Bruno
#María Victoria Granados Pozo

class Prize
  def initialize(treasures, level)
    @treasures = treasures
    @level = level
  end
  
  #Forma 1 consultores
  #attr_reader :treasures
  #attr_reader :level
  
  #Forma 2 consultores
  def getTreasures
    @treasures
  end
  
  def getLevels
    @level
  end
  
  #toString

  def to_s
    "\n\tTesoros ganados: #{@treasures} \n\tNiveles ganados: #{@level}"
  end


  
end
