#encoding: utf-8

require "singleton"
require_relative "prize"
require_relative "bad_consequence"
require_relative "treasure"
require_relative "treasure_kind"
require_relative "monster"
require_relative "cultist"

#Sofía Almeida Bruno
#María Victoria Granados Pozo

module NapakalakiGame
  class CardDealer
    include Singleton

    def initialize
      @unusedMonsters = Array.new
      @usedMonsters = Array.new
      @unusedTreasures = Array.new 
      @usedTreasures = Array.new
      @unusedCultists = Array.new 
      @usedCultists = Array.new
    end

    def nextTreasure
      if @unusedTreasures.empty?
        @unusedTreasures = @usedTreasures
        @usedTreasures = Array.new
        shuffleTreasures
      end
      
      treasure = @unusedTreasures.at(0)
      giveTreasureBack(treasure)
      @unusedTreasures.delete(treasure)
    end

    def nextMonster
      if @unusedMonsters.empty?
        @unusedMonsters = @usedMonsters
        @usedMonsters = Array.new
        shuffleTreasures
      end
      
      monster = @unusedMonsters.at(0)
      giveMonsterBack(monster)
      @unusedMonsters.delete(monster)
    end
    
    def nextCultist
      if @unusedCultists.empty?
        @unusedMonsters = @usedCulstis
        shuffleCultists
      end
      cultist = @unusedCultists.at(0)
      giveCultistBack(cultist)
      @unusedMonsters.delete(cultist)
    end

    def giveTreasureBack(t)
      @usedTreasures << t

    end

    def giveMonsterBack(m)
      @usedMonsters << m

    end
    
    def giveCultistBack(c)
      @usedCultists << c

    end

    def initCards
      initTreasureCardDeck
      shuffleTreasures
      initMonsterCardDeck
      shuffleMonster
      initCultistCardDeck
      shuffleCultists
      
    end

    protected
    def initTreasureCardDeck

      @unusedTreasures << Treasure.new("¡Sí mi amo!", 4, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Botas de investigación", 3, TreasureKind::SHOE)
      @unusedTreasures << Treasure.new("Capucha de Cthulhu", 3, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("A prueba de babas", 2, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Botas de lluvia ácida", 1, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Casco minero", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Ametralladora ACME", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Camiseta de la ETSIIT", 1, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Clavo de rail ferroviario", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Cuchillo de sushi arcano", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Fez alópodo", 3, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Hacha prehistórica", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 4, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Gaita", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Insecticida", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Escopeta de 3 cañones", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Garabato místico", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("La rebeca metálica", 2, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Lanzallamas", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Necro-comicón", 1, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necronomicón", 5, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Linterna a 2 manos", 3, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Necro-gnomicón", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necrotelecom", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Mazo de los antiguos", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necro-playboycón", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Porra preternatural", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Shogulador", 1, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Varita de atizamiento", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Tentáculo de pega", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Zapato deja-amigos", 1, TreasureKind::SHOE)

    end

    def initMonsterCardDeck

      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta", 
      0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
      @unusedMonsters << Monster.newMonster("3 Byakhess de bonanza", 8, badConsequence, prize)

      prize = Prize.new(1, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible", 
      0, [TreasureKind::HELMET], []) 
      @unusedMonsters << Monster.newMonster("Tenochtitlan", 2, badConsequence, prize)

      prize = Prize.new(1, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible", 
      0, [TreasureKind::SHOE], [])
      @unusedMonsters << Monster.newMonster("El sopor de Dunwich", 2, badConsequence, prize)

      prize = Prize.new(4, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y 
      te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
      @unusedMonsters << Monster.newMonster("Demonios de Magaluf", 2, badConsequence, prize)

      prize = Prize.new(3, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles", 0, BadConsequence.getMaxTreasures, 0)
      @unusedMonsters << Monster.newMonster("El gorrón en el umbral", 13, badConsequence, prize)

      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible", 0, [TreasureKind::ARMOR], [])
      @unusedMonsters << Monster.newMonster("H.P. Munchcraft", 6, badConsequence, prize)

      prize = Prize.new(1, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible", 
      0, [TreasureKind::ARMOR], [])
      @unusedMonsters << Monster.newMonster("Necrófago", 13, badConsequence, prize)

      prize = Prize.new(3, 2)
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles", 
      5, 3, 0)
      @unusedMonsters << Monster.newMonster("El rey de rosado", 11, badConsequence, prize)

      prize = Prize.new(1, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)
      @unusedMonsters << Monster.newMonster("Flecher", 2, badConsequence, prize)


      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newDeath("Estos monstruos resultan bastantes superficiales y te aburren mortalmente. Estás muerto", true)
      @unusedMonsters << Monster.newMonster("Los hondos", 8, badConsequence, prize)

      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2)
      @unusedMonsters << Monster.newMonster("Semillas Cthulhu", 4, badConsequence, prize)

      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible", 0, [TreasureKind::ONEHAND], [])
      @unusedMonsters << Monster.newMonster("Dameargo", 1, badConsequence, prize)

      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)
      @unusedMonsters << Monster.newMonster("Pollipólipo volante", 3, badConsequence, prize)

      prize = Prize.new(3, 1)
      badConsequence = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estás muerto", true)
      @unusedMonsters << Monster.newMonster("Yskhtihyssg-Goth", 14, badConsequence, prize)

      prize = Prize.new(3, 1)
      badConsequence = BadConsequence.newDeath("La familia te atrapa. Estás muerto", true)
      @unusedMonsters << Monster.newMonster("Familia feliz", 1, badConsequence, prize)

      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, [TreasureKind::BOTHHANDS], [])
      @unusedMonsters << Monster.newMonster("Roboggoth", 8, badConsequence, prize)

      prize = Prize.new(1, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible", 0, [TreasureKind::HELMET], [])
      @unusedMonsters << Monster.newMonster("El espía sordo", 5, badConsequence, prize)

      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)
      @unusedMonsters << Monster.newMonster("Tongue", 19, badConsequence, prize)

      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("Te faltan menos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 
        3, [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], [])
      @unusedMonsters << Monster.newMonster("Bicéfalo", 21, badConsequence, prize)

      # Monstruos con sectarios
      prize = Prize.new(3, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes una mano visible", 
        0, [TreasureKind::ONEHAND], [])
      @unusedMonsters << Monster.newCultistMonster("El mal indecible impronunciable", 10, badConsequence, prize, -2)
      
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes tus tesoros visibles. Ja ja ja", 0, BadConsequence.getMaxTreasures, 0)
      @unusedMonsters << Monster.newCultistMonster("Testigos Oculares", 6, badConsequence, prize, 2)

      prize = Prize.new(2, 5)
      badConsequence = BadConsequence.newDeath("Hoy no es tu día de suerte. Mueres", true)
      @unusedMonsters << Monster.newCultistMonster("El gran cthulhu", 20, badConsequence, prize, 4)
      
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Tu gobierno te recorta 2 niveles", 2, 0, 0)
      @unusedMonsters << Monster.newCultistMonster("Serpiente Político", 8, badConsequence, prize, -2)
      
      prize = Prize.new(1, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu casco y tu armadura visble. Pierdes tus manos ocultas", 
        0, [TreasureKind::ARMOR, TreasureKind::HELMET], [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::ONEHAND,
          TreasureKind::BOTHHANDS, TreasureKind::BOTHHANDS])
      @unusedMonsters << Monster.newCultistMonster("Felpuggoth", 2, badConsequence, prize, 5)
      
      prize = Prize.new(4, 2)
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles", 2, 0, 0)
      @unusedMonsters << Monster.newCultistMonster("Shoggoth", 16, badConsequence, prize, -4)
      
      prize = Prize.new(1, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0)
      @unusedMonsters << Monster.newCultistMonster("Lolitagooth", 2, badConsequence, prize, 3)
            
    end
    
    def initCultistCardDeck
      4.times do
        @unusedCultists << Cultist.new("Sectario", 1)
      end
      2.times do
        @unusedCultists << Cultist.new("Sectario", 2)
      end
      
    end

    def shuffleTreasures
      @unusedTreasures.shuffle!
    end

    def shuffleMonster
      @unusedMonsters.shuffle!
    end
    
    def shuffleCultists
      @unusedCultists.shuffle!
    end


    private_class_method :new

  end
end