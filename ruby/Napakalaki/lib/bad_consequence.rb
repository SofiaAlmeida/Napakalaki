#encoding: utf-8

require_relative "player.rb"
require_relative "treasure.rb" #QUITAAAR

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class BadConsequence
    @@MAXTREASURES = 10

    def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, 
        someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
      @text = aText
      @levels = someLevels
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
      @specificHiddenTreasures = someSpecificVisibleTreasures
      @specificVisibleTreasures = someSpecificHiddenTreasures
      @death = death
    end

    def self.newLevelNumberOfTreasures(t, l, nVisible, nHidden)
      new(t, l, nVisible, nHidden, [], [], false)
    end

    def self.newLevelSpecificTreasures(t, l, v, h)
      new(t, l, 0, 0, v, h, false)
    end

    def self.newDeath(t, death)
      new(t, Player.getMaxLevel, @@MAXTREASURES, @@MAXTREASURES, [], [], death)
    end

    def self.getMaxTreasures
      @@MAXTREASURES
    end

    def isEmpty
      if @nHiddenTreasures == 0 and @nVisibleTreasures == 0 and
         @specificHiddenTreasures.empty? and @specificVisibleTreasures.empty?
        true
      else 
        false
      end
    end

    def getLevels
      @levels
    end

    def getNVisibleTreasures
      @nVisibleTreasures
    end

    def getNHiddenTreasures
      @nHiddenTreasures
    end

    def getSpecificHiddenTreasures
      @specificHiddenTreasures
    end

    def getSpecificVisibleTreasures
      @specificVisibleTreasures
    end


    def subtractVisibleTreasure(t)
      if @specificVisibleTreasures.empty? 
        @nVisibleTreasures -= 1
      else
        @specificVisibleTreasures.delete(t.getType)
      end
            
    end

    def subtractHiddenTreasure(t)
      if @specificHiddenTreasures.empty?
        @nHiddenTreasures -= 1
      else
        @specificHiddenTreasures.delete(t.getType)
      end
      
    end

    def adjustToFitTreasureLists(v, h)
      if @specificVisibleTreasures.empty? and @specificHiddenTreasures.empty? 
        # Si no hay tesoros específicos, ajustamos el número de tesoros
        if v.count < @nVisibleTreasures
          nVT = v.count
        else
          nVT = @nVisibleTreasures
        end
        
        if h.count < @nHiddenTreasures
          nHT = h.count
        else
          nHT = @nHiddenTreasures
        end
        
        adjusted = BadConsequence.newLevelNumberOfTreasures(@text, @levels, nVT, nHT)
      else
        # Tesoros específicos
        sVT = Array.new
        # Creamos un array con los tipos de los tesoros de v, para poder comparar
        # con @specific... directamente
        v.each { |t| sVT << t.getType}         
        sVT = sVT & @specificVisibleTreasures # Toma la intersección de ambos vectores
        
        sHT = Array.new
        h.each { |t| sHT << t.getType}
        sHT = sHT & @specificHiddenTreasures
        
        adjusted = BadConsequence.newLevelSpecificTreasures(@text, @levels, sVT, sHT)
      end
      adjusted
    end

    def to_s
      if @death==false
        if @specificVisibleTreasures.empty? and @specificHiddenTreasures.empty? 
          "\n\tTexto: #{@text} \n\tNiveles: #{@levels} \n\tTesoros visibles: #{@nVisibleTreasures}\n\tTesoros ocultos: #{@nHiddenTreasures}"
        else
          "\n\tTexto: #{@text} \n\tNiveles: #{@levels} \n\tTesoros ocultos específicos: #{@specificHiddenTreasures} \n\tTesoros visibles específicos: #{@specificVisibleTreasures}"
        end
      else
        "\n\tTexto: #{@text} \n\tMuerto"
      end

    end

    private_class_method :new
  end
  #Pruebas
=begin
badc1 = BadConsequence.newLevelNumberOfTreasures("Number", 5, 0, 3)
badc2 = BadConsequence.newLevelSpecificTreasures("Array", 4, [TreasureKind::ONEHAND, TreasureKind::ONEHAND,TreasureKind::HELMET], [TreasureKind::BOTHHANDS])
badc3 = BadConsequence.newDeath("Muertee", true)
badc4 = BadConsequence.newLevelSpecificTreasures("Array", 4, [], [])


puts "#{badc1}\n  #{badc1.isEmpty}\n"
puts "#{badc2}\n  #{badc2.isEmpty}\n"
puts "#{badc3}\n  #{badc3.isEmpty}\n"
puts "#{badc4}\n  #{badc4.isEmpty}\n"
t = Treasure.new("tesoro", 3, TreasureKind::ONEHAND)
badc2.subtractVisibleTreasure(t)
puts "#{badc2}\n"

v = [TreasureKind::ONEHAND,TreasureKind::HELMET]
h = [TreasureKind::SHOE]
ajustada = badc1.adjustToFitTreasureLists(v, h)
puts "#{ajustada}\n"

t1 = Treasure.new("tesoro", 3, TreasureKind::ONEHAND)
t2 = Treasure.new("tesoro", 2, TreasureKind::HELMET)
t3 = Treasure.new("tesoro", 1, TreasureKind::ARMOR)
v = [t1]
h = [t1, t2, t3]
ajustada = badc2.adjustToFitTreasureLists(v, h)
puts "#{ajustada}\n"
=end
end

