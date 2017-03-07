#encoding: utf-8

class Prize
  def initialize(treasures, level)
    @treasures = treasures
    @level = level
  end
  
  #Forma 1 consultores
  attr_reader :treasures
  attr_reader :level
  
  #Forma 2 consultores
  def treasures
    @treasures
  end
  
  def level
    @level
  end
  # Una vez hayas visto las dos anteriores elige la que te parezca conveniente
  
  #toString
  def to_s
    "Tesoros ganados: #{@treasures} \n Niveles ganados: #{@level}"
  end

  
end
